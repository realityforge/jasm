/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.WordWidth;
import jasm.tools.InstructionDescription;
import jasm.tools.InstructionDescriptionCreator;
import jasm.tools.Trace;
import jasm.x86.X86InstructionPrefix;
import java.util.ArrayList;
import java.util.List;

public abstract class X86TemplateCreator<Template_Type extends X86Template<Template_Type>> {

  private final WordWidth _addressWidth;
  private final ArrayList<Template_Type> _templates = new ArrayList<Template_Type>();
  private X86InstructionDescription _instructionDescription;
  private InstructionAssessment _instructionAssessment;
  private X86TemplateContext _context;
  private int _serial = 1;

  protected X86TemplateCreator(WordWidth addressWidth) {
    _addressWidth = addressWidth;
  }

  public final List<Template_Type> templates() {
    return _templates;
  }

  private boolean isRedundant(Template_Type template) {
    for (X86Template other : templates()) {
      if (template.isRedundant(other)) {
        return true;
      }
    }
    return false;
  }

  protected abstract Template_Type createTemplate(X86InstructionDescription instructionDescription, int serial, boolean hasModRMByte, X86TemplateContext context);

  private void createTemplate() {
    if (_instructionDescription.getMandatoryPrefix() == X86InstructionPrefix.OPERAND_SIZE &&
        _context.operandSizeAttribute() == WordWidth.BITS_16) {
      return;
    }
    final Template_Type template = createTemplate(_instructionDescription, _serial, _instructionAssessment.hasModRMByte(), _context);
    if (X86InstructionDescriptionVisitor.Static.visitInstructionDescription(template, _instructionDescription)) {
      final InstructionDescription modRMInstructionDescription = template.modRMInstructionDescription();
      if (modRMInstructionDescription != null &&
          !X86InstructionDescriptionVisitor.Static.visitInstructionDescription(template, modRMInstructionDescription)) {
        return;
      }
      if (!isRedundant(template)) {
        Trace.line(3, "template: " + template);
        Trace.line(3);
        _templates.add(template);
        _serial++;
      }
    }
  }

  private void createTemplatesForSibBaseCases() {
    for (SibBaseCase sibBaseCase : SibBaseCase.values()) {
      if (sibBaseCase == SibBaseCase.GENERAL_REGISTER || _context.modCase() == ModCase.MOD_0) {
        _context = _context.clone();
        _context._sibBaseCase = sibBaseCase;
        createTemplate();
      }
    }
  }

  private void createTemplatesForSibIndexCases() {
    for (SibIndexCase sibIndexCase : SibIndexCase.values()) {
      _context = _context.clone();
      _context.setSibIndexCase(sibIndexCase);
      createTemplatesForSibBaseCases();
    }
  }

  private void createTemplatesForRMCases() {
    for (RMCase rmCase : RMCase.values()) {
      _context = _context.clone();
      _context.setRMCase(rmCase);
      switch (_context.modCase()) {
        case MOD_3: {
          if (rmCase == RMCase.NORMAL) {
            createTemplate();
          }
          break;
        }
        default: {
          switch (rmCase) {
            case SIB:
              createTemplatesForSibIndexCases();
              break;
            default:
              createTemplate();
              break;
          }
        }
      }
    }
  }

  private void createTemplatesForModRMGroups() {
    if (_instructionAssessment.modRMGroup() != null) {
      for (ModRMOpcode modRMGroupOpcode : ModRMOpcode.values()) {
        _context = _context.clone();
        _context.setModRMGroupOpcode(modRMGroupOpcode);
        createTemplatesForRMCases();
      }
    } else {
      createTemplatesForRMCases();
    }
  }

  private void createTemplatesForModCases(WordWidth operandSizeAttribute) {
    _context = _context.clone();
    _context.setOperandSizeAttribute(operandSizeAttribute);

    if (_instructionAssessment.hasModRMByte()) {
      for (ModCase modCase : ModCase.values()) {
        _context = _context.clone();
        _context.setModCase(modCase);
        createTemplatesForModRMGroups();
      }
    } else {
      createTemplate();
    }
  }

  private void createTemplatesForOperandSizeAttribute(WordWidth addressSizeAttribute) {
    _context = _context.clone();
    _context.setAddressSizeAttribute(addressSizeAttribute);

    if (_instructionDescription.requiredOperandSize() != null) {
      createTemplatesForModCases(_instructionDescription.requiredOperandSize());
    } else {
      if (_instructionDescription.defaultOperandSize() != WordWidth.BITS_64) {
        createTemplatesForModCases(WordWidth.BITS_32);
      }
      if (_addressWidth == WordWidth.BITS_64) {
        createTemplatesForModCases(WordWidth.BITS_64);
      }
      if (X86Config.are16BitOffsetsSupported() || !_instructionAssessment.isJump()) {
        createTemplatesForModCases(WordWidth.BITS_16);
      }
    }
  }

  private void createTemplatesForAddressSizeAttribute() {
    if (_instructionDescription.requiredAddressSize() != null) {
      if (X86Config.are16BitAddressesSupported() || _instructionDescription.requiredAddressSize() == _addressWidth) {
        createTemplatesForOperandSizeAttribute(_instructionDescription.requiredAddressSize());
      }
    } else {
      createTemplatesForOperandSizeAttribute(_addressWidth);
      if (X86Config.are16BitAddressesSupported() && _instructionAssessment.hasAddressSizeVariants()) {
        createTemplatesForOperandSizeAttribute(WordWidth.fromInt(_addressWidth.numberOfBits() / 2));
      }
    }
  }

  public final void createTemplates(InstructionDescriptionCreator<X86InstructionDescription> instructionDescriptionCreator) {
    for (X86InstructionDescription instructionDescription : instructionDescriptionCreator.instructionDescriptions()) {
      _instructionDescription = instructionDescription;
      _instructionAssessment = new InstructionAssessment();
      final OpcodeAssessor assessor = new OpcodeAssessor(_instructionAssessment);
      final String name = instructionDescription.name();
      if (null != name && name.startsWith("j")) {
        _instructionAssessment.beJump();
      }
      X86InstructionDescriptionVisitor.Static.visitInstructionDescription(assessor, _instructionDescription);
      _context = new X86TemplateContext();
      createTemplatesForAddressSizeAttribute();
    }
  }
}

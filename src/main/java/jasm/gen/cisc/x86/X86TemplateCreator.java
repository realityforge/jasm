/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.gen.InstructionDescription;
import jasm.gen.InstructionDescriptionCreator;
import jasm.gen.Trace;
import jasm.WordWidth;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernd Mathiske
 */
public abstract class X86TemplateCreator<Template_Type extends X86Template> {

    private final WordWidth _addressWidth;
    private final ArrayList<Template_Type> _templates = new ArrayList<Template_Type>();
    private X86InstructionDescription _instructionDescription;
    private InstructionAssessment _instructionAssessment;
    private X86TemplateContext _context;
    private int _serial = 1;

    protected X86TemplateCreator(WordWidth addressWidth) {
        _addressWidth = addressWidth;
    }

    public List<Template_Type> templates() {
        return _templates;
    }

    private boolean isRedundant(X86Template template) {
        for (X86Template other : templates()) {
            if (template.isRedundant(other)) {
                return true;
            }
        }
        return false;
    }

    protected abstract Template_Type createTemplate(X86InstructionDescription instructionDescription, int serial, InstructionAssessment instructionFamily, X86TemplateContext context);

    private void createTemplate() {
        final Template_Type template = createTemplate(_instructionDescription, _serial, _instructionAssessment, _context);
        if (X86InstructionDescriptionVisitor.Static.visitInstructionDescription(template, _instructionDescription)) {
            final InstructionDescription modRMInstructionDescription = template.modRMInstructionDescription();
            if (modRMInstructionDescription != null && !X86InstructionDescriptionVisitor.Static.visitInstructionDescription(template, modRMInstructionDescription)) {
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
        for (X86TemplateContext.SibBaseCase sibBaseCase : X86TemplateContext.SibBaseCase.values()) {
            if (sibBaseCase == X86TemplateContext.SibBaseCase.GENERAL_REGISTER || _context.modCase() == X86TemplateContext.ModCase.MOD_0) {
                _context = _context.clone();
                _context._sibBaseCase = sibBaseCase;
                createTemplate();
            }
        }
    }

    private void createTemplatesForSibIndexCases() {
        for (X86TemplateContext.SibIndexCase sibIndexCase : X86TemplateContext.SibIndexCase.values()) {
            _context = _context.clone();
            _context.setSibIndexCase(sibIndexCase);
            createTemplatesForSibBaseCases();
        }
    }

    private void createTemplatesForRMCases() {
        for (X86TemplateContext.RMCase rmCase : X86TemplateContext.RMCase.values()) {
            _context = _context.clone();
            _context.setRMCase(rmCase);
            switch (_context.modCase()) {
                case MOD_3: {
                    if (rmCase == X86TemplateContext.RMCase.NORMAL) {
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
            for (ModRMGroup.Opcode modRMGroupOpcode : ModRMGroup.Opcode.values()) {
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
            for (X86TemplateContext.ModCase modCase : X86TemplateContext.ModCase.values()) {
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
            if (X86Assembly.are16BitOffsetsSupported() || !_instructionAssessment.isJump()) {
                createTemplatesForModCases(WordWidth.BITS_16);
            }
        }
    }

    private void createTemplatesForAddressSizeAttribute() {
        if (_instructionDescription.requiredAddressSize() != null) {
            if (X86Assembly.are16BitAddressesSupported() || _instructionDescription.requiredAddressSize() == _addressWidth) {
                createTemplatesForOperandSizeAttribute(_instructionDescription.requiredAddressSize());
            }
        } else {
            createTemplatesForOperandSizeAttribute(_addressWidth);
            if (X86Assembly.are16BitAddressesSupported() && _instructionAssessment.hasAddressSizeVariants()) {
                createTemplatesForOperandSizeAttribute(WordWidth.fromInt(_addressWidth.numberOfBits() / 2));
            }
        }
    }

    public void createTemplates(InstructionDescriptionCreator<X86InstructionDescription> instructionDescriptionCreator) {
        for (X86InstructionDescription instructionDescription : instructionDescriptionCreator.instructionDescriptions()) {
            _instructionDescription = instructionDescription;
            _instructionAssessment = new InstructionAssessment();
            final OpcodeAssessor assessor = new OpcodeAssessor(_instructionAssessment);
            X86InstructionDescriptionVisitor.Static.visitInstructionDescription(assessor, _instructionDescription);
            _context = new X86TemplateContext();
            createTemplatesForAddressSizeAttribute();
        }
    }
}

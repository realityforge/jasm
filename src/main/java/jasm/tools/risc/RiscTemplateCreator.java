/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.tools.InstructionDescription;
import jasm.tools.risc.field.OptionField;
import jasm.util.StaticLoophole;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RiscTemplateCreator<Template_Type extends RiscTemplate<Template_Type>> {

  protected RiscTemplateCreator() {
  }

  private ArrayList<Template_Type> _templates = new ArrayList<Template_Type>();

  public final List<Template_Type> templates() {
    return _templates;
  }

  protected abstract Template_Type createTemplate(InstructionDescription instructionDescription);

  public final List<Template_Type> createOptionTemplates(List<Template_Type> templates, OptionField optionField) {
    final ArrayList<Template_Type> newTemplates = new ArrayList<Template_Type>();
    for (Template_Type template : templates) {
      Template_Type canonicalRepresentative = null;
      if (optionField.defaultOption() != null) {
        canonicalRepresentative = StaticLoophole.<Template_Type>cast(template.clone());
        canonicalRepresentative.organizeOption(optionField.defaultOption(), null);
      }
      for (Option option : optionField.options()) {
        if (option.equals(optionField.defaultOption())) {
          newTemplates.add(canonicalRepresentative);
        } else {
          final Template_Type templateWithOption = StaticLoophole.<Template_Type>cast(template.clone());
          templateWithOption.organizeOption(option, canonicalRepresentative);
          newTemplates.add(templateWithOption);
        }
      }
    }
    return newTemplates;
  }

  private int _serial;
  private final TemplateMap<Template_Type> _nameToTemplates = new TemplateMap<Template_Type>();

  public final List<Template_Type> nameToTemplates(String name) {
    return _nameToTemplates.get(name);
  }

  public final void createTemplates(RiscInstructionDescriptionCreator instructionDescriptionCreator) {
    final ArrayList<Template_Type> initialTemplates = new ArrayList<Template_Type>();
    for (InstructionDescription instructionDescription : instructionDescriptionCreator.instructionDescriptions()) {
      final Template_Type template = createTemplate(instructionDescription);
      initialTemplates.add(template);
      RiscInstructionDescriptionVisitor.Static.visitInstructionDescription(template, instructionDescription);
    }
    for (Template_Type initialTemplate : initialTemplates) {
      List<Template_Type> newTemplates = StaticLoophole.asList(initialTemplate);
      for (OptionField optionField : initialTemplate.optionFields()) {
        newTemplates = createOptionTemplates(newTemplates, optionField);
      }
      for (Template_Type template : newTemplates) {
        _serial++;
        template.setSerial(_serial);
        _templates.add(template);
        _nameToTemplates.add(template.internalName(), template);

        // Create the link to the non-synthetic instruction from which a synthetic instruction is derived.
        if (template.description().isSynthetic()) {
          boolean found = false;
          final Iterator<Template_Type> iterator = _nameToTemplates.iterator();
          while (iterator.hasNext() && !found) {
            final Template_Type rawTemplate = iterator.next();
            if (!rawTemplate.description().isSynthetic() && (template.opcodeMask() & rawTemplate.opcodeMask()) == rawTemplate.opcodeMask() &&
                (template.opcode() & rawTemplate.opcodeMask()) == rawTemplate.opcode()) {
              template.setSynthesizedFrom(rawTemplate);
              found = true;
            }
          }
          if (!found) throw new IllegalStateException("Program Error");
        }
      }
    }
  }
}

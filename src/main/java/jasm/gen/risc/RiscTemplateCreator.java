/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc;

import jasm.gen.InstructionDescription;
import jasm.gen.risc.field.OptionField;
import jasm.util.lang.StaticLoophole;
import jasm.util.program.ProgramError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class RiscTemplateCreator<Template_Type extends RiscTemplate> {

    protected RiscTemplateCreator() {
    }

    private ArrayList<Template_Type> _templates = new ArrayList<Template_Type>();

    public final List<Template_Type> templates() {
        return _templates;
    }

    protected abstract Template_Type createTemplate(InstructionDescription instructionDescription);

    public final List<Template_Type> createOptionTemplates(List<Template_Type> templates, OptionField optionField) {
        final Class<Template_Type> templateType = null;
        final ArrayList<Template_Type> newTemplates = new ArrayList<Template_Type>();
        for (Template_Type template : templates) {
            Template_Type canonicalRepresentative = null;
            if (optionField.defaultOption() != null) {
                canonicalRepresentative = StaticLoophole.cast(templateType, template.clone());
                canonicalRepresentative.organizeOption(optionField.defaultOption(), null);
            }
            for (Option option : optionField.options()) {
                if (option.equals(optionField.defaultOption())) {
                    newTemplates.add(canonicalRepresentative);
                } else {
                    final Template_Type templateWithOption = StaticLoophole.cast(templateType, template.clone());
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
            List<Template_Type> newTemplates = Arrays.asList(initialTemplate);
            for (OptionField optionField : initialTemplate.optionFields()) {
                newTemplates = createOptionTemplates(newTemplates, optionField);
            }
            for (Template_Type template : newTemplates) {
                _serial++;
                template.setSerial(_serial);
                _templates.add(template);
                _nameToTemplates.add(template.internalName(), template);

                // Create the link to the non-synthetic instruction from which a synthetic instruction is derived.
                if (template.instructionDescription().isSynthetic()) {
                    boolean found = false;
                    final Iterator<Template_Type> iterator = _nameToTemplates.iterator();
                    while (iterator.hasNext() && !found) {
                        final Template_Type rawTemplate = iterator.next();
                        if (!rawTemplate.instructionDescription().isSynthetic() && (template.opcodeMask() & rawTemplate.opcodeMask()) == rawTemplate.opcodeMask() &&
                                        (template.opcode() & rawTemplate.opcodeMask()) == rawTemplate.opcode()) {
                            template.setSynthesizedFrom(rawTemplate);
                            found = true;
                        }
                    }
                    ProgramError.check(found);
                }
            }
        }
    }
}

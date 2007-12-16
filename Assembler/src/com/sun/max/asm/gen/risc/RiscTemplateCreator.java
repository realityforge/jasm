/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7bf27cbf-e57b-4654-a576-7fd03238616d*/
package com.sun.max.asm.gen.risc;

import java.util.*;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.field.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;

/**
 * 
 *
 * @author Bernd Mathiske
 */
public abstract class RiscTemplateCreator<Template_Type extends RiscTemplate> {

    protected RiscTemplateCreator() {    
    }
    
    private AppendableSequence<Template_Type> _templates = new ArrayListSequence<Template_Type>();
    
    public Sequence<Template_Type> templates() {
        return _templates;
    }

    protected abstract Template_Type createTemplate(InstructionDescription instructionDescription);
    
    public Sequence<Template_Type> createOptionTemplates(Sequence<Template_Type> templates, OptionField optionField) {
        final Class<Template_Type> templateType = null;
        final AppendableSequence<Template_Type> newTemplates = new ArrayListSequence<Template_Type>();
        for (Template_Type template : templates) {
            Template_Type canonicalRepresentative = null;
            if (optionField.defaultOption() != null) {
                canonicalRepresentative = StaticLoophole.cast(templateType, template.clone());
                canonicalRepresentative.organizeOption(optionField.defaultOption(), null);
            }
            for (Option option : optionField.options()) {
                if (option.equals(optionField.defaultOption())) {
                    newTemplates.append(canonicalRepresentative); 
                } else {
                    final Template_Type templateWithOption = StaticLoophole.cast(templateType, template.clone());
                    templateWithOption.organizeOption(option, canonicalRepresentative);
                    newTemplates.append(templateWithOption);
                }
            }
        }
        return newTemplates;
    }

    private int _serial;
    private MultiMap<String, Template_Type, Sequence<Template_Type>> _nameToTemplates = new SequenceMultiMap<String, Template_Type>(false);
    
    public Sequence<Template_Type> nameToTemplates(String name) {
        return _nameToTemplates.get(name);
    }
    
    public void createTemplates(RiscInstructionDescriptionCreator instructionDescriptionCreator) {
        final AppendableSequence<Template_Type> initialTemplates = new ArrayListSequence<Template_Type>();
        for (InstructionDescription instructionDescription : instructionDescriptionCreator.instructionDescriptions()) {
            final Template_Type template = createTemplate(instructionDescription);
            initialTemplates.append(template);
            RiscInstructionDescriptionVisitor.Static.visitInstructionDescription(template, instructionDescription);
        }
        for (Template_Type initialTemplate : initialTemplates) {
            Sequence<Template_Type> newTemplates = new ArrayListSequence<Template_Type>(initialTemplate);
            for (OptionField optionField : initialTemplate.optionFields()) {
                newTemplates = createOptionTemplates(newTemplates, optionField);
            }
            for (Template_Type template : newTemplates) {
                _serial++;
                template.setSerial(_serial);
                _templates.append(template);
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

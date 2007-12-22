/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc;

import jasm.gen.Assembly;
import jasm.gen.InstructionConstraint;
import jasm.gen.InstructionDescriptionCreator;
import jasm.gen.Parameter;
import jasm.gen.Trace;
import jasm.gen.risc.bitRange.OmittedBitRange;
import jasm.gen.risc.field.OperandField;
import jasm.gen.risc.field.OptionField;
import jasm.gen.risc.field.RiscField;
import jasm.util.collect.AppendableSequence;
import jasm.util.collect.ArrayListSequence;
import jasm.util.collect.MutableSequence;
import jasm.util.collect.Sequence;
import jasm.util.lang.StaticLoophole;
import jasm.util.program.ProgramError;
import java.util.Iterator;
import java.util.List;

/**
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public abstract class RiscInstructionDescriptionCreator extends InstructionDescriptionCreator<RiscInstructionDescription> {

    protected final RiscTemplateCreator<? extends RiscTemplate> _templateCreator;

    protected RiscInstructionDescriptionCreator(Assembly assembly, RiscTemplateCreator<? extends RiscTemplate> templateCreator) {
        super(assembly);
        _templateCreator = templateCreator;
    }

    @Override
    protected RiscInstructionDescription createInstructionDescription(MutableSequence<Object> specifications) {
        return new RiscInstructionDescription(specifications);
    }

    private int firstStringIndex(List<Object> specifications) {
        for (int i = 0; i < specifications.size(); i++) {
            if (specifications.get(i) instanceof String) {
                return i;
            }
        }
        ProgramError.unexpected("template instruction description without name");
        return -1;
    }

    private void setFirstString(List<Object> specifications, String value) {
        specifications.set(firstStringIndex(specifications), value);
    }

    private void eliminateConstraintFor(Parameter parameter, List<Object> specifications) {
        for (final Iterator iterator = specifications.iterator(); iterator.hasNext();) {
            final Object s = iterator.next();
            if (s instanceof InstructionConstraint) {
                final InstructionConstraint constraint = (InstructionConstraint) s;
                if (constraint.referencesParameter(parameter)) {
                    iterator.remove();
                }
            }
        }
    }

    private boolean updateSpecifications(List<Object> specifications, Object pattern) {
        for (int i = 0; i < specifications.size(); i++) {
            final Object specification = specifications.get(i);
            if (specification.equals(pattern)) {
                specifications.set(i, pattern);
                return true;
            } else if (pattern instanceof RiscConstant && (specification instanceof OperandField || specification instanceof OptionField)) {
                final RiscConstant constant = (RiscConstant) pattern;
                final RiscField constantField = constant.field();
                final RiscField variableField = (RiscField) specification;
                if (variableField.equals(constantField)) {
                    specifications.set(i, pattern);
                    if (specification instanceof Parameter) {
                        eliminateConstraintFor((Parameter) specification, specifications);
                    }
                    return true;
                }
            } else if (pattern instanceof InstructionConstraint && !(pattern instanceof Parameter)) {
                specifications.add(pattern);
                return true;
            } else if (pattern instanceof RiscField) {
                if (((RiscField) pattern).bitRange() instanceof OmittedBitRange) {
                    specifications.add(pattern);
                    return true;
                }
            }
        }
        return false;
    }

    private RiscInstructionDescription createSyntheticInstructionDescription(String name, RiscTemplate template, Object[] patterns) {
        final List<Object> specifications = new ArrayListSequence<Object>(template.instructionDescription().specifications());
        for (Object pattern : patterns) {
            if (!updateSpecifications(specifications, pattern)) {
                // InstructionDescription with the same name, but different specifications, skip it:
                Trace.line(3, name + " not updated with " + pattern + " in " + specifications);
                return null;
            }
        }
        setFirstString(specifications, name);
        final MutableSequence<Object> sequence = StaticLoophole.cast(specifications);
      return (RiscInstructionDescription) defineInstructionDescription(sequence).beSynthetic();
    }

    /**
     * Creates a synthetic instruction from a previously defined (raw or synthetic) instruction
     * by replacing one or more parameters of the instruction with a constant or alternative parameter.
     *
     * @param name          the internal (base) name of the new synthetic instruction
     * @param templateName  the internal name of the original instruction on which the synthetic instruction is based
     * @param patterns      the replacements for one or more parameters of the original instruction
     * @return the newly created instruction descriptions resulting from the substitution wrapped in a RiscInstructionDescriptionModifier
     */
    protected RiscInstructionDescriptionModifier synthesize(String name, String templateName, Object... patterns) {
        final AppendableSequence<RiscInstructionDescription> instructionDescriptions = new ArrayListSequence<RiscInstructionDescription>();
        // Creating a new VariableSequence here prevents iterator comodification below:
        final Sequence<? extends RiscTemplate> nameTemplates = _templateCreator.nameToTemplates(templateName);
        if (!nameTemplates.isEmpty()) {
            final Sequence<RiscTemplate> templates = new ArrayListSequence<RiscTemplate>(nameTemplates);
            assert !templates.isEmpty();
            for (RiscTemplate template : templates) {
                final RiscInstructionDescription instructionDescription = createSyntheticInstructionDescription(name, template, patterns);
                if (instructionDescription != null) {
                    instructionDescriptions.append(instructionDescription);
                }
            }
        }
        ProgramError.check(!instructionDescriptions.isEmpty());
        return new RiscInstructionDescriptionModifier(instructionDescriptions);
    }
}

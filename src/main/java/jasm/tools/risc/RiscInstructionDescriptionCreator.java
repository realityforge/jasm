/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.tools.Assembly;
import jasm.tools.InstructionConstraint;
import jasm.tools.InstructionDescriptionCreator;
import jasm.tools.Parameter;
import jasm.tools.Trace;
import jasm.tools.risc.bitRange.OmittedBitRange;
import jasm.tools.risc.field.OperandField;
import jasm.tools.risc.field.OptionField;
import jasm.tools.risc.field.RiscField;
import jasm.util.StaticLoophole;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class RiscInstructionDescriptionCreator
    extends InstructionDescriptionCreator<RiscInstructionDescription> {

  protected final RiscTemplateCreator<? extends RiscTemplate> _templateCreator;
  private String _currentArchitectureManualSection;

  protected RiscInstructionDescriptionCreator(Assembly assembly, RiscTemplateCreator<? extends RiscTemplate> templateCreator) {
    super(assembly);
    _templateCreator = templateCreator;
  }

  private int firstStringIndex(List<Object> specifications) {
    for (int i = 0; i < specifications.size(); i++) {
      if (specifications.get(i) instanceof String) {
        return i;
      }
    }
    throw new IllegalStateException("template instruction description without name");
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
      } else
      if (pattern instanceof RiscConstant && (specification instanceof OperandField || specification instanceof OptionField)) {
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
    final ArrayList<Object> specifications = new ArrayList<Object>();
    specifications.addAll(template.description().specifications());
    for (Object pattern : patterns) {
      if (!updateSpecifications(specifications, pattern)) {
        // InstructionDescription with the same name, but different specifications, skip it:
        Trace.line(3, name + " not updated with " + pattern + " in " + specifications);
        return null;
      }
    }
    setFirstString(specifications, name);
    final List<Object> sequence = StaticLoophole.cast(specifications);
    return (RiscInstructionDescription) defineInstructionDescription(sequence).beSynthetic();
  }

  /**
   * Creates a synthetic instruction from a previously defined (raw or synthetic) instruction
   * by replacing one or more parameters of the instruction with a constant or alternative parameter.
   *
   * @param name         the internal (base) name of the new synthetic instruction
   * @param templateName the internal name of the original instruction on which the synthetic instruction is based
   * @param patterns     the replacements for one or more parameters of the original instruction
   * @return the newly created instruction descriptions resulting from the substitution wrapped in a RiscInstructionDescriptionModifier
   */
  protected final RiscInstructionDescriptionModifier synthesize(String name, String templateName, Object... patterns) {
    final ArrayList<RiscInstructionDescription> instructionDescriptions = new ArrayList<RiscInstructionDescription>();
    // Creating a new VariableSequence here prevents iterator comodification below:
    final List<? extends RiscTemplate> nameTemplates = _templateCreator.nameToTemplates(templateName);
    if (!nameTemplates.isEmpty()) {
      final ArrayList<RiscTemplate> templates = new ArrayList<RiscTemplate>();
      templates.addAll(nameTemplates);
      assert !templates.isEmpty();
      for (RiscTemplate template : templates) {
        final RiscInstructionDescription instructionDescription = createSyntheticInstructionDescription(name, template, patterns);
        if (instructionDescription != null) {
          instructionDescriptions.add(instructionDescription);
        }
      }
    }
    boolean condition = !instructionDescriptions.isEmpty();
    if (!condition) throw new IllegalStateException("Program Error");
    return new RiscInstructionDescriptionModifier(instructionDescriptions);
  }

  private static Object[] flatten(Object[] array) {
    final ArrayList<Object> objects = new ArrayList<Object>();
    for (Object outer : array) {
      if (outer instanceof Object[]) {
        objects.addAll(Arrays.asList(flatten((Object[]) outer)));
      } else {
        objects.add(outer);
      }
    }
    return objects.toArray(StaticLoophole.createArray(Object.class, objects.size()));
  }

  protected final RiscInstructionDescription defineInstructionDescription(List<Object> specifications) {
    final RiscInstructionDescription description = new RiscInstructionDescription(_currentArchitectureManualSection, specifications);
    registerDescription(description);
    return description;
  }

  protected RiscInstructionDescription define(Object... specifications) {
    return defineInstructionDescription(Arrays.asList(flatten(specifications)));
  }

  protected final RiscInstructionDescription createInstructionDescription(final String currentArchitectureManualSection,
                                                                          List<Object> specifications) {
    return new RiscInstructionDescription(currentArchitectureManualSection, specifications);
  }

  /**
   * Sets the name of the architecture manual section for which instruction descriptions are
   * currently being {@link #define defined}.
   */
  public final void setCurrentArchitectureManualSection(String section) {
    _currentArchitectureManualSection = section;
  }
}

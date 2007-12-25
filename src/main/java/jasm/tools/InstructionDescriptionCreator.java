/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools;

import jasm.util.ArrayUtil;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Wraps mere object arrays into instruction descriptions.
 */
public abstract class InstructionDescriptionCreator<InstructionDescription_Type extends InstructionDescription> {

  private final Assembly _assembly;

  protected InstructionDescriptionCreator(Assembly assembly) {
    _assembly = assembly;
  }

  public Assembly assembly() {
    return _assembly;
  }

  protected abstract InstructionDescription_Type createInstructionDescription(List<Object> specifications);

  protected final InstructionDescription_Type defineInstructionDescription(List<Object> specifications) {
    final InstructionDescription_Type instructionDescription = createInstructionDescription(specifications);
    _instructionDescriptions.addLast(instructionDescription);
    instructionDescription.setArchitectureManualSection(_currentArchitectureManualSection);
    return instructionDescription;
  }

  private final LinkedList<InstructionDescription_Type> _instructionDescriptions = new LinkedList<InstructionDescription_Type>();

  protected InstructionDescription_Type define(Object... specifications) {
    final Object[] objects = ArrayUtil.flatten(specifications);
    return defineInstructionDescription(Arrays.asList(objects));
  }

  private String _currentArchitectureManualSection;

  /**
   * Sets the name of the architecture manual section for which instruction descriptions are
   * currently being {@link #define defined}.
   */
  public final void setCurrentArchitectureManualSection(String section) {
    _currentArchitectureManualSection = section;
  }

  public final LinkedList<InstructionDescription_Type> instructionDescriptions() {
    return _instructionDescriptions;
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** Wraps mere object arrays into instruction descriptions. */
public abstract class InstructionDescriptionCreator<InstructionDescription_Type extends InstructionDescription<InstructionDescription_Type>> {

  private final Assembly _assembly;
  private final LinkedList<InstructionDescription_Type> _descriptions = new LinkedList<InstructionDescription_Type>();
  private String _currentArchitectureManualSection;

  protected InstructionDescriptionCreator(Assembly assembly) {
    _assembly = assembly;
  }

  public Assembly assembly() {
    return _assembly;
  }

  protected abstract InstructionDescription_Type createInstructionDescription(List<Object> specifications);

  protected final InstructionDescription_Type defineInstructionDescription(List<Object> specifications) {
    final InstructionDescription_Type description = createInstructionDescription(specifications);
    _descriptions.addLast(description);
    description.setArchitectureManualSection(_currentArchitectureManualSection);
    return description;
  }

  protected InstructionDescription_Type define(Object... specifications) {
    return defineInstructionDescription(Arrays.asList(specifications));
  }

  /**
   * Sets the name of the architecture manual section for which instruction descriptions are
   * currently being {@link #define defined}.
   */
  public final void setCurrentArchitectureManualSection(String section) {
    _currentArchitectureManualSection = section;
  }

  public final LinkedList<InstructionDescription_Type> instructionDescriptions() {
    return _descriptions;
  }
}

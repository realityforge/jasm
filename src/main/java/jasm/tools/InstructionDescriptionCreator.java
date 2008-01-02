/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools;

import java.util.LinkedList;

/** Wraps mere object arrays into instruction descriptions. */
public abstract class InstructionDescriptionCreator<InstructionDescription_Type extends InstructionDescription<InstructionDescription_Type>> {

  private final Assembly _assembly;
  private final LinkedList<InstructionDescription_Type> _descriptions = new LinkedList<InstructionDescription_Type>();

  protected InstructionDescriptionCreator(Assembly assembly) {
    _assembly = assembly;
  }

  public Assembly assembly() {
    return _assembly;
  }

  protected final void registerDescription(final InstructionDescription_Type description) {
    _descriptions.addLast(description);
  }

  public final LinkedList<InstructionDescription_Type> instructionDescriptions() {
    return _descriptions;
  }
}

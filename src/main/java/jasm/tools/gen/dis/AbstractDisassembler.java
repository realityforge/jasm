/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.gen.dis;

import jasm.InstructionSet;

public abstract class AbstractDisassembler {
  private final InstructionSet _instructionSet;

  protected AbstractDisassembler(final InstructionSet instructionSet) {
    _instructionSet = instructionSet;
  }

  public final InstructionSet instructionSet() { return _instructionSet; }
}

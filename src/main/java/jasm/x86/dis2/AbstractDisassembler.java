/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86.dis2;

import jasm.InstructionSet;
import jasm.WordWidth;

public abstract class AbstractDisassembler {
  private final InstructionSet _instructionSet;
  private final WordWidth _addressWidth;

  protected AbstractDisassembler(final InstructionSet instructionSet,
                                 final WordWidth addressWidth) {
    _instructionSet = instructionSet;
    _addressWidth = addressWidth;
  }

  public final InstructionSet instructionSet() { return _instructionSet; }

  public final WordWidth addressWidth() { return _addressWidth; }
}

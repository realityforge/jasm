/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

public enum InstructionSet {
  AMD64(RelativeAddressing.FROM_INSTRUCTION_END),
  IA32(RelativeAddressing.FROM_INSTRUCTION_END),
  PPC(RelativeAddressing.FROM_INSTRUCTION_START),
  SPARC(RelativeAddressing.FROM_INSTRUCTION_START);

  public enum RelativeAddressing { FROM_INSTRUCTION_START, FROM_INSTRUCTION_END }

  private final RelativeAddressing _relativeAddressing;

  private InstructionSet(RelativeAddressing relativeAddressing) {
    _relativeAddressing = relativeAddressing;
  }

  public RelativeAddressing relativeAddressing() { return _relativeAddressing; }

  @Override
  public String toString() {
    return name();
  }
}

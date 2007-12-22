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
  AMD64(Category.CISC, Endianness.LITTLE, RelativeAddressing.FROM_INSTRUCTION_END),
  IA32(Category.CISC, Endianness.LITTLE, RelativeAddressing.FROM_INSTRUCTION_END),
  PPC(Category.RISC, Endianness.BIG, RelativeAddressing.FROM_INSTRUCTION_START),
  SPARC(Category.RISC, Endianness.BIG, RelativeAddressing.FROM_INSTRUCTION_START);

  public enum Category { CISC, RISC }

  public enum RelativeAddressing { FROM_INSTRUCTION_START, FROM_INSTRUCTION_END }

  private final Category _category;
  private final Endianness _endianness;
  private final RelativeAddressing _relativeAddressing;

  private InstructionSet(final Category category, final Endianness endianness, RelativeAddressing relativeAddressing) {
    _category = category;
    _endianness = endianness;
    _relativeAddressing = relativeAddressing;
  }

  public Category getCategory() { return _category; }

  public Endianness getEndianness() { return _endianness; }

  public RelativeAddressing relativeAddressing() { return _relativeAddressing; }

  @Override
  public String toString() {
    return name();
  }
}

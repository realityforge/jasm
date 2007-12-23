/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.field;

import jasm.gen.risc.bitRange.BitRange;
import jasm.util.NamedField;
import jasm.util.program.ProgramError;

/**
 * A field describes a bit range and how it relates to an operand.
 *
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public abstract class RiscField
    extends NamedField
    implements Cloneable {

  private final BitRange _bitRange;

  protected RiscField(String name, BitRange bitRange) {
    super(name);
    _bitRange = bitRange;
  }

  protected RiscField(BitRange bitRange) {
    this(null, bitRange);
  }

  @Override
  public RiscField clone() {
    try {
      return (RiscField) super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      ProgramError.unexpected("Field.clone() not supported");
    }
    return null;
  }

  public final BitRange bitRange() {
    return _bitRange;
  }

  /**
   * Two RISC fields are considered equal if they define the same set of bits in an instruction
   * (i.e. their bit ranges are equal).
   */
  @Override
  public final boolean equals(Object other) {
    if (other instanceof RiscField) {
      final RiscField riscField = (RiscField) other;
      return bitRange().equals(riscField.bitRange());
    }
    return false;
  }

  @Override
  public final int hashCode() {
    int result = _bitRange.hashCode();
    if (name() != null) {
      result ^= name().hashCode();
    }
    return result;
  }

  @Override
  public final String toString() {
    return name();
  }
}

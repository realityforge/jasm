/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

/** See section A.2.1 for further details. */
public enum AddressingMethodCode {
  /** Direct address. No ModR/M byte or SIB. */
  A(true, false),
  /** The reg field of the ModR/M byte selects a control register. */
  C(false, true),
  /** The reg field of the ModR/M byte selects a debug register. */
  D(false, true),
  /**
   * The ModR/M byte specifies the operand that is either a register or a memory
   * address. If a memory address it is computed from segment register, SIB and/or
   * displacement.
   */
  E(true, true),
  /** EFlags/RFlags register */
  F(false, false),
  /** The reg field of the ModR/M byte selects a general register. */
  G(false, true),
  /** we made this one up, it's like G, but with ParameterPlace.OPCODE1/2{_REXB} instead of a ModRM field */
  Go(false, false),
  /** Immediate data follows the instruction. */
  I(false, false),
  /** we made this one up, it's like I, but with parameter type AMD64XMMComparison */
  IC(false, false),
  /** The instruction contains a relative offset added to instruction pointer register. */
  J(false, false),
  /** The ModR/M byte may only refer to memory. */
  M(true, true),
  /** The reg field of the ModR/M byte selects a packed quadword, MMX register. */
  N(false, false),
  /**
   * The instruction has no ModR/M byte or SIB byte. The offset is encoded in
   * instruction as a word or double word (depending on address size attribute).
   */
  O(true, false),
  /** The reg field of the ModR/M byte selects a packed quadword, MMX register. */
  P(false, true),
  PR(false, true),
  /**
   * A ModR/M byte follows the opcode and specifies the operand. The operand is
   * either an MMX technology register or a memory address. If it is a memory
   * address, the address is computed from a segment register and any of the
   * following values: a base register, an index register, a scaling factor, and a
   * displacement.
   */
  Q(true, true),
  /** The R/M field of the ModR/M byte may refer only to a general register. */
  R(false, true),
  /** The reg field of the ModR/M byte selects a segment register */
  S(false, true),
  /** The R/M field of the ModR/M byte selects a 128-bit XMM register. */
  U(false, true),
  /** The reg field of the ModR/M byte selects a 128-bit XMM register. */
  V(false, true),
  /**
   * A ModR/M byte follows the opcode and specifies the operand. The operand is
   * either a 128-bit XMM register or a memory address. If it is a memory
   * address, the address is computed from a segment register and any of the
   * following values: a base register, an index register, a scaling factor, and a
   * displacement.
   */
  W(true, true),
  /** Memory addressed by the ES.rSI register pair. */
  X(false, false),
  /** Memory addressed by the ES.rDI register pair. */
  Y(false, false);

  private final boolean _hasAddressSizeVariants;
  private final boolean _hasModRMByte;

  AddressingMethodCode(final boolean hasAddressSizeVariants,
                       final boolean hasModRMByte) {
    _hasAddressSizeVariants = hasAddressSizeVariants;
    _hasModRMByte = hasModRMByte;
  }

  public boolean hasModRMByte() {
    return _hasModRMByte;
  }

  public boolean hasAddressSizeVariants() {
    return _hasAddressSizeVariants;
  }
}

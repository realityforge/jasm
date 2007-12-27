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
  A,
  /** The reg field of the ModR/M byte selects a control register. */
  C,
  /** The reg field of the ModR/M byte selects a debug register. */
  D,
  /**
   * The ModR/M byte specifies the operand that is either a register or a memory
   * address. If a memory address it is computed from segment register, SIB and/or
   * displacement.
   */
  E,
  /** EFlags/RFlags register */
  F,
  /** The reg field of the ModR/M byte selects a general register. */
  G,
  /** we made this one up, it's like G, but with ParameterPlace.OPCODE1/2{_REXB} instead of a ModRM field */
  Go,
  /** Immediate data follows the instruction. */
  I,
  /** we made this one up, it's like I, but with parameter type AMD64XMMComparison */
  IC,
  /** The instruction contains a relative offset added to instruction pointer register. */
  J,
  /** The ModR/M byte may only refer to memory. */
  M,
  /** The reg field of the ModR/M byte selects a packed quadword, MMX register. */
  N,
  /**
   * The instruction has no ModR/M byte or SIB byte. The offset is encoded in
   * instruction as a word or double word (depending on address size attribute).
   */
  O,
  /** The reg field of the ModR/M byte selects a packed quadword, MMX register. */
  P,
  PR,
  /**
   * A ModR/M byte follows the opcode and specifies the operand. The operand is
   * either an MMX technology register or a memory address. If it is a memory
   * address, the address is computed from a segment register and any of the
   * following values: a base register, an index register, a scaling factor, and a
   * displacement.
   */
  Q,
  /** The R/M field of the ModR/M byte may refer only to a general register. */
  R,
  /** The reg field of the ModR/M byte selects a segment register */
  S,
  /** The R/M field of the ModR/M byte selects a 128-bit XMM register. */
  U,
  /** The reg field of the ModR/M byte selects a 128-bit XMM register. */
  V,
  /**
   * A ModR/M byte follows the opcode and specifies the operand. The operand is
   * either a 128-bit XMM register or a memory address. If it is a memory
   * address, the address is computed from a segment register and any of the
   * following values: a base register, an index register, a scaling factor, and a
   * displacement.
   */
  W,
  /** Memory addressed by the ES.rSI register pair. */
  X,
  /** Memory addressed by the ES.rDI register pair. */
  Y
}

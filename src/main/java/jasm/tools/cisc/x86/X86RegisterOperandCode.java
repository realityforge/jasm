/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.WordWidth;
import static jasm.WordWidth.*;

/**
 * Register codes associated with instructions.
 *
 * Volume 2A, Section 3.1.1.1, Table 3-1
 */
public enum X86RegisterOperandCode {

  AL(BITS_8, 0, false),
  CL(BITS_8, 1, false),
  DL(BITS_8, 2, false),
  BL(BITS_8, 3, false),
  AH(BITS_8, 4, false),
  CH(BITS_8, 5, false),
  DH(BITS_8, 6, false),
  BH(BITS_8, 7, false),

  SPL(BITS_8, 4, true),
  BPL(BITS_8, 5, true),
  SIL(BITS_8, 6, true),
  DIL(BITS_8, 7, true),

  R8L(BITS_8, 0, true),
  R9L(BITS_8, 1, true),
  R10L(BITS_8, 2, true),
  R11L(BITS_8, 3, true),
  R12L(BITS_8, 4, true),
  R13L(BITS_8, 5, true),
  R14L(BITS_8, 6, true),
  R15L(BITS_8, 7, true),

  AX(BITS_16, 0, false),
  CX(BITS_16, 1, false),
  DX(BITS_16, 2, false),
  BX(BITS_16, 3, false),
  SP(BITS_16, 4, false),
  BP(BITS_16, 5, false),
  SI(BITS_16, 6, false),
  DI(BITS_16, 7, false),

  R8W(BITS_16, 0, true),
  R9W(BITS_16, 1, true),
  R10W(BITS_16, 2, true),
  R11W(BITS_16, 3, true),
  R12W(BITS_16, 4, true),
  R13W(BITS_16, 5, true),
  R14W(BITS_16, 6, true),
  R15W(BITS_16, 7, true),

  EAX(BITS_32, 0, false),
  ECX(BITS_32, 1, false),
  EDX(BITS_32, 2, false),
  EBX(BITS_32, 3, false),
  ESP(BITS_32, 4, false),
  EBP(BITS_32, 5, false),
  ESI(BITS_32, 6, false),
  EDI(BITS_32, 7, false),

  R8D(BITS_32, 0, true),
  R9D(BITS_32, 1, true),
  R10D(BITS_32, 2, true),
  R11D(BITS_32, 3, true),
  R12D(BITS_32, 4, true),
  R13D(BITS_32, 5, true),
  R14D(BITS_32, 6, true),
  R15D(BITS_32, 7, true),

  RAX(BITS_64, 0, false),
  RCX(BITS_64, 1, false),
  RDX(BITS_64, 2, false),
  RBX(BITS_64, 3, false),
  RSP(BITS_64, 4, false),
  RBP(BITS_64, 5, false),
  RSI(BITS_64, 6, false),
  RDI(BITS_64, 7, false),

  R8(BITS_64, 0, true),
  R9(BITS_64, 1, true),
  R10(BITS_64, 2, true),
  R11(BITS_64, 3, true),
  R12(BITS_64, 4, true),
  R13(BITS_64, 5, true),
  R14(BITS_64, 6, true),
  R15(BITS_64, 7, true);

  /** Size of word associated with RegisterCode. */
  private final WordWidth _width;
  private final int _regField;
  private final boolean _rexB;

  X86RegisterOperandCode(final WordWidth width,
                         final int regField,
                         final boolean rexB) {
    _width = width;
    _regField = regField;
    _rexB = rexB;
  }

  public WordWidth width() { return _width; }

  public int regField() { return _regField; }

  /** @return true if REX.B must be set. */
  public boolean rexB() { return _rexB; }
}
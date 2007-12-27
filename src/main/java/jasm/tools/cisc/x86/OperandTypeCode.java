/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

/** See section A.2.2 */
public enum OperandTypeCode {
  /**
   * Two one-word operands in memory or two double-word operands in memory,
   * depending on operand-size attribute (used only by the BOUND instruction).
   */
  a,
  /** Byte, regardless of operand-size attribute. */
  b,
  /** Byte or word, depending on operand-size attribute. */
  c,
  /** Doubleword, regardless of operand-size attribute. */
  d,
  /** Double-quadword, regardless of operand-size attribute. */
  dq,
  d_q,
  /** 32-bit, 48-bit, or 80-bit pointer, depending on operand-size attribute. */
  p,
  /** 128-bit packed double-precision floating-point data. */
  pd,
  /** Quadword MMX technology register (for example: mm0). */
  UNUSED_pi,
  /** 128-bit packed single-precision floating-point data. */
  ps,
  /** Quadword, regardless of operand-size attribute. */
  q,
  /** 6-byte or 10-byte pseudo-descriptor. */
  s,
  sd,
  /** Scalar element of a 128-bit packed single-precision floating data. */
  ss,
  /** Doubleword integer register (for example: eax). */
  UNUSED_si,
  /** Word, doubleword or quadword (in 64-bit mode), depending on operand-size attribute. */
  v,
  /** Word, regardless of operand-size attribute. */
  w,
  /** we made this one up: a double word if operand size 32, a quad word if 64, undefined if 16. */
  y,
  /** Word for 16-bit operand-size or doubleword for 32 or 64-bit operand-size. */
  z
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.util.HexByte;
import static jasm.util.HexByte.*;

/** Helper to determine how to decode instructions. */
public final class X86Opcode {
  public static final HexByte OPCODE1_ESCAPE = _0F;
  public static final HexByte FP_ESCAPE_MIN = _D8;
  public static final HexByte FP_ESCAPE_MAX = _DF;
  public static final HexByte OPCODE2_ESCAPE1 = _38;
  public static final HexByte OPCODE2_ESCAPE2 = _3A;

  public static final HexByte FP_WAIT = _9B;
  public static final HexByte REX_MIN = _40;
  public static final HexByte REX_MAX = _4F;

  public static boolean isStandardOpcode2Prefix(final HexByte opcode) {
    return opcode == OPCODE1_ESCAPE;
  }

  public static boolean isFloatingPointEscape(HexByte opcode) {
    return opcode.value() >= FP_ESCAPE_MIN.value() &&
           opcode.value() <= FP_ESCAPE_MAX.value();
  }

  //Only used in experimental decoder atm
  public static boolean hasOpCode3(final HexByte opcode1,
                                   final HexByte opcode2) {
    return
        OPCODE1_ESCAPE.byteValue() == opcode1.byteValue() &&
        (
            OPCODE2_ESCAPE1.byteValue() == opcode2.byteValue() ||
            OPCODE2_ESCAPE2.byteValue() == opcode2.byteValue()
        );
  }

  public static boolean isRexPrefix(HexByte opcode) {
    return REX_MIN.ordinal() <= opcode.value() && opcode.ordinal() <= REX_MAX.value();
  }
}

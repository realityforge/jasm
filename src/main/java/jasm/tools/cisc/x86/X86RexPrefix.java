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

public final class X86RexPrefix {
  public static final HexByte REX_MIN = _40;
  public static final HexByte REX_MAX = _4F;

  public static boolean isRexPrefix(HexByte opcode) {
    return REX_MIN.ordinal() <= opcode.value() && opcode.ordinal() <= REX_MAX.value();
  }
}

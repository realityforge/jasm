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
import java.util.EnumSet;

/** x86 instruction prefix bytes. */
public final class X86Opcode {
  private static final EnumSet<HexByte> FP_ESCAPE =
      EnumSet.of(_D8, _D9, _DA, _DB, _DC, _DD, _DE, _DF);

  public static boolean isFloatingPointEscape(HexByte opcode) {
    return FP_ESCAPE.contains(opcode);
  }
}

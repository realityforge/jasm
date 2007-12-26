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
import static jasm.util.HexByte._66;
import static jasm.util.HexByte._67;
import static jasm.util.HexByte._9B;
import static jasm.util.HexByte._D8;
import static jasm.util.HexByte._D9;
import static jasm.util.HexByte._DA;
import static jasm.util.HexByte._DB;
import static jasm.util.HexByte._DC;
import static jasm.util.HexByte._DD;
import static jasm.util.HexByte._DE;
import static jasm.util.HexByte._DF;
import java.util.EnumSet;

/**
 * x86 instruction prefix bytes.
 */
public final class X86Opcode {
  public static final HexByte OPERAND_SIZE = _66;
  public static final HexByte ADDRESS_SIZE = _67;
  public static final HexByte FWAIT = _9B;

  public static boolean isFloatingPointEscape(HexByte opcode) {
    return EnumSet.of(_D8, _D9, _DA, _DB, _DC, _DD, _DE, _DF).contains(opcode);
  }
}

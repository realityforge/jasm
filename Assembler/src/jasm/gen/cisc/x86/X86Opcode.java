/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=27b78613-7cfc-4064-9b64-72e9761fb92c*/
package jasm.gen.cisc.x86;

import jasm.util.HexByte;
import static jasm.util.HexByte._26;
import static jasm.util.HexByte._2E;
import static jasm.util.HexByte._36;
import static jasm.util.HexByte._3E;
import static jasm.util.HexByte._40;
import static jasm.util.HexByte._4F;
import static jasm.util.HexByte._64;
import static jasm.util.HexByte._65;
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
import static jasm.util.HexByte._F0;
import static jasm.util.HexByte._F2;
import static jasm.util.HexByte._F3;
import java.util.EnumSet;

/**
 * x86 instruction prefix bytes.
 *
 * @author Bernd Mathiske
 */
public final class X86Opcode {

    private X86Opcode() {
    }

    public static final HexByte SEG_ES = _26;
    public static final HexByte SEG_SS = _36;
    public static final HexByte SEG_CS = _2E;
    public static final HexByte SEG_DS = _3E;
    public static final HexByte REX_MIN = _40;
    public static final HexByte REX_MAX = _4F;
    public static final HexByte SEG_FS = _64;
    public static final HexByte SEG_GS = _65;
    public static final HexByte OPERAND_SIZE = _66;
    public static final HexByte ADDRESS_SIZE = _67;
    public static final HexByte FWAIT = _9B;
    public static final HexByte LOCK = _F0;
    public static final HexByte REPNE = _F2;
    public static final HexByte REPE = _F3;

    public static boolean isRexPrefix(HexByte opcode) {
        return X86Opcode.REX_MIN.ordinal() <= opcode.ordinal() && opcode.ordinal() <= X86Opcode.REX_MAX.ordinal();
    }

    public static boolean isFloatingPointEscape(HexByte opcode) {
        return EnumSet.of(_D8, _D9, _DA, _DB, _DC, _DD, _DE, _DF).contains(opcode);
    }

}
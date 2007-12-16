/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ia32;

import jasm.util.Enumerator;
import jasm.util.WordWidth;
import jasm.x86.GeneralRegister;
import jasm.x86.IndirectRegister;

/**
 * @author Bernd Mathiske
 */
public enum IA32IndirectRegister16 implements GeneralRegister<IA32IndirectRegister16>, IndirectRegister {

    BX_PLUS_SI_INDIRECT(INVALID_ID, "%bx,%si", "bx + si"),
    BX_PLUS_DI_INDIRECT(INVALID_ID, "%bx,%di", "bx + si"),
    BP_PLUS_SI_INDIRECT(INVALID_ID, "%bp,%si", "bp + si"),
    BP_PLUS_DI_INDIRECT(INVALID_ID, "%bp,%di", "bp + di"),
            SI_INDIRECT(IA32GeneralRegister16.SI.id(), "%si", "si"),
            DI_INDIRECT(IA32GeneralRegister16.DI.id(), "%di", "di"),
            BP_INDIRECT(IA32GeneralRegister16.BP.id(), "%bp", "bp"),
            BX_INDIRECT(IA32GeneralRegister16.BX.id(), "%bx", "bx");

    private final int _id;
    private final String _externalValue;
    private final String _disassembledValue;

    private IA32IndirectRegister16(int id, String externalValue, String disassembledValue) {
        _id = id;
        _externalValue = externalValue;
        _disassembledValue = disassembledValue;
    }

    public static IA32IndirectRegister16 from(GeneralRegister generalRegister) {
        for (IA32IndirectRegister16 r : values()) {
            if (r._id == generalRegister.id()) {
                return r;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public WordWidth width() {
        return WordWidth.BITS_16;
    }

    public int value() {
        return ordinal();
    }

    public int id() {
        return _id;
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return _externalValue;
    }

    public String disassembledValue() {
        return _disassembledValue;
    }

  public static final Enumerator<IA32IndirectRegister16> ENUMERATOR = new Enumerator<IA32IndirectRegister16>(IA32IndirectRegister16.class);
}

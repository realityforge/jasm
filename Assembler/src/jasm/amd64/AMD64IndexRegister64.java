/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=cb6555b3-6936-4120-9368-ec76248799b0*/
package jasm.amd64;

import jasm.util.Enumerator;
import jasm.util.WordWidth;
import jasm.x86.GeneralRegister;

/**
 * Aliases for 64-bit AMD64 general registers to be used as index registers.
 *
 * @author Bernd Mathiske
 */
public enum AMD64IndexRegister64 implements GeneralRegister<AMD64IndexRegister64> {

    RAX_INDEX,
    RCX_INDEX,
    RDX_INDEX,
    RBX_INDEX,
    // no RSP_INDEX!
    RBP_INDEX,
    RSI_INDEX,
    RDI_INDEX,
    R8_INDEX,
    R9_INDEX,
    R10_INDEX,
    R11_INDEX,
    R12_INDEX,
    R13_INDEX,
    R14_INDEX,
    R15_INDEX;

    public static AMD64IndexRegister64 from(GeneralRegister generalRegister) {
        int ordinal = generalRegister.id();
        if (ordinal >= AMD64GeneralRegister64.RSP.id()) {
            ordinal--;
        }
        return values()[ordinal];
    }

    public int id() {
        int ordinal = ordinal();
        if (ordinal >= AMD64GeneralRegister64.RSP.id()) {
            ordinal++;
        }
        return ordinal;
    }

    public WordWidth width() {
        return WordWidth.BITS_64;
    }

    public int value() {
        return id();
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return AMD64GeneralRegister64.from(this).externalValue();
    }

    public String disassembledValue() {
        return AMD64GeneralRegister64.from(this).disassembledValue();
    }

    public Enumerator<AMD64IndexRegister64> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64IndexRegister64> ENUMERATOR = new Enumerator<AMD64IndexRegister64>(AMD64IndexRegister64.class);
}

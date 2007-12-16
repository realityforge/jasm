/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0c463e0e-e148-4ac9-ac2a-d940ab67ec77*/
package jasm.amd64;

import jasm.x86.GeneralRegister;
import jasm.x86.IndirectRegister;
import jasm.util.WordWidth;
import jasm.util.Enumerator;

/**
 * Aliases for 64-bit AMD64 general registers to be used for indirect addressing.
 *
 * @author Bernd Mathiske
 */
public enum AMD64IndirectRegister64 implements GeneralRegister<AMD64IndirectRegister64>, IndirectRegister {

    RAX_INDIRECT,
    RCX_INDIRECT,
    RDX_INDIRECT,
    RBX_INDIRECT,
    RSP_INDIRECT,
    RBP_INDIRECT,
    RSI_INDIRECT,
    RDI_INDIRECT,
    R8_INDIRECT,
    R9_INDIRECT,
    R10_INDIRECT,
    R11_INDIRECT,
    R12_INDIRECT,
    R13_INDIRECT,
    R14_INDIRECT,
    R15_INDIRECT;

    public static AMD64IndirectRegister64 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }

    public int id() {
        return ordinal();
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

    public Enumerator<AMD64IndirectRegister64> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64IndirectRegister64> ENUMERATOR = new Enumerator<AMD64IndirectRegister64>(AMD64IndirectRegister64.class);
}

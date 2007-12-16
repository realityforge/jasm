/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64;

import jasm.util.Enumerator;
import jasm.util.WordWidth;
import jasm.x86.GeneralRegister;

/**
 * Aliases for 64-bit AMD64 general registers to be used as base registers.
 *
 * @author Bernd Mathiske
 */
public enum AMD64BaseRegister64 implements GeneralRegister<AMD64BaseRegister64> {

    RAX_BASE,
    RCX_BASE,
    RDX_BASE,
    RBX_BASE,
    RSP_BASE,
    RBP_BASE,
    RSI_BASE,
    RDI_BASE,
    R8_BASE,
    R9_BASE,
    R10_BASE,
    R11_BASE,
    R12_BASE,
    R13_BASE,
    R14_BASE,
    R15_BASE;

    public static AMD64BaseRegister64 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }

    public WordWidth width() {
        return WordWidth.BITS_64;
    }

    public int id() {
        return ordinal();
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

    public Enumerator<AMD64BaseRegister64> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64BaseRegister64> ENUMERATOR = new Enumerator<AMD64BaseRegister64>(AMD64BaseRegister64.class);
}

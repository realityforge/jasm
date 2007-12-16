/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.amd64;

import jasm.util.Enumerator;
import jasm.util.WordWidth;
import jasm.x86.GeneralRegister;

/**
 * @author Bernd Mathiske
 */
public enum AMD64GeneralRegister64 implements GeneralRegister<AMD64GeneralRegister64> {

    // Note: keep the order such that 'value()' can rely on ordinals:

    RAX, RCX, RDX, RBX, RSP, RBP, RSI, RDI, R8, R9, R10, R11, R12, R13, R14, R15;

    public static AMD64GeneralRegister64 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }

    public AMD64IndirectRegister64 indirect() {
        return AMD64IndirectRegister64.from(this);
    }

    public AMD64BaseRegister64 base() {
        return AMD64BaseRegister64.from(this);
    }

    public AMD64IndexRegister64 index() {
        return AMD64IndexRegister64.from(this);
    }

    public WordWidth width() {
        return WordWidth.BITS_64;
    }

    public int value() {
        return ordinal();
    }

    public int id() {
        return ordinal();
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return "%" + name().toLowerCase();
    }

    public String disassembledValue() {
        return name().toLowerCase();
    }

    public Enumerator<AMD64GeneralRegister64> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64GeneralRegister64> ENUMERATOR = new Enumerator<AMD64GeneralRegister64>(AMD64GeneralRegister64.class);
}

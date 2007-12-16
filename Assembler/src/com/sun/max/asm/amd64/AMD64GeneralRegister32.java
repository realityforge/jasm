/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=73bf06af-9f58-4eb9-b200-1b76fd85964b*/
package com.sun.max.asm.amd64;

import com.sun.max.asm.x86.GeneralRegister;
import com.sun.max.lang.WordWidth;
import com.sun.max.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum AMD64GeneralRegister32 implements GeneralRegister<AMD64GeneralRegister32> {

    // Note: keep the order such that 'value()' can rely on ordinals:

    EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI, R8D, R9D, R10D, R11D, R12D, R13D, R14D, R15D;

    public static AMD64GeneralRegister32 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }

    public AMD64IndirectRegister32 indirect() {
        return AMD64IndirectRegister32.from(this);
    }

    public AMD64BaseRegister32 base() {
        return AMD64BaseRegister32.from(this);
    }

    public AMD64IndexRegister32 index() {
        return AMD64IndexRegister32.from(this);
    }

    public WordWidth width() {
        return WordWidth.BITS_32;
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

    public Enumerator<AMD64GeneralRegister32> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64GeneralRegister32> ENUMERATOR = new Enumerator<AMD64GeneralRegister32>(AMD64GeneralRegister32.class);
}

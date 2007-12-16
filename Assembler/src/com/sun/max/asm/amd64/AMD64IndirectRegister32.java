/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1d8ff817-ec40-4471-9f98-7238c8609b08*/
package com.sun.max.asm.amd64;

import com.sun.max.asm.x86.GeneralRegister;
import com.sun.max.asm.x86.IndirectRegister;
import com.sun.max.lang.WordWidth;
import com.sun.max.util.Enumerator;

/**
 * Aliases for 32-bit AMD64 general registers to be used for indirect addressing.
 *
 * @author Bernd Mathiske
 */
public enum AMD64IndirectRegister32 implements GeneralRegister<AMD64IndirectRegister32>, IndirectRegister {

    EAX_INDIRECT,
    ECX_INDIRECT,
    EDX_INDIRECT,
    EBX_INDIRECT,
    ESP_INDIRECT,
    EBP_INDIRECT,
    ESI_INDIRECT,
    EDI_INDIRECT,
    R8D_INDIRECT,
    R9D_INDIRECT,
    R10D_INDIRECT,
    R11D_INDIRECT,
    R12D_INDIRECT,
    R13D_INDIRECT,
    R14D_INDIRECT,
    R15D_INDIRECT;

    public static AMD64IndirectRegister32 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }

    public WordWidth width() {
        return WordWidth.BITS_32;
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
        return AMD64GeneralRegister32.from(this).externalValue();
    }

    public String disassembledValue() {
        return AMD64GeneralRegister32.from(this).disassembledValue();
    }

    public Enumerator<AMD64IndirectRegister32> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64IndirectRegister32> ENUMERATOR = new Enumerator<AMD64IndirectRegister32>(AMD64IndirectRegister32.class);
}

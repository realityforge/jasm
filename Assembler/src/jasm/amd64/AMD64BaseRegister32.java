/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=fa29398f-c171-4bd5-891e-9ea6860b9ca4*/
package jasm.amd64;

import jasm.x86.GeneralRegister;
import com.sun.max.lang.WordWidth;
import com.sun.max.util.Enumerator;

/**
 * Aliases for 32-bit AMD64 general registers to be used as base registers.
 *
 * @author Bernd Mathiske
 */
public enum AMD64BaseRegister32 implements GeneralRegister<AMD64BaseRegister32> {

    EAX_BASE,
    ECX_BASE,
    EDX_BASE,
    EBX_BASE,
    ESP_BASE,
    EBP_BASE,
    ESI_BASE,
    EDI_BASE,
    R8D_BASE,
    R9D_BASE,
    R10D_BASE,
    R11D_BASE,
    R12D_BASE,
    R13D_BASE,
    R14D_BASE,
    R15D_BASE;

    public static AMD64BaseRegister32 from(GeneralRegister generalRegister) {
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

    public Enumerator<AMD64BaseRegister32> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64BaseRegister32> ENUMERATOR = new Enumerator<AMD64BaseRegister32>(AMD64BaseRegister32.class);
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a6b38a23-ea71-4b85-81c1-9bd92af85982*/
package jasm.amd64;

import jasm.x86.GeneralRegister;
import jasm.util.WordWidth;
import com.sun.max.util.Enumerator;

/**
 * Aliases for 32-bit AMD64 general registers to be used as index registers.
 *
 * @author Bernd Mathiske
 */
public enum AMD64IndexRegister32 implements GeneralRegister<AMD64IndexRegister32> {

    EAX_INDEX,
    ECX_INDEX,
    EDX_INDEX,
    EBX_INDEX,
    // no ESP_INDEX!
    EBP_INDEX,
    ESI_INDEX,
    EDI_INDEX,
    R8D_INDEX,
    R9D_INDEX,
    R10D_INDEX,
    R11D_INDEX,
    R12D_INDEX,
    R13D_INDEX,
    R14D_INDEX,
    R15D_INDEX;

    public static AMD64IndexRegister32 from(GeneralRegister generalRegister) {
        int ordinal = generalRegister.id();
        if (ordinal >= AMD64GeneralRegister32.ESP.id()) {
            ordinal--;
        }
        return values()[ordinal];
    }

    public WordWidth width() {
        return WordWidth.BITS_32;
    }

    public int id() {
        int ordinal = ordinal();
        if (ordinal >= AMD64GeneralRegister32.ESP.id()) {
            ordinal++;
        }
        return ordinal;
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

    public Enumerator<AMD64IndexRegister32> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64IndexRegister32> ENUMERATOR = new Enumerator<AMD64IndexRegister32>(AMD64IndexRegister32.class);
}

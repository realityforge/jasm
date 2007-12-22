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
import jasm.WordWidth;
import jasm.x86.GeneralRegister;

/**
 * Aliases for 32-bit AMD64 general registers to be used as index registers.
 *
 * @author Bernd Mathiske
 */
public enum AMD64IndexRegister32 implements GeneralRegister {

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

  public static final Enumerator<AMD64IndexRegister32> ENUMERATOR = new Enumerator<AMD64IndexRegister32>(AMD64IndexRegister32.class);
}

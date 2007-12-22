/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64;

import jasm.WordWidth;
import jasm.util.SymbolSet;
import jasm.x86.GeneralRegister;
import jasm.x86.IndirectRegister;

/**
 * Aliases for 32-bit AMD64 general registers to be used for indirect addressing.
 *
 * @author Bernd Mathiske
 */
public enum AMD64IndirectRegister32 implements GeneralRegister, IndirectRegister {

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

  public static final SymbolSet<AMD64IndirectRegister32> SYMBOLS = SymbolSet.fromEnum(AMD64IndirectRegister32.class);
}

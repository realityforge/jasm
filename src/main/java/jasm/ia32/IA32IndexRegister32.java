/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ia32;

import jasm.WordWidth;
import jasm.SymbolSet;
import jasm.x86.GeneralRegister;

public enum IA32IndexRegister32 implements GeneralRegister {

    EAX_INDEX,
    ECX_INDEX,
    EDX_INDEX,
    EBX_INDEX,
    // no ESP_INDEX!
    EBP_INDEX,
    ESI_INDEX,
    EDI_INDEX;

    public static IA32IndexRegister32 from(GeneralRegister generalRegister) {
        int ordinal = generalRegister.id();
        if (ordinal >= IA32GeneralRegister32.ESP.id()) {
            ordinal--;
        }
        return values()[ordinal];
    }

    public WordWidth width() {
        return WordWidth.BITS_32;
    }

    public int id() {
        int ordinal = ordinal();
        if (ordinal >= IA32GeneralRegister32.ESP.id()) {
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
        return IA32GeneralRegister32.from(this).externalValue();
    }

    public String disassembledValue() {
        return IA32GeneralRegister32.from(this).disassembledValue();
    }

  public static final SymbolSet<IA32IndexRegister32> SYMBOLS = SymbolSet.fromEnum(IA32IndexRegister32.class);
}

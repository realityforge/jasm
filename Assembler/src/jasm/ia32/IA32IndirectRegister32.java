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
package jasm.ia32;

import jasm.util.Enumerator;
import jasm.util.WordWidth;
import jasm.x86.GeneralRegister;
import jasm.x86.IndirectRegister;

/**
 * @author Bernd Mathiske
 */
public enum IA32IndirectRegister32 implements GeneralRegister<IA32IndirectRegister32>, IndirectRegister {

    EAX_INDIRECT,
    ECX_INDIRECT,
    EDX_INDIRECT,
    EBX_INDIRECT,
    ESP_INDIRECT,
    EBP_INDIRECT,
    ESI_INDIRECT,
    EDI_INDIRECT;

    public static IA32IndirectRegister32 from(GeneralRegister generalRegister) {
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
        return IA32GeneralRegister32.from(this).externalValue();
    }

    public String disassembledValue() {
        return IA32GeneralRegister32.from(this).disassembledValue();
    }

    public Enumerator<IA32IndirectRegister32> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<IA32IndirectRegister32> ENUMERATOR = new Enumerator<IA32IndirectRegister32>(IA32IndirectRegister32.class);
}

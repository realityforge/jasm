/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ia32;

import jasm.util.Enumerator;
import jasm.WordWidth;
import jasm.x86.GeneralRegister;

/**
 * @author Bernd Mathiske
 */
public enum IA32BaseRegister32 implements GeneralRegister {

    EAX_BASE,
    ECX_BASE,
    EDX_BASE,
    EBX_BASE,
    ESP_BASE,
    EBP_BASE,
    ESI_BASE,
    EDI_BASE;

    public static IA32BaseRegister32 from(GeneralRegister generalRegister) {
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

  public static final Enumerator<IA32BaseRegister32> ENUMERATOR = new Enumerator<IA32BaseRegister32>(IA32BaseRegister32.class);
}

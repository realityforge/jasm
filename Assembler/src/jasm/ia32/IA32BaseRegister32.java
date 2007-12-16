/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=21625a88-a3b5-49b6-a41c-09d94db320c2*/
package jasm.ia32;

import jasm.x86.GeneralRegister;
import com.sun.max.lang.WordWidth;
import com.sun.max.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum IA32BaseRegister32 implements GeneralRegister<IA32BaseRegister32> {

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

    public Enumerator<IA32BaseRegister32> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<IA32BaseRegister32> ENUMERATOR = new Enumerator<IA32BaseRegister32>(IA32BaseRegister32.class);
}

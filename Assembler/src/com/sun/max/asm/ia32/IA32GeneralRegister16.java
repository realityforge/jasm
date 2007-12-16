/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=37f19731-66ec-4a29-8d68-1bd64e295ece*/
package com.sun.max.asm.ia32;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum IA32GeneralRegister16 implements GeneralRegister<IA32GeneralRegister16> {

    // Note: keep the order such that 'value()' can rely on ordinals:

    AX, CX, DX, BX, SP, BP, SI, DI;

    public static IA32GeneralRegister16 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }

    public WordWidth width() {
        return WordWidth.BITS_16;
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

    public Enumerator<IA32GeneralRegister16> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<IA32GeneralRegister16> ENUMERATOR = new Enumerator<IA32GeneralRegister16>(IA32GeneralRegister16.class);

}

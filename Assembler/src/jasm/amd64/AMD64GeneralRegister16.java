/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=eb0cff5e-304e-4afa-9e41-8a5cc47552c1*/
package jasm.amd64;

import jasm.x86.GeneralRegister;
import jasm.util.WordWidth;
import jasm.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum AMD64GeneralRegister16 implements GeneralRegister<AMD64GeneralRegister16> {

    // Note: keep the order such that 'value()' can rely on ordinals:

    AX, CX, DX, BX, SP, BP, SI, DI, R8W, R9W, R10W, R11W, R12W, R13W, R14W, R15W;

    public static AMD64GeneralRegister16 from(GeneralRegister generalRegister) {
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

    public Enumerator<AMD64GeneralRegister16> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64GeneralRegister16> ENUMERATOR = new Enumerator<AMD64GeneralRegister16>(AMD64GeneralRegister16.class);

}

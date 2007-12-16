/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a5480112-6a29-4547-a62e-683484a0c927*/
package jasm.ia32;

import jasm.util.Enumerator;
import jasm.util.WordWidth;
import jasm.x86.GeneralRegister;

/**
 * @author Bernd Mathiske
 */
public enum IA32GeneralRegister8 implements GeneralRegister<IA32GeneralRegister8> {

    // Note: keep the order such that 'value()' can rely on ordinals:

    AL, CL, DL, BL, AH, CH, DH, BH;

    private static final IA32GeneralRegister8[] LOW_REGISTERS = {AL, CL, DL, BL};

    public static IA32GeneralRegister8 lowFrom(GeneralRegister generalRegister) {
        return LOW_REGISTERS[generalRegister.id()];
    }

    private static final IA32GeneralRegister8[] HIGH_REGISTERS = {AH, CH, DH, BH};

    public static IA32GeneralRegister8 highFrom(GeneralRegister generalRegister) {
        return HIGH_REGISTERS[generalRegister.id()];
    }

    public WordWidth width() {
        return WordWidth.BITS_8;
    }

    public int value() {
        return ordinal();
    }

    public int id() {
        return ordinal() % 4;
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

    public Enumerator<IA32GeneralRegister8> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<IA32GeneralRegister8> ENUMERATOR = new Enumerator<IA32GeneralRegister8>(IA32GeneralRegister8.class);

}

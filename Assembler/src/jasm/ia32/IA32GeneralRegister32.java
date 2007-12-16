/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=cfec39ba-afb6-4363-b049-31d912db2452*/
package jasm.ia32;

import jasm.util.Enumerator;
import jasm.util.WordWidth;
import jasm.x86.GeneralRegister;
import java.util.EnumSet;

/**
 * @author Bernd Mathiske
 */
public enum IA32GeneralRegister32 implements GeneralRegister<IA32GeneralRegister32> {

    // Note: keep the order such that 'value()' can rely on ordinals:

    EAX, ECX, EDX, EBX, ESP, EBP, ESI, EDI;

    public static IA32GeneralRegister32 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }

    public IA32IndirectRegister32 indirect() {
        return IA32IndirectRegister32.from(this);
    }

    public IA32BaseRegister32 base() {
        return IA32BaseRegister32.from(this);
    }

    public IA32IndexRegister32 index() {
        return IA32IndexRegister32.from(this);
    }

    public WordWidth width() {
        return WordWidth.BITS_32;
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

    public Enumerator<IA32GeneralRegister32> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<IA32GeneralRegister32> ENUMERATOR = new Enumerator<IA32GeneralRegister32>(IA32GeneralRegister32.class);

    public static final Enumerator<IA32GeneralRegister32> ENUMERATOR_WITHOUT_EBP =
        new Enumerator<IA32GeneralRegister32>(IA32GeneralRegister32.class, EnumSet.complementOf(EnumSet.of(EBP)));
}

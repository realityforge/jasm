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
import java.util.EnumSet;

/**
 * @author Bernd Mathiske
 */
public enum IA32GeneralRegister32 implements GeneralRegister {

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

  public static final Enumerator<IA32GeneralRegister32> ENUMERATOR = new Enumerator<IA32GeneralRegister32>(IA32GeneralRegister32.class);

    public static final Enumerator<IA32GeneralRegister32> ENUMERATOR_WITHOUT_EBP =
        new Enumerator<IA32GeneralRegister32>(IA32GeneralRegister32.class, EnumSet.complementOf(EnumSet.of(EBP)));
}

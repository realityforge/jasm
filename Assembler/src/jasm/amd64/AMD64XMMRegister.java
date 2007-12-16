/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64;

import jasm.EnumerableArgument;
import jasm.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum AMD64XMMRegister implements EnumerableArgument<AMD64XMMRegister> {

    XMM0, XMM1, XMM2, XMM3, XMM4, XMM5, XMM6, XMM7, XMM8, XMM9, XMM10, XMM11, XMM12, XMM13, XMM14, XMM15;

    public int value() {
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

    public Enumerator<AMD64XMMRegister> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64XMMRegister> ENUMERATOR = new Enumerator<AMD64XMMRegister>(AMD64XMMRegister.class);
}

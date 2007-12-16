/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b9d8ddc4-5693-4bd8-afd1-435985901507*/
package com.sun.max.asm.amd64;

import com.sun.max.asm.EnumerableArgument;
import com.sun.max.util.Enumerator;

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

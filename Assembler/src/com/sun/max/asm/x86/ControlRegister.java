/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=40671b05-b668-4c9d-a86a-f0db76bf5099*/
package com.sun.max.asm.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum ControlRegister implements EnumerableArgument<ControlRegister> {

    CR0(0), CR2(2), CR3(3);

    private final int _number;

    private ControlRegister(int number) {
        _number = number;
    }

    public int value() {
        return _number;
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

    public Enumerator<ControlRegister> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<ControlRegister> ENUMERATOR = new Enumerator<ControlRegister>(ControlRegister.class);

}

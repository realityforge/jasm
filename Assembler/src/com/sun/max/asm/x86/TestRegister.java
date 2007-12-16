/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=cd98d125-d966-493e-bd20-28c198477155*/
package com.sun.max.asm.x86;

import com.sun.max.asm.EnumerableArgument;
import com.sun.max.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum TestRegister implements EnumerableArgument<TestRegister> {

    TR3(3), TR4(4), TR5(5), TR6(6), TR7(7);

    private final int _number;

    private TestRegister(int number) {
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

    public Enumerator<TestRegister> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<TestRegister> ENUMERATOR = new Enumerator<TestRegister>(TestRegister.class);

}

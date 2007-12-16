/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.x86;

import jasm.EnumerableArgument;
import jasm.util.Enumerator;

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

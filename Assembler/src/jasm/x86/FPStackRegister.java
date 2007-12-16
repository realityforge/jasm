/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.x86;

import jasm.EnumerableArgument;
import jasm.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum FPStackRegister implements EnumerableArgument<FPStackRegister> {

    ST_0(0),
    ST_1(1),
    ST_2(2),
    ST_3(3),
    ST_4(4),
    ST_5(5),
    ST_6(6),
    ST_7(7),
    ST(0) {
        @Override
        public String externalValue() {
            return "%st";
        }
        @Override
        public String disassembledValue() {
            return "st";
        }
    };

    private final int _value;

    private FPStackRegister(int value) {
        _value = value;
    }

    public int value() {
        return _value;
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return "%st(" + value() + ")";
    }

    public String disassembledValue() {
        return "st(" + value() + ")";
    }

    public Enumerator<FPStackRegister> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<FPStackRegister> ENUMERATOR = new Enumerator<FPStackRegister>(FPStackRegister.class);

}

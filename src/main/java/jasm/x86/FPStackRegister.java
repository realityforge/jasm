/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86;

import jasm.EnumerableArgument;
import jasm.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum FPStackRegister implements EnumerableArgument {

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

    public final int value() {
        return _value;
    }

    public final long asLong() {
        return value();
    }

    public String externalValue() {
        return "%st(" + value() + ")";
    }

    public String disassembledValue() {
        return "st(" + value() + ")";
    }

  public static final Enumerator<FPStackRegister> ENUMERATOR = new Enumerator<FPStackRegister>(FPStackRegister.class);

}

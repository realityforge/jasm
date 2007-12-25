/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.Argument;
import jasm.tools.risc.field.RiscField;

public final class RiscConstant {

    private final RiscField _field;
    private final int _value;

    public RiscConstant(RiscField field, Argument argument) {
        _field = field;
        _value = (int) argument.asLong();
    }

    public RiscConstant(RiscField field, int value) {
        _field = field;
        _value = value;
    }

    public final RiscField field() {
        return _field;
    }

    public final int value() {
        return _value;
    }

    @Override
    public final boolean equals(Object other) {
        if (other instanceof RiscConstant) {
            final RiscConstant riscConstant = (RiscConstant) other;
            return _field.equals(riscConstant._field) && _value == riscConstant._value;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return _field.hashCode() ^ _value;
    }

    @Override
    public final String toString() {
        return _field.toString() + "(" + _value + ")";
    }
}

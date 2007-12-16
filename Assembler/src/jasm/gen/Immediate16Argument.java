/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen;

import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class Immediate16Argument extends ImmediateArgument {

    private short _value;

    public Immediate16Argument(short value) {
        _value = value;
    }

    @Override
    public WordWidth width() {
        return WordWidth.BITS_16;
    }

    public short value() {
        return _value;
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return "0x" + Integer.toHexString(_value & 0xffff);
    }

    public String disassembledValue() {
        return "0x" + String.format("%X", _value);
    }

    @Override
    public String signedExternalValue() {
        return Integer.toString(_value);
    }

    @Override
    public Object boxedJavaValue() {
        return new Short(_value);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Immediate16Argument) {
            final Immediate16Argument argument = (Immediate16Argument) other;
            return _value == argument._value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return _value;
    }
}

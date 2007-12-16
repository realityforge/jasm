/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4347eb2c-d5da-40b3-b287-38a227fb5a9d*/
package jasm.gen;

import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class Immediate64Argument extends ImmediateArgument {

    private long _value;

    public Immediate64Argument(long value) {
        _value = value;
    }

    @Override
    public WordWidth width() {
        return WordWidth.BITS_64;
    }

    public long value() {
        return _value;
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return "0x" + Long.toHexString(_value);
    }

    public String disassembledValue() {
        return "0x" + String.format("%X", _value);
    }

    @Override
    public String signedExternalValue() {
        return Long.toString(_value);
    }

    @Override
    public Object boxedJavaValue() {
        return new Long(_value);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Immediate64Argument) {
            final Immediate64Argument argument = (Immediate64Argument) other;
            return _value == argument._value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (_value ^ _value >> 32);
    }

}

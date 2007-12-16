/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e981ab5d-9897-4cd1-8f4a-05f886084fbc*/
package jasm.gen;

import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class Immediate8Argument extends ImmediateArgument {

    private byte _value;

    public Immediate8Argument(byte value) {
        _value = value;
    }

    @Override
    public WordWidth width() {
        return WordWidth.BITS_8;
    }

    public byte value() {
        return _value;
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return "0x" + Integer.toHexString(_value & 0xff);
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
        return new Byte(_value);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Immediate8Argument) {
            final Immediate8Argument argument = (Immediate8Argument) other;
            return _value == argument._value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return _value;
    }

}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import jasm.WordWidth;

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

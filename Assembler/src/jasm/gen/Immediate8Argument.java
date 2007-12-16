/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
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

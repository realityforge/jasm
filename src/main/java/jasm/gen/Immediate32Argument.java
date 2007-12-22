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
public class Immediate32Argument extends ImmediateArgument {

    private int _value;

    public Immediate32Argument(int value) {
        _value = value;
    }

    @Override
    public WordWidth width() {
        return WordWidth.BITS_32;
    }

    public int value() {
        return _value;
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return "0x" + Integer.toHexString(_value);
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
        return new Integer(_value);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Immediate32Argument) {
            final Immediate32Argument argument = (Immediate32Argument) other;
            return _value == argument._value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return _value;
    }

}

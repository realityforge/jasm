/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import jasm.util.StaticFieldName;

/**
 * This class provides a skeletal implementation of the {@link SymbolicArgument} interface, to minimize the
 * effort required to implement this interface.
 *
 * @author Doug Simon
 */
public abstract class AbstractSymbolicArgument implements SymbolicArgument, StaticFieldName {

    private String _name;
    private final int _value;

    protected AbstractSymbolicArgument(String name, int value) {
        _name = name;
        _value = value;
    }

    protected AbstractSymbolicArgument(int value) {
        _value = value;
    }

    public final void setName(String name) {
        _name = name;
    }

    public final String name() {
        return _name;
    }

    public final int value() {
        return _value;
    }

    public String externalValue() {
        return "%" + name().toLowerCase();
    }

    public final long asLong() {
        return value();
    }

    public final String disassembledValue() {
        return externalValue();
    }

    @Override
    public String toString() {
        return name();
    }
}

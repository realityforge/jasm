/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=61c465be-328d-4985-a4d0-3ab5b361c84d*/
package com.sun.max.asm;

import com.sun.max.lang.StaticFieldName;

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

    public void setName(String name) {
        _name = name;
    }

    public String name() {
        return _name;
    }

    public int value() {
        return _value;
    }

    public String externalValue() {
        return "%" + name().toLowerCase();
    }

    public long asLong() {
        return value();
    }

    public String disassembledValue() {
        return externalValue();
    }

    @Override
    public String toString() {
        return name();
    }
}

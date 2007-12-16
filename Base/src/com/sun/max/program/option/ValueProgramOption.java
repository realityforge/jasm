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
package com.sun.max.program.option;

/**
 * A program option that can be queried for a resulting value.
 *
 * @author Bernd Mathiske
 */
public abstract class ValueProgramOption<Value_Type> extends ProgramOption {

    protected ValueProgramOption(String prefix, String description) {
        super(prefix, description);
    }

    private Value_Type _value;

    /**
     * Notifies subclasses when a value is {@linkplain #setValue(Object) set}.
     *
     * @param value the value that was set
     */
    protected void useValue(Value_Type value) {
    }

    protected final synchronized void setValue(Value_Type value) {
        assert value != null;
        _value = value;
        useValue(value);
    }

    public synchronized Value_Type value() {
        return _value;
    }
}

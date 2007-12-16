/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=9acd0956-fa10-427f-a2ca-805b8b0d5ed9*/
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

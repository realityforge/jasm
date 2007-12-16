/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=9ae5be96-a18d-47d1-856c-c28cec13326c*/
package com.sun.max.program.option;

import com.sun.max.lang.*;

/**
 * An assignment option with an enumerated set of permitted values.
 *
 * @author Bernd Mathiske
 */
public abstract class EnumProgramOption<Enum_Type extends Enum> extends AssignmentProgramOption<Enum_Type> {

    private final Enum_Type[] _values;

    protected EnumProgramOption(String prefix, String description, Enum_Type[] values) {
        super(prefix, description);
        _values = values;
    }

    public Enum_Type[] values() {
        return _values;
    }

    @Override
    public String usage() {
        return prefix() + "={" + Arrays.toString(_values, "|") + "}";
    }

    @Override
    public Enum_Type scanValue(String string) {
        for (Enum_Type value : _values) {
            if (string.equalsIgnoreCase(value.toString())) {
                return value;
            }
        }
        return null;
    }

}

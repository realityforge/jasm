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

import com.sun.max.lang.Arrays;

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

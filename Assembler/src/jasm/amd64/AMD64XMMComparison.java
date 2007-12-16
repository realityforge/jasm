/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.amd64;

import jasm.EnumerableArgument;
import jasm.util.Enumerator;

public enum AMD64XMMComparison implements EnumerableArgument<AMD64XMMComparison> {

    EQUAL,
    LESS_THAN,
    GREATER_THAN,
    LESS_THAN_OR_EQUAL,
    UNORDERED,
    NOT_EQUAL,
    NOT_LESS_THAN,
    NOT_LESS_THAN_OR_EQUAL,
    ORDERED;

    public int value() {
        return ordinal();
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return "$" + Integer.toString(value());
    }

    public String disassembledValue() {
        return name().toLowerCase();
    }

    public Enumerator<AMD64XMMComparison> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64XMMComparison> ENUMERATOR = new Enumerator<AMD64XMMComparison>(AMD64XMMComparison.class);

}

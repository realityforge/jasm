/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64;

import jasm.EnumerableArgument;
import jasm.util.Enumerator;

public enum AMD64XMMComparison implements EnumerableArgument {

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

  public static final Enumerator<AMD64XMMComparison> ENUMERATOR = new Enumerator<AMD64XMMComparison>(AMD64XMMComparison.class);

}

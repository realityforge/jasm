/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=cb558800-7bfc-49d3-beeb-2a64e3451e4c*/
package com.sun.max.asm.x86;

import com.sun.max.asm.EnumerableArgument;
import com.sun.max.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum Scale implements EnumerableArgument<Scale> {

    SCALE_1, SCALE_2, SCALE_4, SCALE_8;

    public int value() {
        return ordinal();
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return name().substring(name().length() - 1);
    }

    public String disassembledValue() {
        return name().substring(name().length() - 1);
    }

    public Enumerator<Scale> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<Scale> ENUMERATOR = new Enumerator<Scale>(Scale.class);

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.x86;

import jasm.EnumerableArgument;
import jasm.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public enum SegmentRegister implements EnumerableArgument<SegmentRegister> {

    ES,
    CS,
    SS,
    DS,
    FS,
    GS;

    public int value() {
        return ordinal();
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return "%" + name().toLowerCase();
    }

    public String disassembledValue() {
        return name().toLowerCase();
    }

    public Enumerator<SegmentRegister> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<SegmentRegister> ENUMERATOR = new Enumerator<SegmentRegister>(SegmentRegister.class);

}

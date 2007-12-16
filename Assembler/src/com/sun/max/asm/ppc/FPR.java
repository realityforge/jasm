/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=992403a2-0745-4cdb-86b9-20c25da0ff90*/
package com.sun.max.asm.ppc;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.util.*;

/**
 * The floating point registers.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public enum FPR implements EnumerableArgument<FPR> {

    F0,   F1,  F2,  F3,  F4,  F5,  F6,  F7,
    F8,   F9,  F10, F11, F12, F13, F14, F15,
    F16, F17, F18, F19, F20, F21, F22, F23,
    F24, F25, F26, F27, F28, F29, F30, F31;

    public int value() {
        return ordinal();
    }

    public long asLong() {
        return value();
    }

    public String externalValue() {
        return name().toLowerCase();
    }

    public String disassembledValue() {
        return externalValue();
    }

    public Enumerator<FPR> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<FPR> ENUMERATOR = new Enumerator<FPR>(FPR.class);

}

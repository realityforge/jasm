/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=af5c83d8-5db9-4552-bcb5-2f7997ff1c26*/
package com.sun.max.asm.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.util.*;

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

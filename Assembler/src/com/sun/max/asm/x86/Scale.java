/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=cb558800-7bfc-49d3-beeb-2a64e3451e4c*/
package com.sun.max.asm.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum Scale implements EnumerableArgument<Scale> {

    SCALE_1, SCALE_2, SCALE_4, SCALE_8;
    
    @Implement(Symbol.class)
    public int value() {
        return ordinal();
    }
    
    @Implement(Argument.class)
    public long asLong() {
        return value();
    }

    @Implement(Argument.class)
    public String externalValue() {
        return name().substring(name().length() - 1);
    }
    
    @Implement(Argument.class)
    public String disassembledValue() {
        return name().substring(name().length() - 1);
    }

    @Implement(Enumerable.class)
    public Enumerator<Scale> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<Scale> ENUMERATOR = new Enumerator<Scale>(Scale.class);
    
}

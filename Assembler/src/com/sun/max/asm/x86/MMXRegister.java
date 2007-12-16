/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=04e9bbc4-fbce-405b-ba84-6bf03b59271b*/
package com.sun.max.asm.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum MMXRegister implements EnumerableArgument<MMXRegister> {
    
    MM0, MM1, MM2, MM3, MM4, MM5, MM6, MM7;
    
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
        return "%" + name().toLowerCase();
    }
    
    @Implement(Argument.class)
    public String disassembledValue() {
        return name().toLowerCase();
    }
    
    @Implement(Enumerable.class)
    public Enumerator<MMXRegister> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<MMXRegister> ENUMERATOR = new Enumerator<MMXRegister>(MMXRegister.class);
}

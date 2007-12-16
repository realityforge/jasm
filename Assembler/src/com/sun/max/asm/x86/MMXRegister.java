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

    public Enumerator<MMXRegister> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<MMXRegister> ENUMERATOR = new Enumerator<MMXRegister>(MMXRegister.class);
}

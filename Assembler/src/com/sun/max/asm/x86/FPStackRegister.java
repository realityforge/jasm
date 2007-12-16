/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4ce8df6d-df1a-4ca2-bfae-269286e05e02*/
package com.sun.max.asm.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum FPStackRegister implements EnumerableArgument<FPStackRegister> {

    ST_0(0), 
    ST_1(1), 
    ST_2(2),
    ST_3(3),
    ST_4(4),
    ST_5(5),
    ST_6(6),
    ST_7(7),
    ST(0) {
        @Override
        public String externalValue() {
            return "%st";
        }  
        @Override
        public String disassembledValue() {
            return "st";
        }  
    };
    
    private final int _value;
    
    private FPStackRegister(int value) {
        _value = value;
    }
    
    @Implement(Symbol.class)
    public int value() {
        return _value;
    }
    
    @Implement(Argument.class)
    public long asLong() {
        return value();
    }

    @Implement(Argument.class)
    public String externalValue() {
        return "%st(" + value() + ")";
    }
    
    @Implement(Argument.class)
    public String disassembledValue() {
        return "st(" + value() + ")";
    }

    @Implement(Enumerable.class)
    public Enumerator<FPStackRegister> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<FPStackRegister> ENUMERATOR = new Enumerator<FPStackRegister>(FPStackRegister.class);
    
}

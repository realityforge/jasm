/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=eb0cff5e-304e-4afa-9e41-8a5cc47552c1*/
package com.sun.max.asm.amd64;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum AMD64GeneralRegister16 implements GeneralRegister<AMD64GeneralRegister16> {
    
    // Note: keep the order such that 'value()' can rely on ordinals: 
    
    AX, CX, DX, BX, SP, BP, SI, DI, R8W, R9W, R10W, R11W, R12W, R13W, R14W, R15W;
    
    public static AMD64GeneralRegister16 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }
    
    @Implement(GeneralRegister.class)    
    public WordWidth width() {
        return WordWidth.BITS_16;
    }
    
    @Implement(Symbol.class)
    public int value() {
        return ordinal();
    }
    
    @Implement(GeneralRegister.class)
    public int id() {
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
    public Enumerator<AMD64GeneralRegister16> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<AMD64GeneralRegister16> ENUMERATOR = new Enumerator<AMD64GeneralRegister16>(AMD64GeneralRegister16.class);

}

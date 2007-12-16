/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ff6672f6-405e-4f12-9b7d-3dcd5d0653d7*/
package com.sun.max.asm.amd64;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * Aliases for 64-bit AMD64 general registers to be used as base registers.
 * 
 * @author Bernd Mathiske
 */
public enum AMD64BaseRegister64 implements GeneralRegister<AMD64BaseRegister64> {
    
    RAX_BASE,
    RCX_BASE,
    RDX_BASE,
    RBX_BASE,
    RSP_BASE,
    RBP_BASE,
    RSI_BASE,
    RDI_BASE,
    R8_BASE,
    R9_BASE,
    R10_BASE,
    R11_BASE,
    R12_BASE,
    R13_BASE,
    R14_BASE,
    R15_BASE;

    public static AMD64BaseRegister64 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }
    
    @Implement(GeneralRegister.class)    
    public WordWidth width() {
        return WordWidth.BITS_64;
    }

    @Implement(GeneralRegister.class)
    public int id() {
        return ordinal();
    }

    @Implement(Symbol.class)
    public int value() {
        return id();
    }
    
    @Implement(Argument.class)
    public long asLong() {
        return value();
    }

    @Implement(Argument.class)
    public String externalValue() {
        return AMD64GeneralRegister64.from(this).externalValue();
    }
    
    @Implement(Argument.class)
    public String disassembledValue() {
        return AMD64GeneralRegister64.from(this).disassembledValue();
    }

    @Implement(Enumerable.class)
    public Enumerator<AMD64BaseRegister64> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<AMD64BaseRegister64> ENUMERATOR = new Enumerator<AMD64BaseRegister64>(AMD64BaseRegister64.class);
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=cb6555b3-6936-4120-9368-ec76248799b0*/
package com.sun.max.asm.amd64;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * Aliases for 64-bit AMD64 general registers to be used as index registers.
 * 
 * @author Bernd Mathiske
 */
public enum AMD64IndexRegister64 implements GeneralRegister<AMD64IndexRegister64> {
    
    RAX_INDEX,
    RCX_INDEX,
    RDX_INDEX,
    RBX_INDEX,
    // no RSP_INDEX!
    RBP_INDEX,
    RSI_INDEX,
    RDI_INDEX,
    R8_INDEX,
    R9_INDEX,
    R10_INDEX,
    R11_INDEX,
    R12_INDEX,
    R13_INDEX,
    R14_INDEX,
    R15_INDEX;
    
    public static AMD64IndexRegister64 from(GeneralRegister generalRegister) {
        int ordinal = generalRegister.id();
        if (ordinal >= AMD64GeneralRegister64.RSP.id()) {
            ordinal--;
        }
        return values()[ordinal];
    }
    
    @Implement(GeneralRegister.class)
    public int id() {
        int ordinal = ordinal();
        if (ordinal >= AMD64GeneralRegister64.RSP.id()) {
            ordinal++;
        }
        return ordinal;
    }

    @Implement(GeneralRegister.class)    
    public WordWidth width() {
        return WordWidth.BITS_64;
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
    public Enumerator<AMD64IndexRegister64> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<AMD64IndexRegister64> ENUMERATOR = new Enumerator<AMD64IndexRegister64>(AMD64IndexRegister64.class);
}

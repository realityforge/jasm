/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=065943dd-56f5-4798-9758-fe1b626cce6f*/
package com.sun.max.asm.amd64;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum AMD64GeneralRegister64 implements GeneralRegister<AMD64GeneralRegister64> {
    
    // Note: keep the order such that 'value()' can rely on ordinals: 
    
    RAX, RCX, RDX, RBX, RSP, RBP, RSI, RDI, R8, R9, R10, R11, R12, R13, R14, R15;
    
    public static AMD64GeneralRegister64 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }

    public AMD64IndirectRegister64 indirect() {
        return AMD64IndirectRegister64.from(this);
    }
    
    public AMD64BaseRegister64 base() {
        return AMD64BaseRegister64.from(this);
    }
    
    public AMD64IndexRegister64 index() {
        return AMD64IndexRegister64.from(this);
    }
    
    @Implement(GeneralRegister.class)    
    public WordWidth width() {
        return WordWidth.BITS_64;
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
    public Enumerator<AMD64GeneralRegister64> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<AMD64GeneralRegister64> ENUMERATOR = new Enumerator<AMD64GeneralRegister64>(AMD64GeneralRegister64.class);
}

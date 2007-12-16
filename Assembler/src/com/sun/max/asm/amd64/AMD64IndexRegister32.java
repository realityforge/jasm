/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a6b38a23-ea71-4b85-81c1-9bd92af85982*/
package com.sun.max.asm.amd64;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * Aliases for 32-bit AMD64 general registers to be used as index registers.
 * 
 * @author Bernd Mathiske
 */
public enum AMD64IndexRegister32 implements GeneralRegister<AMD64IndexRegister32> {
    
    EAX_INDEX,
    ECX_INDEX,
    EDX_INDEX,
    EBX_INDEX,
    // no ESP_INDEX!
    EBP_INDEX,
    ESI_INDEX,
    EDI_INDEX,
    R8D_INDEX,
    R9D_INDEX,
    R10D_INDEX,
    R11D_INDEX,
    R12D_INDEX,
    R13D_INDEX,
    R14D_INDEX,
    R15D_INDEX;
    
    public static AMD64IndexRegister32 from(GeneralRegister generalRegister) {
        int ordinal = generalRegister.id();
        if (ordinal >= AMD64GeneralRegister32.ESP.id()) {
            ordinal--;
        }
        return values()[ordinal];
    }
    
    @Implement(GeneralRegister.class)    
    public WordWidth width() {
        return WordWidth.BITS_32;
    }

    @Implement(GeneralRegister.class)
    public int id() {
        int ordinal = ordinal();
        if (ordinal >= AMD64GeneralRegister32.ESP.id()) {
            ordinal++;
        }
        return ordinal;
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
        return AMD64GeneralRegister32.from(this).externalValue();
    }

    @Implement(Argument.class)
    public String disassembledValue() {
        return AMD64GeneralRegister32.from(this).disassembledValue();
    }

    @Implement(Enumerable.class)
    public Enumerator<AMD64IndexRegister32> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<AMD64IndexRegister32> ENUMERATOR = new Enumerator<AMD64IndexRegister32>(AMD64IndexRegister32.class);
}

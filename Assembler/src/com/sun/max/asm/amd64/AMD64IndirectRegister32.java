/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1d8ff817-ec40-4471-9f98-7238c8609b08*/
package com.sun.max.asm.amd64;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * Aliases for 32-bit AMD64 general registers to be used for indirect addressing.
 * 
 * @author Bernd Mathiske
 */
public enum AMD64IndirectRegister32 implements GeneralRegister<AMD64IndirectRegister32>, IndirectRegister {
    
    EAX_INDIRECT,
    ECX_INDIRECT,
    EDX_INDIRECT,
    EBX_INDIRECT,
    ESP_INDIRECT,
    EBP_INDIRECT,
    ESI_INDIRECT,
    EDI_INDIRECT,
    R8D_INDIRECT,
    R9D_INDIRECT,
    R10D_INDIRECT,
    R11D_INDIRECT,
    R12D_INDIRECT,
    R13D_INDIRECT,
    R14D_INDIRECT,
    R15D_INDIRECT;

    public static AMD64IndirectRegister32 from(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }
    
    @Implement(GeneralRegister.class)    
    public WordWidth width() {
        return WordWidth.BITS_32;
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
        return AMD64GeneralRegister32.from(this).externalValue();
    }
    
    @Implement(Argument.class)
    public String disassembledValue() {
        return AMD64GeneralRegister32.from(this).disassembledValue();
    }

    @Implement(Enumerable.class)
    public Enumerator<AMD64IndirectRegister32> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<AMD64IndirectRegister32> ENUMERATOR = new Enumerator<AMD64IndirectRegister32>(AMD64IndirectRegister32.class);
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d89bb3a5-1297-46a9-93cd-a29ed031073a*/
package com.sun.max.asm.ia32;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum IA32IndexRegister32 implements GeneralRegister<IA32IndexRegister32> {
    
    EAX_INDEX,
    ECX_INDEX,
    EDX_INDEX,
    EBX_INDEX,
    // no ESP_INDEX!
    EBP_INDEX,
    ESI_INDEX,
    EDI_INDEX;

    public static IA32IndexRegister32 from(GeneralRegister generalRegister) {
        int ordinal = generalRegister.id();
        if (ordinal >= IA32GeneralRegister32.ESP.id()) {
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
        if (ordinal >= IA32GeneralRegister32.ESP.id()) {
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
        return IA32GeneralRegister32.from(this).externalValue();
    }
    
    @Implement(Argument.class)
    public String disassembledValue() {
        return IA32GeneralRegister32.from(this).disassembledValue();
    }
    
    @Implement(Enumerable.class)
    public Enumerator<IA32IndexRegister32> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<IA32IndexRegister32> ENUMERATOR = new Enumerator<IA32IndexRegister32>(IA32IndexRegister32.class);
}

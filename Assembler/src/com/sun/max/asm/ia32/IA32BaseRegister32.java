/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=21625a88-a3b5-49b6-a41c-09d94db320c2*/
package com.sun.max.asm.ia32;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum IA32BaseRegister32 implements GeneralRegister<IA32BaseRegister32> {
    
    EAX_BASE,
    ECX_BASE,
    EDX_BASE,
    EBX_BASE,
    ESP_BASE,
    EBP_BASE,
    ESI_BASE,
    EDI_BASE;

    public static IA32BaseRegister32 from(GeneralRegister generalRegister) {
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
        return IA32GeneralRegister32.from(this).externalValue();
    }
    
    @Implement(Argument.class)
    public String disassembledValue() {
        return IA32GeneralRegister32.from(this).disassembledValue();
    }
    
    @Implement(Enumerable.class)
    public Enumerator<IA32BaseRegister32> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<IA32BaseRegister32> ENUMERATOR = new Enumerator<IA32BaseRegister32>(IA32BaseRegister32.class);
}

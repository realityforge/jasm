/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8745b606-10a3-4384-9415-403bb4e64e1c*/
package com.sun.max.asm.ia32;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum IA32IndirectRegister16 implements GeneralRegister<IA32IndirectRegister16>, IndirectRegister {

    BX_PLUS_SI_INDIRECT(INVALID_ID, "%bx,%si", "bx + si"), 
    BX_PLUS_DI_INDIRECT(INVALID_ID, "%bx,%di", "bx + si"),
    BP_PLUS_SI_INDIRECT(INVALID_ID, "%bp,%si", "bp + si"),
    BP_PLUS_DI_INDIRECT(INVALID_ID, "%bp,%di", "bp + di"),
            SI_INDIRECT(IA32GeneralRegister16.SI.id(), "%si", "si"),
            DI_INDIRECT(IA32GeneralRegister16.DI.id(), "%di", "di"),
            BP_INDIRECT(IA32GeneralRegister16.BP.id(), "%bp", "bp"),
            BX_INDIRECT(IA32GeneralRegister16.BX.id(), "%bx", "bx");
        
    private final int _id;
    private final String _externalValue;
    private final String _disassembledValue;
    
    private IA32IndirectRegister16(int id, String externalValue, String disassembledValue) {
        _id = id;
        _externalValue = externalValue;
        _disassembledValue = disassembledValue;
    }
    
    public static IA32IndirectRegister16 from(GeneralRegister generalRegister) {
        for (IA32IndirectRegister16 r : values()) {
            if (r._id == generalRegister.id()) {
                return r;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
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
        return _id;
    }

    @Implement(Argument.class)
    public long asLong() {
        return value();
    }

    @Implement(Argument.class)
    public String externalValue() {
        return _externalValue;
    }
    
    @Implement(Argument.class)
    public String disassembledValue() {
        return _disassembledValue;
    }

    @Implement(Enumerable.class)
    public Enumerator<IA32IndirectRegister16> enumerator() {
        return ENUMERATOR;
    }
    
    public static final Enumerator<IA32IndirectRegister16> ENUMERATOR = new Enumerator<IA32IndirectRegister16>(IA32IndirectRegister16.class);
}

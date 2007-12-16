/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ef6627f6-4da4-441c-8257-69cfc00b67cb*/
package com.sun.max.asm.amd64;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.x86.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public enum AMD64GeneralRegister8 implements GeneralRegister<AMD64GeneralRegister8> {
        
    AL(0, false), 
    CL(1, false), 
    DL(2, false), 
    BL(3, false), 
    SPL(4, false), 
    BPL(5, false), 
    SIL(6, false), 
    DIL(7, false), 
    R8B(8, false), 
    R9B(9, false), 
    R10B(10, false), 
    R11B(11, false), 
    R12B(12, false), 
    R13B(13, false), 
    R14B(14, false), 
    R15B(15, false), 
    AH(4, true), 
    CH(5, true), 
    DH(6, true), 
    BH(7, true);

    private final int _value;
    private final boolean _isHighByte;
    
    
    private AMD64GeneralRegister8(int value, boolean isHighByte) {
        _value = value;
        _isHighByte = isHighByte;
    }
    
    public static AMD64GeneralRegister8 lowFrom(GeneralRegister generalRegister) {
        return values()[generalRegister.id()];
    }
    
    public static AMD64GeneralRegister8 highFrom(GeneralRegister generalRegister) {
        return values()[generalRegister.id() + 16];
    }

    public static AMD64GeneralRegister8 fromValue(int value, boolean isRexBytePresent) {
        if (!isRexBytePresent && value >= AH._value) {
            return values()[(value - AH._value) + AH.ordinal()];
        }
        return ENUMERATOR.fromValue(value);
    }
    
    public boolean isHighByte() {
        return _isHighByte;
    }
    
    public boolean requiresRexPrefix() {
        return _value >= 4 && !_isHighByte;
    }
    
    @Implement(GeneralRegister.class)    
    public WordWidth width() {
        return WordWidth.BITS_8;
    }

    @Implement(GeneralRegister.class)
    public int id() {
        return ordinal() % 16;
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
        return "%" + name().toLowerCase();
    }
  
    @Implement(Argument.class)
    public String disassembledValue() {
        return name().toLowerCase();
    }
    
    @Implement(Enumerable.class)
    public Enumerator<AMD64GeneralRegister8> enumerator() {
        return ENUMERATOR;
    }

    public static final Enumerator<AMD64GeneralRegister8> ENUMERATOR = new Enumerator<AMD64GeneralRegister8>(AMD64GeneralRegister8.class);
    
}

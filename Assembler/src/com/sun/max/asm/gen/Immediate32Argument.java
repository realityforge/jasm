/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=df3f8f27-7005-432b-9206-e402c1837c35*/
package com.sun.max.asm.gen;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.lang.*;

/**
 * @author Bernd Mathiske
 */
public class Immediate32Argument extends ImmediateArgument {

    private int _value;
    
    public Immediate32Argument(int value) {
        _value = value;
    }

    @Override
    public WordWidth width() {
        return WordWidth.BITS_32;
    }

    public int value() {
        return _value;
    }
    
    @Implement(Argument.class)
    public long asLong() {
        return value();
    }

    @Implement(Argument.class)
    public String externalValue() {
        return "0x" + Integer.toHexString(_value);
    }    

    @Implement(Argument.class)
    public String disassembledValue() {
        return "0x" + String.format("%X", _value);
    }

    @Override
    public String signedExternalValue() {
        return Integer.toString(_value);
    }    
    
    @Override
    public Object boxedJavaValue() {
        return new Integer(_value);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Immediate32Argument) {
            final Immediate32Argument argument = (Immediate32Argument) other;
            return _value == argument._value;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return _value;
    }

}

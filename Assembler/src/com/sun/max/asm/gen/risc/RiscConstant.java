/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4c52046b-1591-4965-be63-ab7226246f03*/
package com.sun.max.asm.gen.risc;

import com.sun.max.asm.*;
import com.sun.max.asm.gen.risc.field.*;

/**
 * 
 *
 * @author Bernd Mathiske
 */
public class RiscConstant {

    private final RiscField _field;
    private final int _value;
    
    public RiscConstant(RiscField field, Argument argument) {
        _field = field;
        _value = (int) argument.asLong();
    }
    
    public RiscConstant(RiscField field, int value) {
        _field = field;
        _value = value;
    }

    public RiscField field() {
        return _field;
    }
    
    public int value() {
        return _value;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof RiscConstant) {
            final RiscConstant riscConstant = (RiscConstant) other;
            return _field.equals(riscConstant._field) && _value == riscConstant._value;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return _field.hashCode() ^ _value;
    }
    
    @Override
    public String toString() {
        return _field.toString() + "(" + _value + ")";
    }    
}

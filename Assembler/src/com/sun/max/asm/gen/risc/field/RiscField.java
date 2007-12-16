/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f74662dd-fa12-489e-ba2e-cb58b1a2f993*/
package com.sun.max.asm.gen.risc.field;

import com.sun.max.annotate.*;
import com.sun.max.asm.gen.risc.bitRange.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;

/**
 * A field describes a bit range and how it relates to an operand.
 * 
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public abstract class RiscField implements Cloneable, StaticFieldName, StaticFieldLiteral {

    private final BitRange _bitRange;
    
    protected RiscField(BitRange bitRange) {
        _bitRange = bitRange;
    }
    
    @Override
    public RiscField clone() {
        try {
            return (RiscField) super.clone();
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            ProgramError.unexpected("Field.clone() not supported");
        }
        return null;
    }
    
    private String _name;

    @Implement(StaticFieldName.class)
    public String name() {
        return _name;
    }

    @Implement(StaticFieldName.class)
    public void setName(String name) {
        _name = name;
    }
    
    private String _literal;

    @Implement(StaticFieldLiteral.class)
    public String literal() {
        return _literal;
    }

    @Implement(StaticFieldLiteral.class)
    public void setLiteral(String literal) {
        _literal = literal;
    }

    private Class _literalClass;
    
    @Implement(StaticFieldLiteral.class)
    public Class literalClass() {
        return _literalClass;
    }
    
    @Implement(StaticFieldLiteral.class)
    public void setLiteralClass(Class literalClass) {
        _literalClass = literalClass;
    }

    public BitRange bitRange() {
        return _bitRange;
    }

    /**
     * Two RISC fields are considered equal if they define the same set of bits in an instruction
     * (i.e. their bit ranges are equal).
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof RiscField) {
            final RiscField riscField = (RiscField) other;
            return bitRange().equals(riscField.bitRange());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = _bitRange.hashCode();
        if (_name != null) {
            result ^= _name.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        return name();
    }

}

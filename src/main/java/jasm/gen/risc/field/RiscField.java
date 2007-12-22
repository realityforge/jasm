/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.field;

import jasm.gen.risc.bitRange.BitRange;
import jasm.util.StaticFieldName;
import jasm.util.program.ProgramError;

/**
 * A field describes a bit range and how it relates to an operand.
 *
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public abstract class RiscField implements Cloneable, StaticFieldName {

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

    public String name() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
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

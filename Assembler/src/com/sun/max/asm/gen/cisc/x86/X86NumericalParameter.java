/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e07099c7-82fa-45f5-8659-02754b8e6d4c*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;

/**
 * @author Bernd Mathiske
 */
public abstract class X86NumericalParameter extends X86Parameter implements AppendedParameter, ImmediateParameter {

    private final WordWidth _width;

    public X86NumericalParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, ParameterPlace.APPEND);
        _width = width;
    }

    @Implement(AppendedParameter.class)
    public WordWidth width() {
        return _width;
    }

    @Implement(Parameter.class)
    public String valueString() {
        return variableName();
    }

    @Implement(Operand.class)
    public Class type() {
        return width().canonicalPrimitiveType();
    }

    @Implement(Parameter.class)
    public Iterable< ? extends ImmediateArgument> getLegalTestArguments() {
        try {
            switch (_width) {
                case BITS_8:
                    return Static.createSequence(Immediate8Argument.class, byte.class, Byte.MIN_VALUE, (byte) -1, (byte) 2, Byte.MAX_VALUE);
                case BITS_16:
                    return Static.createSequence(Immediate16Argument.class, short.class, Short.MIN_VALUE, (short) (Byte.MIN_VALUE - 1), (short) (Byte.MAX_VALUE + 1), Short.MAX_VALUE);
                case BITS_32:
                    return Static.createSequence(Immediate32Argument.class, int.class, Integer.MIN_VALUE, Short.MIN_VALUE - 1, Short.MAX_VALUE + 1, Integer.MAX_VALUE);
                case BITS_64:
                    return Static.createSequence(Immediate64Argument.class, long.class, Long.MIN_VALUE, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L, Long.MAX_VALUE);
                default:
                    ProgramError.unexpected();
                    return null;
            }
        } catch (Throwable throwable) {
            ProgramError.unexpected("could not generate test argument for: " + this, throwable);
        }
        return null;
    }

    @Implement(Parameter.class)
    public Iterable<? extends Argument> getIllegalTestArguments() {
        return Iterables.empty();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

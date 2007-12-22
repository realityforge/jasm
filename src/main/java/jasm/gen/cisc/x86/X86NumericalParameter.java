/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.Argument;
import jasm.WordWidth;
import jasm.gen.Immediate16Argument;
import jasm.gen.Immediate32Argument;
import jasm.gen.Immediate64Argument;
import jasm.gen.Immediate8Argument;
import jasm.gen.ImmediateArgument;
import jasm.gen.ImmediateParameter;
import jasm.gen.Parameter;
import jasm.util.program.ProgramError;
import java.util.Collections;

/**
 * @author Bernd Mathiske
 */
public abstract class X86NumericalParameter extends X86Parameter implements Parameter, ImmediateParameter {

    private final WordWidth _width;

    public X86NumericalParameter(X86Operand.Designation designation, WordWidth width) {
        super(designation, ParameterPlace.APPEND);
        _width = width;
    }

    public WordWidth width() {
        return _width;
    }

    public String valueString() {
        return variableName();
    }

    public Class type() {
        return width().canonicalPrimitiveType();
    }

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

    public Iterable<? extends Argument> getIllegalTestArguments() {
      return Collections.emptySet();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

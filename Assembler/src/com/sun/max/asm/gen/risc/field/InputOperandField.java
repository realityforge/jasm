/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=40cde656-db9c-43c7-ba31-80bee57765cb*/
package com.sun.max.asm.gen.risc.field;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.bitRange.*;
import com.sun.max.collect.*;
import com.sun.max.program.*;

/**
 * An input operand is a parameter to an assembler method that does not correspond directly
 * to a set of bits in the instruction but is a term in an expression that gives the value
 * for another operand that does represent a set of bits in the instruction.
 *
 * @author Doug Simon
 */
public class InputOperandField extends OperandField<ImmediateArgument> {

    private final Iterable< ? extends Argument> _testArguments;
    private final ArgumentRange _argumentRange;

    public InputOperandField(Iterable< ? extends Argument> testArguments, ArgumentRange argumentRange) {
        super(BitRange.create(new int[] {-1}, BitRangeOrder.DESCENDING));
        _testArguments = testArguments;
        _argumentRange = argumentRange;
    }

    public static InputOperandField create(OperandField valueRangeProvider) {
        return new InputOperandField(valueRangeProvider.getLegalTestArguments(), valueRangeProvider.argumentRange());
    }

    @Override
    public ImmediateArgument disassemble(int instruction) {
        ProgramError.unexpected();
        return null;
    }

    @Override
    public Class type() {
        return int.class;
    }

    public String valueString() {
        return variableName();
    }

    @Override
    public InputOperandField setVariableName(String name) {
        super.setVariableName(name);
        return this;
    }

    public Iterable< ? extends Argument> getLegalTestArguments() {
        return _testArguments;
    }

    public Iterable<? extends Argument> getIllegalTestArguments() {
        return Iterables.empty();
    }

    public ArgumentRange argumentRange() {
        return _argumentRange;
    }

}

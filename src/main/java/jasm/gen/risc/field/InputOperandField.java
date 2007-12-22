/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.field;

import jasm.Argument;
import jasm.gen.ArgumentRange;
import jasm.gen.ImmediateArgument;
import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.bitRange.BitRangeOrder;
import jasm.util.program.ProgramError;
import java.util.Collections;

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
      return Collections.emptySet();
    }

    public ArgumentRange argumentRange() {
        return _argumentRange;
    }

}

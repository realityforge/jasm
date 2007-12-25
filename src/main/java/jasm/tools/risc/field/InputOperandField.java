/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.field;

import jasm.Argument;
import jasm.tools.ArgumentRange;
import jasm.tools.ImmediateArgument;
import jasm.tools.risc.bitRange.BitRange;
import jasm.tools.risc.bitRange.BitRangeOrder;
import java.util.Collections;

/**
 * An input operand is a parameter to an assembler method that does not correspond directly
 * to a set of bits in the instruction but is a term in an expression that gives the value
 * for another operand that does represent a set of bits in the instruction.
 */
public final class InputOperandField extends OperandField<ImmediateArgument> {

  private final Iterable<? extends Argument> _testArguments;
  private final ArgumentRange _argumentRange;

  public InputOperandField(Iterable<? extends Argument> testArguments, ArgumentRange argumentRange) {
    super(BitRange.create(new int[]{-1}, BitRangeOrder.DESCENDING));
    _testArguments = testArguments;
    _argumentRange = argumentRange;
  }

  public static InputOperandField create(OperandField valueRangeProvider) {
    return new InputOperandField(valueRangeProvider.getLegalTestArguments(), valueRangeProvider.argumentRange());
  }

  @Override
  public final ImmediateArgument disassemble(int instruction) {
    throw new UnsupportedOperationException();
  }

  public final Class type() {
    return int.class;
  }

  public final String valueString() {
    return variableName();
  }

  @Override
  public final InputOperandField setVariableName(String name) {
    super.setVariableName(name);
    return this;
  }

  public final Iterable<? extends Argument> getLegalTestArguments() {
    return _testArguments;
  }

  public final Iterable<? extends Argument> getIllegalTestArguments() {
    return Collections.emptySet();
  }

  public final ArgumentRange argumentRange() {
    return _argumentRange;
  }

}

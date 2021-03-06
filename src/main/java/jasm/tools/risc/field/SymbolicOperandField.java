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
import jasm.SymbolSet;
import jasm.SymbolicArgument;
import jasm.tools.ArgumentRange;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.TestArgumentExclusion;
import jasm.tools.risc.RiscConstant;
import jasm.tools.risc.bitRange.BitRange;
import jasm.tools.risc.bitRange.BitRangeOrder;
import jasm.tools.util.CollectionUtil;
import jasm.util.StaticLoophole;
import java.util.Collections;

public final class SymbolicOperandField<Argument_Type extends SymbolicArgument>
    extends OperandField<Argument_Type> {

  private final SymbolSet<Argument_Type> _symbols;

  public SymbolicOperandField(BitRange bitRange, SymbolSet<Argument_Type> symbols) {
    super(bitRange);
    assert symbols != null;
    _symbols = symbols;
  }

  public static <Argument_Type extends SymbolicArgument> SymbolicOperandField<Argument_Type> createAscending(
      SymbolSet<Argument_Type> symbols, int... bits) {
    final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
    return new SymbolicOperandField<Argument_Type>(bitRange, symbols);
  }

  public static <Argument_Type extends SymbolicArgument> SymbolicOperandField<Argument_Type> createDescending(String variableName,
                                                                                                              final SymbolSet<Argument_Type> symbols, int... bits) {
    final BitRange bitRange = BitRange.create(bits, BitRangeOrder.DESCENDING);
    final SymbolicOperandField<Argument_Type> field = new SymbolicOperandField<Argument_Type>(bitRange, symbols);
    if (variableName != null) {
      field.setVariableName(variableName);
    }
    return field;
  }

  public static <Argument_Type extends SymbolicArgument> SymbolicOperandField<Argument_Type> createDescending(SymbolSet<Argument_Type> symbols, int... bits) {
    return createDescending(null, symbols, bits);
  }

  public final RiscConstant constant(Argument_Type argument) {
    return new RiscConstant(new ConstantField(name(), bitRange()), argument);
  }

  public final Class type() {
    return _symbols.type();
  }

  public final String valueString() {
    if (boundTo() != null) {
      return boundTo().valueString();
    }
    return variableName() + ".value()";
  }

  @Override
  public final Argument_Type disassemble(int instruction) {
    return _symbols.fromValue(extract(instruction));
  }

  @Override
  public final SymbolicOperandField<Argument_Type> setVariableName(String name) {
    super.setVariableName(name);
    return this;
  }

  public final ArgumentRange argumentRange() {
    return null;
  }

  public final Iterable<? extends Argument> getLegalTestArguments() {
    return _symbols;
  }

  public final Iterable<? extends Argument> getIllegalTestArguments() {
    return Collections.emptySet();
  }

  public final TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
    return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, this, CollectionUtil.hashSetFrom(arguments));
  }

  @Override
  public final SymbolicOperandField<Argument_Type> bindTo(Expression expression) {
    return StaticLoophole.cast(super.bindTo(expression));
  }
}

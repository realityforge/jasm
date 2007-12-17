/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.field;

import com.sun.max.collect.Iterables;
import jasm.util.Sets;
import com.sun.max.lang.StaticLoophole;
import jasm.Argument;
import jasm.AssemblyException;
import jasm.SymbolicArgument;
import jasm.gen.ArgumentRange;
import jasm.gen.AssemblyTestComponent;
import jasm.gen.Expression;
import jasm.gen.TestArgumentExclusion;
import jasm.gen.WrappableSpecification;
import jasm.gen.risc.RiscConstant;
import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.bitRange.BitRangeOrder;
import jasm.util.Symbolizer;

/**
 * @author Bernd Mathiske
 * @author Doug Simon
 * @author Dave Ungar
 * @author Adam Spitz
 */
public class SymbolicOperandField<Argument_Type extends SymbolicArgument> extends OperandField<Argument_Type> implements WrappableSpecification {

    private final Symbolizer<Argument_Type> _symbolizer;

    public SymbolicOperandField(BitRange bitRange, Symbolizer<Argument_Type> symbolizer) {
        super(bitRange);
        assert symbolizer != null;
        _symbolizer = symbolizer;
    }

    public static <Argument_Type extends SymbolicArgument> SymbolicOperandField<Argument_Type> createAscending(
        Symbolizer<Argument_Type> symbolizer, int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
        return new SymbolicOperandField<Argument_Type>(bitRange, symbolizer);
    }

    public static <Argument_Type extends SymbolicArgument> SymbolicOperandField<Argument_Type> createDescending(String variableName,
                    final Symbolizer<Argument_Type> symbolizer, int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.DESCENDING);
        final SymbolicOperandField<Argument_Type> field = new SymbolicOperandField<Argument_Type>(bitRange, symbolizer);
        if (variableName != null) {
            field.setVariableName(variableName);
        }
        return field;
    }

    public static <Argument_Type extends SymbolicArgument> SymbolicOperandField<Argument_Type> createDescending(Symbolizer<Argument_Type> symbolizer, int... bits) {
        return createDescending(null, symbolizer, bits);
    }

    public RiscConstant constant(Argument_Type argument) {
        return new RiscConstant(new ConstantField(name(), bitRange()), argument);
    }

    public Class type() {
        return _symbolizer.type();
    }

    public String valueString() {
        if (boundTo() != null) {
            return boundTo().valueString();
        }
        return variableName() + ".value()";
    }

    public int assemble(Argument_Type argument) throws AssemblyException {
        return bitRange().assembleUncheckedUnsignedInt(argument.value());
    }

    @Override
    public Argument_Type disassemble(int instruction) {
        return _symbolizer.fromValue(extract(instruction));
    }

    @Override
    public SymbolicOperandField<Argument_Type> setVariableName(String name) {
        super.setVariableName(name);
        return this;
    }

    public ArgumentRange argumentRange() {
        return null;
    }

    public Iterable<? extends Argument> getLegalTestArguments() {
        return _symbolizer;
    }

    public Iterable<? extends Argument> getIllegalTestArguments() {
        return Iterables.empty();
    }

    @Override
    public SymbolicOperandField<Argument_Type> withExcludedExternalTestArguments(Argument... arguments) {
        return StaticLoophole.cast(super.withExcludedExternalTestArguments(arguments));
    }

    public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
        return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, this, Sets.from(arguments));
    }

    @Override
    public SymbolicOperandField<Argument_Type> bindTo(Expression expression) {
        return StaticLoophole.cast(super.bindTo(expression));
    }
}

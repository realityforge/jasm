/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7dbc991b-9411-4437-b4bf-231699b5acc6*/
package com.sun.max.asm.gen.risc.field;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.*;
import com.sun.max.asm.gen.risc.bitRange.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

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

    public static <Argument_Type extends SymbolicArgument> SymbolicOperandField<Argument_Type> createAscending(Symbolizer<Argument_Type> symbolizer, int... bits) {
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

    @Override
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
        final Class<SymbolicOperandField<Argument_Type>> type = null;
        return StaticLoophole.cast(type, super.withExcludedExternalTestArguments(arguments));
    }

    public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
        return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, this, Sets.from(arguments));
    }

    @Override
    public SymbolicOperandField<Argument_Type> bindTo(Expression expression) {
        final Class<SymbolicOperandField<Argument_Type>> type = null;
        return StaticLoophole.cast(type, super.bindTo(expression));
    }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a014e877-af4f-4f4d-a506-19635fd58e72*/
package com.sun.max.asm.gen.risc.field;

import java.lang.reflect.*;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.bitRange.*;
import com.sun.max.collect.*;

/**
 * A field that contains an immediate value.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 * @author Dave Ungar
 * @author Adam Spitz
 */
public class ImmediateOperandField extends OperandField<ImmediateArgument> implements ImmediateParameter, WrappableSpecification, InstructionConstraint {

    public String asJavaExpression() {
        final String value = valueString();
        return minArgumentValue() + " <= " + value + " && " + value + " <= " + maxArgumentValue();
    }

    public boolean check(Template template, Sequence<Argument> arguments) {
        final long value = evaluate(template, arguments);
        return minArgumentValue() <= value && value <= maxArgumentValue();
    }

    public Method predicateMethod() {
        return null;
    }

    public boolean referencesParameter(Parameter parameter) {
        return parameter == this;
    }

    public ImmediateOperandField(BitRange bitRange) {
        super(bitRange);
    }

    public static ImmediateOperandField createDescending(int firstBitIndex, int lastBitIndex) {
        return new ImmediateOperandField(new DescendingBitRange(firstBitIndex, lastBitIndex));
    }

    public static ImmediateOperandField createAscending(int firstBitIndex, int lastBitIndex) {
        return new ImmediateOperandField(new AscendingBitRange(firstBitIndex, lastBitIndex));
    }

    public static ImmediateOperandField createAscending(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
        return new ImmediateOperandField(bitRange);
    }

    @Override
    public Class type() {
        return int.class;
    }

    public String valueString() {
        if (boundTo() != null) {
            return boundTo().valueString();
        }
        return variableName();
    }

    @Override
    public ImmediateOperandField beSigned() {
        return (ImmediateOperandField) super.beSigned();
    }

    @Override
    public ImmediateOperandField beSignedOrUnsigned() {
        return (ImmediateOperandField) super.beSignedOrUnsigned();
    }

    @Override
    public Immediate32Argument disassemble(int instruction) {
        return new Immediate32Argument(extract(instruction));
    }

    @Override
    public ImmediateOperandField setVariableName(String name) {
        super.setVariableName(name);
        return this;
    }

    private ArgumentRange _argumentRange;

    public ArgumentRange argumentRange() {
        if (_argumentRange == null) {
            _argumentRange = new ArgumentRange(this, minArgumentValue(), maxArgumentValue());
        }
        return _argumentRange;
    }

    private Iterable<? extends Argument> _testArguments;
    private Iterable<? extends Argument> _illegalTestArguments;

    private static final MapFunction<Integer, Immediate32Argument> ARGUMENT_WRAPPER = new MapFunction<Integer, Immediate32Argument>() {
        public Immediate32Argument map(Integer integer) {
            return new Immediate32Argument(integer);
        }
    };

    public Iterable<? extends Argument> getLegalTestArguments() {
        if (_testArguments == null) {
            final Sequence<Integer> integers = signDependentOperations().legalTestArgumentValues(minArgumentValue(), maxArgumentValue(), grain());
            _testArguments = integers.map(Immediate32Argument.class, ARGUMENT_WRAPPER);
        }
        return _testArguments;
    }

    public Iterable<? extends Argument> getIllegalTestArguments() {
        if (_illegalTestArguments == null) {
            final AppendableSequence<Immediate32Argument> illegalTestArguments = new ArrayListSequence<Immediate32Argument>(4);
            final int min = minArgumentValue();
            if (min != Integer.MIN_VALUE) {
                illegalTestArguments.append(new Immediate32Argument(min - 1));
                illegalTestArguments.append(new Immediate32Argument(Integer.MIN_VALUE));
            }
            final int max = maxArgumentValue();
            if (max != Integer.MAX_VALUE) {
                illegalTestArguments.append(new Immediate32Argument(max + 1));
                illegalTestArguments.append(new Immediate32Argument(Integer.MAX_VALUE));
            }
            _illegalTestArguments = illegalTestArguments;
        }
        return _illegalTestArguments;
    }

    public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
        return TestArgumentExclusion.NONE;
    }

    @Override
    public ImmediateOperandField bindTo(Expression expression) {
        return (ImmediateOperandField) super.bindTo(expression);
    }
}

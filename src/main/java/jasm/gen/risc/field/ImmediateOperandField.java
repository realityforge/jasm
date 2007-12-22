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
import jasm.gen.Expression;
import jasm.gen.Immediate32Argument;
import jasm.gen.ImmediateArgument;
import jasm.gen.ImmediateParameter;
import jasm.gen.InstructionConstraint;
import jasm.gen.Parameter;
import jasm.gen.Template;
import jasm.gen.TestArgumentExclusion;
import jasm.gen.WrappableSpecification;
import jasm.gen.risc.bitRange.AscendingBitRange;
import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.bitRange.BitRangeOrder;
import jasm.gen.risc.bitRange.DescendingBitRange;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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

    public boolean check(Template template, List<Argument> arguments) {
        final long value = evaluate(template, arguments);
        return minArgumentValue() <= value && value <= maxArgumentValue();
    }

    public final Method predicateMethod() {
        return null;
    }

    public final boolean referencesParameter(Parameter parameter) {
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

    public final Class type() {
        return int.class;
    }

    public final String valueString() {
        if (boundTo() != null) {
            return boundTo().valueString();
        }
        return variableName();
    }

    @Override
    public final ImmediateOperandField beSigned() {
        return (ImmediateOperandField) super.beSigned();
    }

    @Override
    public final ImmediateOperandField beSignedOrUnsigned() {
        return (ImmediateOperandField) super.beSignedOrUnsigned();
    }

    @Override
    public Immediate32Argument disassemble(int instruction) {
        return new Immediate32Argument(extract(instruction));
    }

    @Override
    public final ImmediateOperandField setVariableName(String name) {
        super.setVariableName(name);
        return this;
    }

    private ArgumentRange _argumentRange;

    public final ArgumentRange argumentRange() {
        if (_argumentRange == null) {
            _argumentRange = new ArgumentRange(this, minArgumentValue(), maxArgumentValue());
        }
        return _argumentRange;
    }

    private Iterable<? extends Argument> _testArguments;
    private Iterable<? extends Argument> _illegalTestArguments;

    public final Iterable<? extends Argument> getLegalTestArguments() {
      if (_testArguments == null) {
        final List<Integer> integers =
            signDependentOperations().legalTestArgumentValues(minArgumentValue(), maxArgumentValue(), grain());
        final ArrayList<Immediate32Argument> to = new ArrayList<Immediate32Argument>(integers.size());
        for (Integer integer : integers) {
          to.add(new Immediate32Argument(integer));
        }
        _testArguments = to;
      }
        return _testArguments;
    }

    public final Iterable<? extends Argument> getIllegalTestArguments() {
        if (_illegalTestArguments == null) {
            final ArrayList<Immediate32Argument> illegalTestArguments = new ArrayList<Immediate32Argument>(4);
            final int min = minArgumentValue();
            if (min != Integer.MIN_VALUE) {
                illegalTestArguments.add(new Immediate32Argument(min - 1));
                illegalTestArguments.add(new Immediate32Argument(Integer.MIN_VALUE));
            }
            final int max = maxArgumentValue();
            if (max != Integer.MAX_VALUE) {
                illegalTestArguments.add(new Immediate32Argument(max + 1));
                illegalTestArguments.add(new Immediate32Argument(Integer.MAX_VALUE));
            }
            _illegalTestArguments = illegalTestArguments;
        }
        return _illegalTestArguments;
    }

    public final TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
        return TestArgumentExclusion.NONE;
    }

    @Override
    public final ImmediateOperandField bindTo(Expression expression) {
        return (ImmediateOperandField) super.bindTo(expression);
    }
}

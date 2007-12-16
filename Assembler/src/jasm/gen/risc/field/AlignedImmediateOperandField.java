/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=629a8fdc-ec6e-4188-951b-834cf1b9d6c7*/
package jasm.gen.risc.field;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.AssemblyException;
import jasm.gen.Immediate32Argument;
import jasm.gen.Template;
import jasm.gen.risc.bitRange.BitRange;

/**
 * An instruction field whose encoded value does not include bits for
 * the low-order 0 bits of the aligned values that the field represents.
 * This class can convert between the field's <i>argument</i> (i.e.
 * the represented value) and it's <i>operand</i> (i.e. the encoded value).
 *
 * @author Dave Ungar
 * @author Bernd Mathiske
 * @author Adam Spitz
 * @author Doug Simon
 */
public class AlignedImmediateOperandField extends ImmediateOperandField {

    protected int _zeroes;

    public AlignedImmediateOperandField(BitRange bitRange, int zeroes) {
        super(bitRange);
        _zeroes = zeroes;
    }

    @Override
    public String asJavaExpression() {
        final String value = valueString();
        return "(" + super.asJavaExpression() + ") && ((" + value + " % " + grain() + ") == 0)";
    }

    @Override
    public boolean check(Template template, Sequence<Argument> arguments) {
        if (!super.check(template, arguments)) {
            return false;
        }
        final long value = template.bindingFor(this, arguments).asLong();
        return (value % grain()) == 0;
    }

    @Override
    public int maxArgumentValue() {
        return super.maxArgumentValue() << zeroes();
    }

    @Override
    public int minArgumentValue() {
        return super.minArgumentValue() << zeroes();
    }

    @Override
    public int zeroes() {
        return _zeroes;
    }

    /**
     * Converts an argument value to the operand value that does not include bits for the
     * implied low-order 0 bits that the aligned argument value is guaranteed to contain.
     * For example, if this field represents a 4-byte aligned value, then {@code argumentToOperand(536) == 134}.
     */
    private int argumentToOperand(int value) throws AssemblyException {
        final int p = grain();
        if (value % p != 0) {
            throw new AssemblyException("unaligned immediate operand: " + value);
        }
        return value / p;
    }

    /**
     * Converts an operand value to the argument value that includes
     * low-order 0 bits for the alignment of this field.
     * For example, if this field represents a 4-byte aligned value,
     * then {@code operandToArgument(134) == 536}.
     */
    private int operandToArgument(int operand) {
        return operand << zeroes();
    }

    @Override
    public int assemble(int value) throws IndexOutOfBoundsException, AssemblyException {
        return super.assemble(argumentToOperand(value));
    }

    @Override
    public Immediate32Argument disassemble(int instruction) {
        return new Immediate32Argument(operandToArgument(extract(instruction)));
    }
}

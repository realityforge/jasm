/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=fe64cdcc-bbcf-4903-afe8-c2313d664d38*/
package jasm.gen.risc;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.program.Problem;
import com.sun.max.program.ProgramError;
import jasm.gen.InstructionConstraint;
import jasm.gen.InstructionDescription;
import jasm.gen.OffsetParameter;
import jasm.gen.Operand;
import jasm.gen.Template;
import jasm.gen.risc.field.OperandField;
import jasm.gen.risc.field.OptionField;
import jasm.gen.risc.field.ReservedField;
import jasm.gen.risc.field.RiscField;

/**
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public abstract class RiscTemplate extends Template implements RiscInstructionDescriptionVisitor {

    private final AppendableSequence<RiscField> _allFields = new ArrayListSequence<RiscField>();
    private final AppendableSequence<OperandField> _operandFields = new ArrayListSequence<OperandField>();
    private final AppendableSequence<OptionField> _optionFields = new ArrayListSequence<OptionField>();
    private final AppendableSequence<OperandField> _parameters = new ArrayListSequence<OperandField>();
    private final AppendableSequence<Option> _options = new ArrayListSequence<Option>();

    private int _opcode;
    private int _opcodeMask;
    private RiscTemplate _canonicalRepresentative;

    protected RiscTemplate(InstructionDescription instructionDescription) {
        super(instructionDescription);
    }

    @Override
    public RiscInstructionDescription instructionDescription() {
        return (RiscInstructionDescription) super.instructionDescription();
    }

    private RiscTemplate _synthesizedFrom;

    public void setSynthesizedFrom(RiscTemplate synthesizedFrom) {
        assert instructionDescription().isSynthetic();
        _synthesizedFrom = synthesizedFrom;
    }

    public RiscTemplate synthesizedFrom() {
        return _synthesizedFrom;
    }

    /**
     * Adds the value of a constant field to the opcode of the instruction and
     * updates the opcode mask to include the bits of the field.
     *
     * @param field a field containing a constant value
     * @param value the constant value
     */
    private void organizeConstant(RiscField field, int value) {
        try {
            _opcode |= field.bitRange().assembleUnsignedInt(value);
            _opcodeMask |= field.bitRange().instructionMask();
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            ProgramError.unexpected("operand for constant field " + field.name() + " does not fit: " + value);
        }
    }

    public void visitField(RiscField field) {
        _allFields.append(field);
        if (field instanceof OperandField) {
            final OperandField operandField = (OperandField) field;
            if (field instanceof OffsetParameter) {
                setLabelParameterIndex();
            }
            if (operandField.boundTo() == null) {
                _parameters.append(operandField);
            }
            _operandFields.append(operandField);
        } else if (field instanceof OptionField) {
            _optionFields.append((OptionField) field);
        } else if (field instanceof ReservedField) {
            organizeConstant(field, 0);
        } else {
            ProgramError.unexpected("unknown or unallowed type of field: " + field);
        }
    }

    public void visitConstant(RiscConstant constant) {
        organizeConstant(constant.field(), constant.value());
    }

    public void visitConstraint(InstructionConstraint constraint) {
    }

    /**
     * Sets the internal name of this template from a given string it is not already set.
     *
     * @param string  a string specified in the to consider
     */
    public void visitString(String string) {
        if (internalName() == null) {
            setInternalName(string);
        }
    }

    public Sequence<OperandField> operandFields() {
        return _operandFields;
    }

    public int opcode() {
        return _opcode;
    }

    public int opcodeMask() {
        return _opcodeMask;
    }

    public Sequence<OptionField> optionFields() {
        return _optionFields;
    }

    public void addOptionField(OptionField f) {
        _allFields.append(f);
        _optionFields.append(f);
    }

    public int specificity() {
        return Integer.bitCount(_opcodeMask);
    }

    public void organizeOption(Option option, RiscTemplate canonicalRepresentative) {
        instructionDescription().setExternalName(externalName() + option.externalName());
        setInternalName(internalName() + option.name());
        try {
            _opcode |= option.field().bitRange().assembleUnsignedInt(option.value());
            _opcodeMask |= option.field().bitRange().instructionMask();
        } catch (IndexOutOfBoundsException e) {
            ProgramError.unexpected("Option: " + option.name() + " does not fit in field " + option.field().name());
        }

        _options.append(option);
        if (option.isRedundant()) {
            _canonicalRepresentative = canonicalRepresentative;
        }
    }

    public boolean isRedundant() {
        return _canonicalRepresentative != null;
    }

    @Override
    public boolean isEquivalentTo(Template other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RiscTemplate)) {
            return false;
        }
        RiscTemplate a = this;
        if (a._canonicalRepresentative != null) {
            a = a._canonicalRepresentative;
        }
        RiscTemplate b = (RiscTemplate) other;
        if (b._canonicalRepresentative != null) {
            b = b._canonicalRepresentative;
        }
        return a == b;
    }

    @Override
    public String assemblerMethodName() {
        return internalName();
    }

    @Override
    public Sequence<Operand> operands() {
        Problem.unimplemented();
        return null;
    }

    @Override
    public Sequence<OperandField> parameters() {
        return _parameters;
    }

    @Override
    public String toString() {
        return "<" + getClass().getSimpleName() + " #" + serial() + ": " + internalName() + " " + Integer.toHexString(opcode()) + ", " + parameters() + ">";
    }

}

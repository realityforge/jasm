/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.tools.InstructionConstraint;
import jasm.tools.InstructionDescription;
import jasm.tools.OffsetParameter;
import jasm.tools.Operand;
import jasm.tools.Template;
import jasm.tools.risc.field.OperandField;
import jasm.tools.risc.field.OptionField;
import jasm.tools.risc.field.ReservedField;
import jasm.tools.risc.field.RiscField;
import java.util.ArrayList;
import java.util.List;

public abstract class RiscTemplate extends Template implements RiscInstructionDescriptionVisitor {

    private final ArrayList<OperandField> _operandFields = new ArrayList<OperandField>();
    private final ArrayList<OptionField> _optionFields = new ArrayList<OptionField>();
    private final ArrayList<OperandField> _parameters = new ArrayList<OperandField>();

    private int _opcode;
    private int _opcodeMask;
    private RiscTemplate _canonicalRepresentative;

    protected RiscTemplate(InstructionDescription instructionDescription) {
        super(instructionDescription);
    }

    @Override
    public final RiscInstructionDescription instructionDescription() {
        return (RiscInstructionDescription) super.instructionDescription();
    }

    private RiscTemplate _synthesizedFrom;

    public final void setSynthesizedFrom(RiscTemplate synthesizedFrom) {
        assert instructionDescription().isSynthetic();
        _synthesizedFrom = synthesizedFrom;
    }

    public final RiscTemplate synthesizedFrom() {
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
            throw new IllegalStateException("operand for constant field " + field.name() + " does not fit: " + value);
        }
    }

    public final void visitField(RiscField field) {
        if (field instanceof OperandField) {
            final OperandField operandField = (OperandField) field;
            if (field instanceof OffsetParameter) {
                setLabelParameterIndex();
            }
            if (operandField.boundTo() == null) {
                _parameters.add(operandField);
            }
            _operandFields.add(operandField);
        } else if (field instanceof OptionField) {
            _optionFields.add((OptionField) field);
        } else if (field instanceof ReservedField) {
            organizeConstant(field, 0);
        } else {
            throw new IllegalStateException("unknown or unallowed type of field: " + field);
        }
    }

    public final void visitConstant(RiscConstant constant) {
        organizeConstant(constant.field(), constant.value());
    }

    public final void visitConstraint(InstructionConstraint constraint) {
    }

    /**
     * Sets the internal name of this template from a given string it is not already set.
     *
     * @param string  a string specified in the to consider
     */
    public final void visitString(String string) {
        if (internalName() == null) {
            setInternalName(string);
        }
    }

    public final List<OperandField> operandFields() {
        return _operandFields;
    }

    public final int opcode() {
        return _opcode;
    }

    public final int opcodeMask() {
        return _opcodeMask;
    }

    public final List<OptionField> optionFields() {
        return _optionFields;
    }

  public final int specificity() {
        return Integer.bitCount(_opcodeMask);
    }

    public final void organizeOption(Option option, RiscTemplate canonicalRepresentative) {
        instructionDescription().setExternalName(externalName() + option.externalName());
        setInternalName(internalName() + option.name());
        try {
            _opcode |= option.field().bitRange().assembleUnsignedInt(option.value());
            _opcodeMask |= option.field().bitRange().instructionMask();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Option: " + option.name() + " does not fit in field " + option.field().name());
        }

        if (option.isRedundant()) {
            _canonicalRepresentative = canonicalRepresentative;
        }
    }

    public final boolean isRedundant() {
        return _canonicalRepresentative != null;
    }

    @Override
    public final boolean isEquivalentTo(Template other) {
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
    public final String assemblerMethodName() {
        return internalName();
    }

    @Override
    public final List<Operand> operands() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final List<OperandField> parameters() {
        return _parameters;
    }

    @Override
    public final String toString() {
        return "<" + getClass().getSimpleName() + " #" + serial() + ": " + internalName() + " " + Integer.toHexString(opcode()) + ", " + parameters() + ">";
    }

}

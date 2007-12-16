/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=2d9999b3-5ec5-41c8-87d2-888f1ecd147c*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.*;
import com.sun.max.asm.x86.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
public abstract class X86Template extends Template implements X86InstructionDescriptionVisitor {
    // Defaults initial capacity for the ArrayListSequences below.
    private static final int MAX_NUM_OF_OPERANDS = 3;
    private static final int MAX_NUM_OF_IMPLICIT_OPERANDS = 3;
    private static final int MAX_NUM_OF_PARAMETERS = 3;

    private final InstructionAssessment _instructionFamily;
    private boolean _hasSibByte;
    private final X86TemplateContext _context;
    private HexByte _instructionSelectionPrefix;
    private HexByte _opcode1;
    private HexByte _opcode2;
    private ModRMGroup _modRMGroup;
    private ModRMGroup.Opcode _modRMGroupOpcode;
    private AppendableSequence<X86Operand> _operands = new ArrayListSequence<X86Operand>(MAX_NUM_OF_OPERANDS);
    private AppendableSequence<X86ImplicitOperand> _implicitOperands = new ArrayListSequence<X86ImplicitOperand>(MAX_NUM_OF_IMPLICIT_OPERANDS);
    private AppendableSequence<X86Parameter> _parameters = new ArrayListSequence<X86Parameter>(MAX_NUM_OF_PARAMETERS);
    protected boolean _isLabelMethodWritten;

    protected X86Template(X86InstructionDescription instructionDescription, int serial, InstructionAssessment instructionFamily, X86TemplateContext context) {
        super(instructionDescription, serial);
        _instructionFamily = instructionFamily;
        _context = context;
        Trace.line(2, "template #" + serial + ": " + context);
    }

    @Override
    public X86InstructionDescription instructionDescription() {
        return (X86InstructionDescription) super.instructionDescription();
    }

    protected X86TemplateContext context() {
        return _context;
    }

    public HexByte instructionSelectionPrefix() {
        return _instructionSelectionPrefix;
    }

    public HexByte opcode1() {
        return _opcode1;
    }

    public HexByte opcode2() {
        return _opcode2;
    }

    public boolean hasModRMByte() {
        return _instructionFamily.hasModRMByte();
    }

    public X86TemplateContext.ModCase modCase() {
        return _context.modCase();
    }

    public ModRMGroup modRMGroup() {
        return _modRMGroup;
    }

    public ModRMGroup.Opcode modRMGroupOpcode() {
        return _modRMGroupOpcode;
    }

    public X86TemplateContext.RMCase rmCase() {
        return _context.rmCase();
    }

    public boolean hasSibByte() {
        return _hasSibByte;
    }

    protected void haveSibByte() {
        _hasSibByte = true;
    }

    public X86TemplateContext.SibBaseCase sibBaseCase() {
        return _context.sibBaseCase();
    }

    public WordWidth addressSizeAttribute() {
        return _context.addressSizeAttribute();
    }

    public WordWidth operandSizeAttribute() {
        return _context.operandSizeAttribute();
    }

    private WordWidth _externalCodeSizeAttribute;

    public WordWidth externalCodeSizeAttribute() {
        return _externalCodeSizeAttribute;
    }

    protected void setExternalCodeSizeAttribute(WordWidth externalCodeSizeAttribute) {
        _externalCodeSizeAttribute = externalCodeSizeAttribute;
    }

    @Override
    public String internalName() {
        String result = super.internalName();
        if (result != null && _internalOperandTypeSuffix != null) {
            result += _internalOperandTypeSuffix;
        }
        return result;
    }

    @Override
    public String externalName() {
        if (instructionDescription().externalName() != null) {
            return instructionDescription().externalName();
        }
        String result = super.internalName();
        if (_externalOperandTypeSuffix != null) {
            result += _externalOperandTypeSuffix;
        }
        return result;
    }

    private String format(HexByte parameter) {
        return parameter == null ? "" : parameter.toString() + ", ";
    }

    @Override
    public String toString() {
        return "<X86Template #" + serial() + ": " + internalName() + " " + format(_instructionSelectionPrefix) + format(_opcode1) + format(_opcode2) + _operands + ">";
    }

    private String _namePrefix = "";

    protected void useNamePrefix(String namePrefix) {
        if (_namePrefix.length() == 0) {
            _namePrefix = namePrefix;
        }
    }

    private String _assemblerMethodName;

    @Override
    public String assemblerMethodName() {
        if (_assemblerMethodName == null) {
            _assemblerMethodName = _namePrefix + internalName();
            if (_implicitOperands.length() == 1) {
                final X86ImplicitOperand implicitOperand = _implicitOperands.first();
                switch (implicitOperand.designation()) {
                    case DESTINATION:
                    case OTHER:
                        break;
                    case SOURCE:
                        _assemblerMethodName += "__";
                        break;
                }
                _assemblerMethodName += "_" + implicitOperand.name();
            } else {
                for (X86ImplicitOperand implicitOperand : _implicitOperands) {
                    _assemblerMethodName += "_" + implicitOperand.name();
                }
            }
        }
        return _assemblerMethodName;
    }

    public boolean isExternalOperandOrderingInverted() {
        return instructionDescription().isExternalOperandOrderingInverted();
    }

    public InstructionDescription modRMInstructionDescription() {
        if (_modRMGroup == null) {
            return null;
        }
        return _modRMGroup.getInstructionDescription(_modRMGroupOpcode);
    }

    protected <Parameter_Type extends X86Parameter> Parameter_Type addParameter(Parameter_Type parameter) {
        _parameters.append(parameter);
        _operands.append(parameter);
        if (parameter instanceof X86AddressParameter) {
            useNamePrefix("m_");
        }
        return parameter;
    }

    protected void addParameter(X86Parameter parameter, ArgumentRange argumentRange) {
        addParameter(parameter);
        parameter.setArgumentRange(argumentRange);
    }

    protected void addParameter(X86Parameter parameter, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion) {
        addParameter(parameter, argumentRange);
        parameter.excludeTestArguments(testArgumentExclusion);
    }

    protected <EnumerableArgument_Type extends Enum<EnumerableArgument_Type> & EnumerableArgument<EnumerableArgument_Type>> X86Parameter addEnumerableParameter(X86Operand.Designation designation, ParameterPlace parameterPlace,
                                            final Enumerator<EnumerableArgument_Type> enumerator) {
        return addParameter(new X86EnumerableParameter<EnumerableArgument_Type>(designation, parameterPlace, enumerator));
    }

    protected void addImplicitOperand(X86ImplicitOperand implicitOperand) {
        _implicitOperands.append(implicitOperand);
        _operands.append(implicitOperand);
    }

    public Sequence<X86ImplicitOperand> implicitOperands() {
        return _implicitOperands;
    }

    @Override
    public Sequence<X86Operand> operands() {
        return _operands;
    }

    @Override
    public Sequence<X86Parameter> parameters() {
        return _parameters;
    }

    public void visitAddressingMethodCode(AddressingMethodCode addressingMethodCode, X86Operand.Designation designation) throws TemplateNotNeededException {
        switch (addressingMethodCode) {
            case M: {
                visitOperandCode(OperandCode.Mv, designation, ArgumentRange.UNSPECIFIED, TestArgumentExclusion.NONE);
                break;
            }
            default: {
                ProgramError.unexpected("don't know what to do with addressing method code: " + addressingMethodCode);
                break;
            }
        }
    }

    private String getOperandTypeSuffix(OperandTypeCode operandTypeCode) throws TemplateNotNeededException {
        switch (operandTypeCode) {
            case b:
                return "b";
            case z:
                if (operandSizeAttribute() != addressSizeAttribute()) {
                    throw new TemplateNotNeededException();
                }
            case d_q:
            case v:
                switch (operandSizeAttribute()) {
                    case BITS_16:
                        return "w";
                    case BITS_32:
                        return "l";
                    case BITS_64:
                        return "q";
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            default:
                break;
        }
        return operandTypeCode.name();
    }

    private void checkSuffix(String newSuffix, String oldSuffix) {
        if (oldSuffix != null) {
            ProgramError.check(newSuffix.equals(oldSuffix), "conflicting operand type codes specified: " + newSuffix + " vs. " + oldSuffix);
        }
    }

    private String _externalOperandTypeSuffix;

    private void setExternalOperandTypeSuffix(String suffix) {
        checkSuffix(suffix, _externalOperandTypeSuffix);
        _externalOperandTypeSuffix = suffix;
    }

    protected void setExternalOperandTypeSuffix(OperandTypeCode operandTypeCode) throws TemplateNotNeededException {
        setExternalOperandTypeSuffix(getOperandTypeSuffix(operandTypeCode));
    }

    private String _internalOperandTypeSuffix;

    protected void setOperandTypeSuffix(String suffix) {
        setExternalOperandTypeSuffix(suffix);
        checkSuffix(suffix, _internalOperandTypeSuffix);
        _internalOperandTypeSuffix = suffix;
    }

    public void visitOperandTypeCode(OperandTypeCode operandTypeCode) throws TemplateNotNeededException {
        setOperandTypeSuffix(getOperandTypeSuffix(operandTypeCode));
    }

    public void visitGeneralRegister(GeneralRegister generalRegister, X86Operand.Designation designation, ImplicitOperand.ExternalPresence externalPresence) {
        addImplicitOperand(new X86ImplicitOperand(designation, externalPresence, generalRegister));
    }

    public void visitSegmentRegister(SegmentRegister segmentRegister, X86Operand.Designation designation) {
        addImplicitOperand(new X86ImplicitOperand(designation, ImplicitOperand.ExternalPresence.EXPLICIT, segmentRegister));
    }

    public void visitModRMGroup(ModRMGroup modRMGroup) throws TemplateNotNeededException {
        _modRMGroup = modRMGroup;
        final ModRMDescription instructionDescription = modRMGroup.getInstructionDescription(_context.modRMGroupOpcode());
        if (instructionDescription == null) {
            throw new TemplateNotNeededException();
        }
        _modRMGroupOpcode = instructionDescription.opcode();
        setInternalName(instructionDescription.name().toLowerCase());
    }

    public void visitModCase(X86TemplateContext.ModCase modCase) throws TemplateNotNeededException {
        if (_context.modCase() != X86TemplateContext.ModCase.MOD_3) {
            throw new TemplateNotNeededException();
        }
    }

    public void visitInstructionConstraint(InstructionConstraint constraint) {
    }

    protected abstract void organize_M(X86Operand.Designation designation) throws TemplateNotNeededException;

    protected <EnumerableArgument_Type extends Enum<EnumerableArgument_Type> & EnumerableArgument<EnumerableArgument_Type>> void organize_E(X86Operand.Designation designation, ParameterPlace place,
                    final Enumerator<EnumerableArgument_Type> registerEnumerator, TestArgumentExclusion testArgumentExclusion) throws TemplateNotNeededException {
        if (context().modCase() == X86TemplateContext.ModCase.MOD_3) {
            switch (context().rmCase()) {
                case NORMAL:
                    addEnumerableParameter(designation, place, registerEnumerator).excludeTestArguments(testArgumentExclusion);
                    break;
                default:
                    throw new TemplateNotNeededException();
            }
        } else {
            organize_M(designation);
        }
    }

    public void visitFloatingPointOperandCode(FloatingPointOperandCode floatingPointOperandCode, X86Operand.Designation designation,
                                              final TestArgumentExclusion testArgumentExclusion) throws TemplateNotNeededException {
        switch (floatingPointOperandCode) {
            case ST_i:
                addEnumerableParameter(designation, ParameterPlace.OPCODE2, FPStackRegister.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            default:
                setOperandTypeSuffix(floatingPointOperandCode.operandTypeSuffix());
                organize_M(designation);
                break;
        }
    }

    public void visitFPStackRegister(FPStackRegister fpStackRegister, X86Operand.Designation designation) {
        addImplicitOperand(new X86ImplicitOperand(designation, ImplicitOperand.ExternalPresence.EXPLICIT, fpStackRegister));
    }

    public void visitString(String string) {
        assert internalName() == null;
        setInternalName(string.toLowerCase());
    }

    public void visitInteger(Integer integer, X86Operand.Designation designation) {
        addImplicitOperand(new X86ImplicitOperand(designation, ImplicitOperand.ExternalPresence.EXPLICIT, new Immediate8Argument((byte) integer.intValue())));
    }

    public void visitHexByte(HexByte hexByte) throws TemplateNotNeededException {
        if (_opcode1 == null) {
            _opcode1 = hexByte;
        } else if (_opcode2 == null) {
            _opcode2 = hexByte;
        } else {
            if (hexByte == HexByte._66 && _context.operandSizeAttribute() == WordWidth.BITS_16) {
                throw new TemplateNotNeededException();
            }
            assert _instructionSelectionPrefix == null;
            _instructionSelectionPrefix = _opcode1;
            _opcode1 = _opcode2;
            _opcode2 = hexByte;
        }
    }

    /**
     * @param other
     *            another template to compare against
     * @return whether both templates have the same name and operands and thus
     *         are assumed to implement the same machine instruction semantics,
     *         though potentially denoting different machine codes
     */
    public boolean isRedundant(X86Template other) {
        if (!assemblerMethodName().equals(other.assemblerMethodName())) {
            return false;
        }
        if (_parameters.length() != other._parameters.length()) {
            return false;
        }
        for (int i = 0; i < _parameters.length(); i++) {
            if (!_parameters.get(i).type().equals(other._parameters.get(i).type())) {
                return false;
            }
        }
        return true;
    }

}

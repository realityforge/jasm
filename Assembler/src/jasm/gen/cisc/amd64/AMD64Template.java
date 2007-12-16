/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e4eb5a08-e8c1-43d1-a1d8-3997a485e4ae*/
package jasm.gen.cisc.amd64;

import com.sun.max.collect.Sequence;
import com.sun.max.program.ProgramError;
import jasm.Argument;
import jasm.amd64.AMD64BaseRegister32;
import jasm.amd64.AMD64BaseRegister64;
import jasm.amd64.AMD64GeneralRegister16;
import jasm.amd64.AMD64GeneralRegister32;
import jasm.amd64.AMD64GeneralRegister64;
import jasm.amd64.AMD64GeneralRegister8;
import jasm.amd64.AMD64IndexRegister32;
import jasm.amd64.AMD64IndexRegister64;
import jasm.amd64.AMD64IndirectRegister32;
import jasm.amd64.AMD64IndirectRegister64;
import jasm.amd64.AMD64XMMComparison;
import jasm.amd64.AMD64XMMRegister;
import jasm.gen.ArgumentRange;
import jasm.gen.ImplicitOperand;
import jasm.gen.TestArgumentExclusion;
import jasm.gen.cisc.TemplateNotNeededException;
import jasm.gen.cisc.x86.InstructionAssessment;
import jasm.gen.cisc.x86.OperandCode;
import jasm.gen.cisc.x86.ParameterPlace;
import jasm.gen.cisc.x86.RegisterOperandCode;
import jasm.gen.cisc.x86.X86AddressParameter;
import jasm.gen.cisc.x86.X86DisplacementParameter;
import jasm.gen.cisc.x86.X86EnumerableParameter;
import jasm.gen.cisc.x86.X86ImmediateParameter;
import jasm.gen.cisc.x86.X86ImplicitOperand;
import jasm.gen.cisc.x86.X86InstructionDescription;
import jasm.gen.cisc.x86.X86OffsetParameter;
import jasm.gen.cisc.x86.X86Operand;
import jasm.gen.cisc.x86.X86Template;
import jasm.gen.cisc.x86.X86TemplateContext;
import jasm.util.WordWidth;
import jasm.x86.ControlRegister;
import jasm.x86.DebugRegister;
import jasm.x86.GeneralRegister;
import jasm.x86.MMXRegister;
import jasm.x86.Scale;
import jasm.x86.SegmentRegister;

/**
 * @author Bernd Mathiske
 */
public class AMD64Template extends X86Template {

    AMD64Template(X86InstructionDescription instructionDescription, int serial, InstructionAssessment instructionFamily, X86TemplateContext context) {
        super(instructionDescription, serial, instructionFamily, context);
    }

    private void addSib(X86Operand.Designation designation) throws TemplateNotNeededException {
        assert context().addressSizeAttribute() != WordWidth.BITS_16;
        haveSibByte();
        switch (context().sibBaseCase()) {
            case GENERAL_REGISTER: {
                switch (context().addressSizeAttribute()) {
                    case BITS_32:
                        setExternalCodeSizeAttribute(context().addressSizeAttribute());
                        addEnumerableParameter(designation, ParameterPlace.SIB_BASE, AMD64BaseRegister32.ENUMERATOR);
                        break;
                    case BITS_64:
                        addEnumerableParameter(designation, ParameterPlace.SIB_BASE_REXB, AMD64BaseRegister64.ENUMERATOR);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case SPECIAL: {
                switch (context().modCase()) {
                    case MOD_0: {
                        setExternalCodeSizeAttribute(context().addressSizeAttribute());
                        addParameter(new X86AddressParameter(designation, WordWidth.BITS_32));
                        break;
                    }
                    default: {
                        ProgramError.unexpected("no special SIB base for mod != 0");
                        break;
                    }
                }
                break;
            }
        }
        switch (context().sibIndexCase()) {
            case GENERAL_REGISTER:
                switch (context().addressSizeAttribute()) {
                    case BITS_32:
                        setExternalCodeSizeAttribute(context().addressSizeAttribute());
                        addEnumerableParameter(designation, ParameterPlace.SIB_INDEX, AMD64IndexRegister32.ENUMERATOR);
                        break;
                    case BITS_64:
                        addEnumerableParameter(designation, ParameterPlace.SIB_INDEX_REXX, AMD64IndexRegister64.ENUMERATOR);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            case NONE:
                // Our external assembler (gas) cannot generate these cases and they seem redundant anyway,
                // so for now we do not produce them:
                throw new TemplateNotNeededException();
        }
        addParameter(new X86EnumerableParameter<Scale>(designation, ParameterPlace.SIB_SCALE, Scale.ENUMERATOR));
    }

    @Override
    protected void organize_M(X86Operand.Designation designation) throws TemplateNotNeededException {
        switch (context().modCase()) {
            case MOD_0: {
                switch (context().rmCase()) {
                    case NORMAL:
                        switch (context().addressSizeAttribute()) {
                            case BITS_32:
                                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister32.ENUMERATOR);
                                break;
                            case BITS_64:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister64.ENUMERATOR);
                                break;
                            default:
                                ProgramError.unexpected();
                                break;
                        }
                        break;
                    case SWORD:
                        switch (context().addressSizeAttribute()) {
                            case BITS_16:
                                addParameter(new X86AddressParameter(designation, WordWidth.BITS_16));
                                break;
                            default:
                                throw new TemplateNotNeededException();
                        }
                        break;
                    case SDWORD:
                        switch (context().addressSizeAttribute()) {
                            case BITS_64:
                                useNamePrefix("rip_");
                                setLabelParameterIndex();
                                addParameter(new X86OffsetParameter(designation, WordWidth.BITS_32));
                                break;
                            case BITS_32:
                                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                                addParameter(new X86AddressParameter(designation, WordWidth.BITS_32));
                                break;
                            default:
                                throw new TemplateNotNeededException();
                        }
                        break;
                    case SIB:
                        addSib(designation);
                        break;
                }
                break;
            }
            case MOD_1: {
                addParameter(new X86DisplacementParameter(designation, WordWidth.BITS_8));
                switch (context().rmCase()) {
                    case NORMAL:
                        switch (context().addressSizeAttribute()) {
                            case BITS_32:
                                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister32.ENUMERATOR);
                                break;
                            case BITS_64:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister64.ENUMERATOR);
                                break;
                            default:
                                ProgramError.unexpected();
                                break;
                        }
                        break;
                    case SIB:
                        addSib(designation);
                        break;
                    default:
                        throw new TemplateNotNeededException();
                }
                break;
            }
            case MOD_2: {
                switch (context().addressSizeAttribute()) {
                    case BITS_16:
                        addParameter(new X86DisplacementParameter(designation, WordWidth.BITS_16));
                        break;
                    case BITS_32:
                    case BITS_64:
                        addParameter(new X86DisplacementParameter(designation, WordWidth.BITS_32));
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                switch (context().rmCase()) {
                    case NORMAL:
                        switch (context().addressSizeAttribute()) {
                            case BITS_32:
                                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister32.ENUMERATOR);
                                break;
                            case BITS_64:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64IndirectRegister64.ENUMERATOR);
                                break;
                            default:
                                ProgramError.unexpected();
                                break;
                        }
                        break;
                    case SIB:
                        addSib(designation);
                        break;
                    default:
                        throw new TemplateNotNeededException();
                }
                break;
            }
            case MOD_3: {
                throw new TemplateNotNeededException();
            }
        }
    }

    public void visitOperandCode(OperandCode operandCode, X86Operand.Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion)
        throws TemplateNotNeededException {
        switch (operandCode) {
            case Cq: {
                addParameter(new X86EnumerableParameter<ControlRegister>(designation, ParameterPlace.MOD_REG, ControlRegister.ENUMERATOR));
                break;
            }
            case Dq: {
                addParameter(new X86EnumerableParameter<DebugRegister>(designation, ParameterPlace.MOD_REG, DebugRegister.ENUMERATOR));
                break;
            }
            case Eb: {
                organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister8.ENUMERATOR, testArgumentExclusion);
                break;
            }
            case Ed: {
                organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister32.ENUMERATOR, testArgumentExclusion);
                break;
            }
            case Ed_q: {
                visitOperandTypeCode(operandCode.operandTypeCode());
                switch (context().operandSizeAttribute()) {
                    case BITS_32:
                        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister32.ENUMERATOR, testArgumentExclusion);
                        break;
                    case BITS_64:
                        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister64.ENUMERATOR, testArgumentExclusion);
                        break;
                    default:
                        throw new TemplateNotNeededException();
                }
                break;
            }
            case Ev: {
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister16.ENUMERATOR, testArgumentExclusion);
                        break;
                    case BITS_32:
                        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister32.ENUMERATOR, testArgumentExclusion);
                        break;
                    case BITS_64:
                        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister64.ENUMERATOR, testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Ew: {
                organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister16.ENUMERATOR, testArgumentExclusion);
                break;
            }
            case Fv: {
                break;
            }
            case Gb: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister8.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Gd: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister32.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Gd_q: {
                switch (context().operandSizeAttribute()) {
                    case BITS_32:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister32.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_64:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister64.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    default:
                        throw new TemplateNotNeededException();
                }
                break;
            }
            case Gq: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister64.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Gv: {
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister16.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_32:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister32.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_64:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister64.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Gw: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister16.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Gz: {
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister16.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_32:
                    case BITS_64:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64GeneralRegister32.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Ib: {
                addParameter(new X86ImmediateParameter(designation, WordWidth.BITS_8), argumentRange, testArgumentExclusion);
                break;
            }
            case ICb: {
                addEnumerableParameter(designation, ParameterPlace.APPEND, AMD64XMMComparison.ENUMERATOR);
                break;
            }
            case Iv: {
                addParameter(new X86ImmediateParameter(designation, context().operandSizeAttribute()), argumentRange, testArgumentExclusion);
                break;
            }
            case Iw: {
                addParameter(new X86ImmediateParameter(designation, WordWidth.BITS_16), argumentRange, testArgumentExclusion);
                break;
            }
            case Iz: {
                WordWidth operandSizeAttribute = context().operandSizeAttribute();
                if (operandSizeAttribute.greaterThan(WordWidth.BITS_32)) {
                    operandSizeAttribute = WordWidth.BITS_32;
                }
                addParameter(new X86ImmediateParameter(designation, operandSizeAttribute), argumentRange, testArgumentExclusion);
                break;
            }
            case Jb: {
                setLabelParameterIndex();
                addParameter(new X86OffsetParameter(designation, WordWidth.BITS_8));
                break;
            }
            case Jv: {
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        setLabelParameterIndex();
                        addParameter(new X86OffsetParameter(designation, WordWidth.BITS_16));
                        break;
                    case BITS_32:
                        setLabelParameterIndex();
                        addParameter(new X86OffsetParameter(designation, WordWidth.BITS_32));
                        break;
                    case BITS_64:
                        setLabelParameterIndex();
                        addParameter(new X86OffsetParameter(designation, WordWidth.BITS_64));
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Jz: {
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        setExternalCodeSizeAttribute(context().operandSizeAttribute());
                        setLabelParameterIndex();
                        addParameter(new X86OffsetParameter(designation, WordWidth.BITS_16));
                        break;
                    case BITS_32:
                    case BITS_64:
                        setLabelParameterIndex();
                        addParameter(new X86OffsetParameter(designation, WordWidth.BITS_32));
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Md_q: {
                if (operandSizeAttribute() == WordWidth.BITS_16) {
                    throw new TemplateNotNeededException();
                }
                organize_M(designation);
                break;
            }
            case Mb:
            case Md:
            case Mq:
            case Mdq:
            case Ms:
            case Mv:
            case Mw: {
                organize_M(designation);
                break;
            }
            case Nb: {
                addEnumerableParameter(designation, ParameterPlace.OPCODE1_REXB, AMD64GeneralRegister8.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Nd_q: {
                final ParameterPlace place = (opcode2() != null) ? ParameterPlace.OPCODE2_REXB : ParameterPlace.OPCODE1_REXB;
                switch (context().operandSizeAttribute()) {
                    case BITS_32:
                        addEnumerableParameter(designation, place, AMD64GeneralRegister32.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_64:
                        addEnumerableParameter(designation, place, AMD64GeneralRegister64.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    default:
                        throw new TemplateNotNeededException();
                }
                break;
            }
            case Nv:
                final ParameterPlace place = (opcode2() != null) ? ParameterPlace.OPCODE2_REXB : ParameterPlace.OPCODE1_REXB;
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        addEnumerableParameter(designation, place, AMD64GeneralRegister16.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_32:
                        addEnumerableParameter(designation, place, AMD64GeneralRegister32.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_64:
                        addEnumerableParameter(designation, place, AMD64GeneralRegister64.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            case Ob:
            case Ov: {
                switch (context().addressSizeAttribute()) {
                    case BITS_32:
                        setExternalCodeSizeAttribute(context().addressSizeAttribute());
                        addParameter(new X86AddressParameter(designation, WordWidth.BITS_32), argumentRange);
                        break;
                    case BITS_64:
                        setLabelParameterIndex();
                        addParameter(new X86AddressParameter(designation, WordWidth.BITS_64), argumentRange);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Pdq: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64XMMRegister.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Pq: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG, MMXRegister.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case PRq: {
                if (context().modCase() != X86TemplateContext.ModCase.MOD_3) {
                    throw new TemplateNotNeededException();
                }
                addEnumerableParameter(designation, ParameterPlace.MOD_RM, MMXRegister.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Qd:
            case Qq: {
                organize_E(designation, ParameterPlace.MOD_RM, MMXRegister.ENUMERATOR, testArgumentExclusion);
                break;
            }
            case Rq: {
                if (context().modCase() != X86TemplateContext.ModCase.MOD_3) {
                    throw new TemplateNotNeededException();
                }
                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister64.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Rv:
                if (context().modCase() != X86TemplateContext.ModCase.MOD_3) {
                    throw new TemplateNotNeededException();
                }
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister16.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_32:
                        addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister32.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    case BITS_64:
                        addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64GeneralRegister64.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            case Sw: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG, SegmentRegister.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Vpd:
            case Vps:
            case Vq:
            case Vdq:
            case Vsd:
            case Vss: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG_REXR, AMD64XMMRegister.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case VRq:
            case VRdq:
            case VRpd:
            case VRps: {
                if (context().modCase() != X86TemplateContext.ModCase.MOD_3) {
                    throw new TemplateNotNeededException();
                }
                addEnumerableParameter(designation, ParameterPlace.MOD_RM_REXB, AMD64XMMRegister.ENUMERATOR).excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Wdq:
            case Wpd:
            case Wps:
            case Wq:
            case Wsd:
            case Wss: {
                switch (context().operandSizeAttribute()) {
                    case BITS_32:
                    case BITS_64:
                        organize_E(designation, ParameterPlace.MOD_RM_REXB, AMD64XMMRegister.ENUMERATOR, testArgumentExclusion);
                        break;
                    default:
                        throw new TemplateNotNeededException();
                }
                break;
            }
            case Xz:
            case Yz: {
                switch (operandSizeAttribute()) {
                    case BITS_16:
                        setOperandTypeSuffix("w");
                        break;
                    case BITS_32:
                        setOperandTypeSuffix("l");
                        break;
                    default:
                        throw new TemplateNotNeededException();
                }
                break;
            }
            case Xb:
            case Xv:
            case Yb:
            case Yv: {
                visitOperandTypeCode(operandCode.operandTypeCode());
                break;
            }
            default:
                ProgramError.unexpected("undefined operand code: " + operandCode);
                break;
        }
    }

    public void visitRegisterOperandCode(RegisterOperandCode registerOperandCode, X86Operand.Designation designation, ImplicitOperand.ExternalPresence externalPresence) {
        switch (operandSizeAttribute()) {
            case BITS_16:
                addImplicitOperand(new X86ImplicitOperand(designation, externalPresence, AMD64GeneralRegister16.values()[registerOperandCode.id()]));
                break;
            case BITS_32:
                addImplicitOperand(new X86ImplicitOperand(designation, externalPresence, AMD64GeneralRegister32.values()[registerOperandCode.id()]));
                break;
            case BITS_64:
                addImplicitOperand(new X86ImplicitOperand(designation, externalPresence, AMD64GeneralRegister64.values()[registerOperandCode.id()]));
                break;
            default:
                ProgramError.unexpected();
                break;
        }
    }

    public boolean hasRexPrefix(Sequence<Argument> arguments) {
        if (instructionDescription().defaultOperandSize() == WordWidth.BITS_64) {
            return false;
        }
        if (operandSizeAttribute() == WordWidth.BITS_64) {
            return true;
        }
        for (Argument argument : arguments) {
            if (argument instanceof GeneralRegister) {
                if (argument instanceof AMD64GeneralRegister8) {
                    final AMD64GeneralRegister8 generalRegister8 = (AMD64GeneralRegister8) argument;
                    if (generalRegister8.requiresRexPrefix()) {
                        return true;
                    }
                } else {
                    final GeneralRegister generalRegister = (GeneralRegister) argument;
                    if (generalRegister.value() >= 8) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
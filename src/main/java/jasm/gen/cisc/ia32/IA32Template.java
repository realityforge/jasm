/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.ia32;

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
import jasm.ia32.IA32BaseRegister32;
import jasm.ia32.IA32GeneralRegister16;
import jasm.ia32.IA32GeneralRegister32;
import jasm.ia32.IA32GeneralRegister8;
import jasm.ia32.IA32IndexRegister32;
import jasm.ia32.IA32IndirectRegister16;
import jasm.ia32.IA32IndirectRegister32;
import jasm.WordWidth;
import jasm.util.program.ProgramError;
import jasm.x86.ControlRegister;
import jasm.x86.DebugRegister;
import jasm.x86.MMXRegister;
import jasm.x86.Scale;
import jasm.x86.SegmentRegister;

/**
 * @author Bernd Mathiske
 */
public final class IA32Template extends X86Template {

    IA32Template(X86InstructionDescription instructionDescription, int serial, InstructionAssessment instructionFamily, X86TemplateContext context) {
        super(instructionDescription, serial, instructionFamily, context);
    }

    private void addSib(X86Operand.Designation designation) throws TemplateNotNeededException {
        assert context().addressSizeAttribute() != WordWidth.BITS_16;
        haveSibByte();
        switch (context().sibBaseCase()) {
            case GENERAL_REGISTER: {
                switch (context().modCase()) {
                    case MOD_0: {
                        addEnumerableParameter(designation, ParameterPlace.SIB_BASE, IA32BaseRegister32.ENUMERATOR);
                        break;
                    }
                    case MOD_1:
                    case MOD_2: {
                        addEnumerableParameter(designation, ParameterPlace.SIB_BASE, IA32BaseRegister32.ENUMERATOR);
                        break;
                    }
                    case MOD_3: {
                        ProgramError.unexpected("no SIB for mod == 3");
                        break;
                    }
                }
                break;
            }
            case SPECIAL: {
                switch (context().modCase()) {
                    case MOD_0: {
                        setLabelParameterIndex();
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
                addEnumerableParameter(designation, ParameterPlace.SIB_INDEX, IA32IndexRegister32.ENUMERATOR);
                break;
            case NONE:
                // Our external assembler (gas) cannot generate these case and they seem redundant anyway,
                // so for now we do not produce them:
                throw new TemplateNotNeededException();
        }
        addParameter(new X86EnumerableParameter<Scale>(designation, ParameterPlace.SIB_SCALE, Scale.ENUMERATOR));
    }

    @Override
    protected final void organize_M(X86Operand.Designation designation) throws TemplateNotNeededException {
        switch (context().modCase()) {
            case MOD_0: {
                switch (context().rmCase()) {
                    case NORMAL:
                        switch (context().addressSizeAttribute()) {
                            case BITS_16:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32IndirectRegister16.ENUMERATOR);
                                break;
                            case BITS_32:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32IndirectRegister32.ENUMERATOR);
                                break;
                            default:
                                ProgramError.unexpected();
                                break;
                        }
                        break;
                    case SWORD:
                        switch (context().addressSizeAttribute()) {
                            case BITS_16:
                                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                                addParameter(new X86AddressParameter(designation, WordWidth.BITS_16));
                                break;
                            default:
                                throw new TemplateNotNeededException();
                        }
                        break;
                    case SDWORD:
                        switch (context().addressSizeAttribute()) {
                            case BITS_32:
                                setLabelParameterIndex();
                                addParameter(new X86AddressParameter(designation, WordWidth.BITS_32));
                                break;
                            default:
                                throw new TemplateNotNeededException();
                        }
                        break;
                    case SIB:
                        switch (context().addressSizeAttribute()) {
                            case BITS_32:
                                addSib(designation);
                                break;
                            default:
                                throw new TemplateNotNeededException();
                        }
                        break;
                }
                break;
            }
            case MOD_1: {
                addParameter(new X86DisplacementParameter(designation, WordWidth.BITS_8));
                switch (context().rmCase()) {
                    case NORMAL:
                        switch (context().addressSizeAttribute()) {
                            case BITS_16:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32IndirectRegister16.ENUMERATOR);
                                break;
                            case BITS_32:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32IndirectRegister32.ENUMERATOR);
                                break;
                            default:
                                ProgramError.unexpected();
                                break;
                        }
                        break;
                    case SIB:
                        switch (context().addressSizeAttribute()) {
                            case BITS_32:
                                addSib(designation);
                                break;
                            default:
                                throw new TemplateNotNeededException();
                        }
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
                        addParameter(new X86DisplacementParameter(designation, WordWidth.BITS_32));
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                switch (context().rmCase()) {
                    case NORMAL:
                        switch (context().addressSizeAttribute()) {
                            case BITS_16:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32IndirectRegister16.ENUMERATOR);
                                break;
                            case BITS_32:
                                addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32IndirectRegister32.ENUMERATOR);
                                break;
                            default:
                                ProgramError.unexpected();
                                break;
                        }
                        break;
                    case SIB:
                        switch (context().addressSizeAttribute()) {
                            case BITS_16:
                                throw new TemplateNotNeededException();
                            case BITS_32:
                                addSib(designation);
                                break;
                            default:
                                ProgramError.unexpected();
                                break;
                        }
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

    public final void visitOperandCode(OperandCode operandCode, X86Operand.Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion)
        throws TemplateNotNeededException {
        switch (operandCode) {
            case Ap:
                instructionDescription().beNotExternallyTestable(); // gas does not support cross-segment instructions
                switch (context().addressSizeAttribute()) {
                    case BITS_16:
                        setExternalCodeSizeAttribute(context().addressSizeAttribute());
                        addParameter(new X86AddressParameter(designation, WordWidth.BITS_16));
                        break;
                    case BITS_32:
                        setLabelParameterIndex();
                        addParameter(new X86AddressParameter(designation, WordWidth.BITS_32));
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            case Cd: {
                addParameter(new X86EnumerableParameter<ControlRegister>(designation, ParameterPlace.MOD_REG, ControlRegister.ENUMERATOR));
                break;
            }
            case Dd: {
                addParameter(new X86EnumerableParameter<DebugRegister>(designation, ParameterPlace.MOD_REG, DebugRegister.ENUMERATOR));
                break;
            }
            case Eb: {
                organize_E(designation, ParameterPlace.MOD_RM, IA32GeneralRegister8.ENUMERATOR, testArgumentExclusion);
                break;
            }
            case Ed: {
                organize_E(designation, ParameterPlace.MOD_RM, IA32GeneralRegister32.ENUMERATOR, testArgumentExclusion);
                break;
            }
            case Ev: {
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        organize_E(designation, ParameterPlace.MOD_RM, IA32GeneralRegister16.ENUMERATOR, testArgumentExclusion);
                        break;
                    case BITS_32:
                        organize_E(designation, ParameterPlace.MOD_RM, IA32GeneralRegister32.ENUMERATOR, testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Ew: {
                organize_E(designation, ParameterPlace.MOD_RM, IA32GeneralRegister16.ENUMERATOR, testArgumentExclusion);
                break;
            }
            case Fv: {
                break;
            }
            case Gb: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG, IA32GeneralRegister8.ENUMERATOR).excludeTestArguments(
                                testArgumentExclusion);
                break;
            }
            case Gv: {
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG, IA32GeneralRegister16.ENUMERATOR).excludeTestArguments(
                                        testArgumentExclusion);
                        break;
                    case BITS_32:
                        addEnumerableParameter(designation, ParameterPlace.MOD_REG, IA32GeneralRegister32.ENUMERATOR).excludeTestArguments(
                                        testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Gw: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG, IA32GeneralRegister16.ENUMERATOR).excludeTestArguments(
                                testArgumentExclusion);
                break;
            }
            case Ib: {
                final X86ImmediateParameter parameter = new X86ImmediateParameter(designation, WordWidth.BITS_8);
                addParameter(parameter);
                parameter.setArgumentRange(argumentRange);
                parameter.excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Iv: {
                setExternalOperandTypeSuffix(operandCode.operandTypeCode());
                final X86ImmediateParameter parameter = new X86ImmediateParameter(designation, context().operandSizeAttribute());
                addParameter(parameter);
                parameter.setArgumentRange(argumentRange);
                parameter.excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Iw: {
                setExternalCodeSizeAttribute(context().operandSizeAttribute());
                final X86ImmediateParameter parameter = new X86ImmediateParameter(designation, WordWidth.BITS_16);
                addParameter(parameter);
                parameter.setArgumentRange(argumentRange);
                parameter.excludeTestArguments(testArgumentExclusion);
                break;
            }
            case Jb: {
                setExternalCodeSizeAttribute(context().addressSizeAttribute());
                setLabelParameterIndex();
                addParameter(new X86OffsetParameter(designation, WordWidth.BITS_8));
                break;
            }
            case Jv: {
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        setExternalCodeSizeAttribute(context().operandSizeAttribute());
                        setLabelParameterIndex();
                        addParameter(new X86OffsetParameter(designation, WordWidth.BITS_16));
                        break;
                    case BITS_32:
                        setLabelParameterIndex();
                        addParameter(new X86OffsetParameter(designation, WordWidth.BITS_32));
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Ma:
            case Mp:
            case Mq:
            case Ms:
            case Mv:
            case Mw: {
                organize_M(designation);
                break;
            }
            case Nb: {
                addEnumerableParameter(designation, ParameterPlace.OPCODE1, IA32GeneralRegister8.ENUMERATOR).excludeTestArguments(
                                testArgumentExclusion);
                break;
            }
            case Nd:
                addEnumerableParameter(designation, ParameterPlace.OPCODE2, IA32GeneralRegister32.ENUMERATOR).excludeTestArguments(
                                testArgumentExclusion);
                break;
            case Nv:
                final ParameterPlace place = (opcode2() != null) ? ParameterPlace.OPCODE2 : ParameterPlace.OPCODE1;
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        addEnumerableParameter(designation, place, IA32GeneralRegister16.ENUMERATOR).excludeTestArguments(
                                               testArgumentExclusion);
                        break;
                    case BITS_32:
                        addEnumerableParameter(designation, place, IA32GeneralRegister32.ENUMERATOR).excludeTestArguments(
                                               testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            case Ob:
            case Ov: {
                switch (context().addressSizeAttribute()) {
                    case BITS_16:
                        setExternalCodeSizeAttribute(context().addressSizeAttribute());
                        addParameter(new X86AddressParameter(designation, WordWidth.BITS_16));
                        break;
                    case BITS_32:
                        setLabelParameterIndex();
                        addParameter(new X86AddressParameter(designation, WordWidth.BITS_32));
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            }
            case Pd:
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
            case Rd: {
                if (context().modCase() != X86TemplateContext.ModCase.MOD_3) {
                    throw new TemplateNotNeededException();
                }
                addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32GeneralRegister32.ENUMERATOR).excludeTestArguments(
                                testArgumentExclusion);
                break;
            }
            case Rv:
                if (context().modCase() != X86TemplateContext.ModCase.MOD_3) {
                    throw new TemplateNotNeededException();
                }
                switch (context().operandSizeAttribute()) {
                    case BITS_16:
                        addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32GeneralRegister16.ENUMERATOR).excludeTestArguments(
                                               testArgumentExclusion);
                        break;
                    case BITS_32:
                        addEnumerableParameter(designation, ParameterPlace.MOD_RM, IA32GeneralRegister32.ENUMERATOR).excludeTestArguments(
                                               testArgumentExclusion);
                        break;
                    default:
                        ProgramError.unexpected();
                        break;
                }
                break;
            case Sw: {
                addEnumerableParameter(designation, ParameterPlace.MOD_REG, SegmentRegister.ENUMERATOR).excludeTestArguments(
                                testArgumentExclusion);
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

    public final void visitRegisterOperandCode(RegisterOperandCode registerOperandCode, X86Operand.Designation designation, ImplicitOperand.ExternalPresence externalPresence) {
        switch (operandSizeAttribute()) {
            case BITS_16:
                addImplicitOperand(new X86ImplicitOperand(designation, externalPresence, IA32GeneralRegister16.values()[registerOperandCode.id()]));
                break;
            case BITS_32:
                addImplicitOperand(new X86ImplicitOperand(designation, externalPresence, IA32GeneralRegister32.values()[registerOperandCode.id()]));
                break;
            default:
                ProgramError.unexpected();
                break;
        }
    }

}

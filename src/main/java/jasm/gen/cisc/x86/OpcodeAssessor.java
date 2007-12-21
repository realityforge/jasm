/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.gen.ArgumentRange;
import jasm.gen.ImplicitOperand;
import jasm.gen.TestArgumentExclusion;
import jasm.gen.cisc.TemplateNotNeededException;

/**
 * Used when pre-scanning instruction descriptions to assess variants within the respective instruction family.
 *
 * @see InstructionAssessment
 *
 * @author Bernd Mathiske
 */
public class OpcodeAssessor extends X86InstructionDescriptionAdapter {

    private final InstructionAssessment _instructionFamily;

    public OpcodeAssessor(InstructionAssessment instructionFamily) {
        super();
        _instructionFamily = instructionFamily;
    }

    @Override
    public void visitOperandCode(OperandCode operandCode, X86Operand.Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion) {
        switch (operandCode.operandTypeCode()) {
            case a:
            case d_q:
            case p:
            case s:
            case v:
            case z:
                _instructionFamily.haveOperandSizeVariants();
                break;
            default:
                break;
        }
        switch (operandCode.addressingMethodCode()) {
            case A:
            case E:
            case M:
            case O:
            case Q:
            case W:
                _instructionFamily.haveAddressSizeVariants();
                break;
            default:
                break;
        }
        switch (operandCode.addressingMethodCode()) {
            case C:
            case D:
            case E:
            case G:
            case M:
            case P:
            case PR:
            case Q:
            case R:
            case S:
            case V:
            case VR:
            case T:
            case W:
                _instructionFamily.haveModRMByte();
                break;
            default:
                break;
        }
    }

    @Override
    public void visitRegisterOperandCode(RegisterOperandCode registerOperandCode, X86Operand.Designation position, ImplicitOperand.ExternalPresence externalPresence) {
        _instructionFamily.haveOperandSizeVariants();
    }

    @Override
    public void visitModRMGroup(ModRMGroup modRMGroup) {
        _instructionFamily.setModRMGroup(modRMGroup);
    }

    @Override
    public void visitModCase(X86TemplateContext.ModCase modCase) throws TemplateNotNeededException {
        _instructionFamily.haveModRMByte();
    }

    @Override
    public void visitString(String s) {
        if (s.startsWith("J") || s.startsWith("j")) {
            _instructionFamily.beJump();
        }
    }
}

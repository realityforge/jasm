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
import jasm.gen.InstructionConstraint;
import jasm.gen.TestArgumentExclusion;
import jasm.gen.cisc.TemplateNotNeededException;
import jasm.util.HexByte;
import jasm.x86.FPStackRegister;
import jasm.x86.GeneralRegister;
import jasm.x86.SegmentRegister;

/**
 * Empty default implementations for X86InstructionDescriptionVisitor.
 *
 * @author Bernd Mathiske
 */
public class X86InstructionDescriptionAdapter implements X86InstructionDescriptionVisitor {

    public void visitOperandCode(OperandCode operandCode, X86Operand.Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion) throws TemplateNotNeededException {
    }

    public void visitAddressingMethodCode(AddressingMethodCode addressingMethodCode, X86Operand.Designation designation) {
    }

    public void visitOperandTypeCode(OperandTypeCode operandTypeCode) {
    }

    public void visitRegisterOperandCode(RegisterOperandCode registerOperandCode, X86Operand.Designation designation, ImplicitOperand.ExternalPresence externalPresence) {
    }

    public void visitGeneralRegister(GeneralRegister generalRegister, X86Operand.Designation designation, ImplicitOperand.ExternalPresence externalPresence) {
    }

    public void visitSegmentRegister(SegmentRegister segmentRegister, X86Operand.Designation designation) {
    }

    public void visitModRMGroup(ModRMGroup modRMGroup) {
    }

    public void visitModCase(X86TemplateContext.ModCase modCase) throws TemplateNotNeededException {
    }

    public void visitFloatingPointOperandCode(FloatingPointOperandCode floatingPointOperandCode, X86Operand.Designation designation, TestArgumentExclusion testArgumentExclusion) {
    }

    public void visitFPStackRegister(FPStackRegister fpStackRegister, X86Operand.Designation designation) {
    }

    public void visitString(String string) {
    }

    public void visitInteger(Integer integer, X86Operand.Designation designation) {
    }

    public void visitHexByte(HexByte hexByte) {
    }

    public void visitInstructionConstraint(InstructionConstraint constraint) {
    }
}

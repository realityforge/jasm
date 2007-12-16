/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=de793a74-8609-45fa-8a51-4269793855ef*/
package jasm.gen.cisc.x86;

import jasm.gen.ArgumentRange;
import jasm.gen.ImplicitOperand;
import jasm.gen.InstructionConstraint;
import jasm.gen.TestArgumentExclusion;
import jasm.gen.cisc.TemplateNotNeededException;
import jasm.x86.FPStackRegister;
import jasm.x86.GeneralRegister;
import jasm.x86.SegmentRegister;
import jasm.util.HexByte;

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

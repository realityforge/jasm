/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=de793a74-8609-45fa-8a51-4269793855ef*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.*;
import com.sun.max.asm.x86.*;
import com.sun.max.util.*;

/**
 * Empty default implementations for X86InstructionDescriptionVisitor.
 *
 * @author Bernd Mathiske
 */
public class X86InstructionDescriptionAdapter implements X86InstructionDescriptionVisitor {

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitOperandCode(OperandCode operandCode, X86Operand.Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion) throws TemplateNotNeededException {
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitAddressingMethodCode(AddressingMethodCode addressingMethodCode, X86Operand.Designation designation) {        
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitOperandTypeCode(OperandTypeCode operandTypeCode) {        
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitRegisterOperandCode(RegisterOperandCode registerOperandCode, X86Operand.Designation designation, ImplicitOperand.ExternalPresence externalPresence) {
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitGeneralRegister(GeneralRegister generalRegister, X86Operand.Designation designation, ImplicitOperand.ExternalPresence externalPresence) {
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitSegmentRegister(SegmentRegister segmentRegister, X86Operand.Designation designation) {
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitModRMGroup(ModRMGroup modRMGroup) {
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitModCase(X86TemplateContext.ModCase modCase) throws TemplateNotNeededException {        
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitFloatingPointOperandCode(FloatingPointOperandCode floatingPointOperandCode, X86Operand.Designation designation, TestArgumentExclusion testArgumentExclusion) {     
    }
    
    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitFPStackRegister(FPStackRegister fpStackRegister, X86Operand.Designation designation) {        
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitString(String string) {
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitInteger(Integer integer, X86Operand.Designation designation) {
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitHexByte(HexByte hexByte) {
    }

    @Implement(X86InstructionDescriptionVisitor.class)
    public void visitInstructionConstraint(InstructionConstraint constraint) {
    }
}

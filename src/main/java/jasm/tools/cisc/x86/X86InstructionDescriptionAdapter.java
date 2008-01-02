/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.tools.ArgumentRange;
import jasm.tools.ExternalPresence;
import jasm.tools.InstructionConstraint;
import jasm.tools.TestArgumentExclusion;
import jasm.tools.cisc.TemplateNotNeededException;
import jasm.util.HexByte;
import jasm.x86.FPStackRegister;
import jasm.x86.GeneralRegister;
import jasm.x86.SegmentRegister;

/** Empty default implementations for X86InstructionDescriptionVisitor. */
public class X86InstructionDescriptionAdapter
    implements X86InstructionDescriptionVisitor {

  public void visitOperandCode(OperandCode operandCode, Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion) throws TemplateNotNeededException {
  }

  public final void visitAddressingMethodCode(AddressingMethodCode addressingMethodCode, Designation designation) {
  }

  public final void visitOperandTypeCode(OperandTypeCode operandTypeCode) {
  }

  public void visitRegisterOperandCode(X86RegisterOperandCode registerOperandCode, Designation designation, ExternalPresence externalPresence) {
  }

  public final void visitGeneralRegister(GeneralRegister generalRegister, Designation designation, ExternalPresence externalPresence) {
  }

  public final void visitSegmentRegister(SegmentRegister segmentRegister, Designation designation) {
  }

  public void visitModRMGroup(ModRMGroup modRMGroup) {
  }

  public void visitModCase(ModCase modCase) throws TemplateNotNeededException {
  }

  public final void visitFloatingPointOperandCode(FloatingPointOperandCode floatingPointOperandCode, Designation designation, TestArgumentExclusion testArgumentExclusion) {
  }

  public final void visitFPStackRegister(FPStackRegister fpStackRegister, Designation designation) {
  }

  public final void visitInteger(Integer integer, Designation designation) {
  }
}

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
import jasm.tools.TestArgumentExclusion;
import jasm.tools.cisc.TemplateNotNeededException;

/**
 * Used when pre-scanning instruction descriptions to assess variants within the respective instruction family.
 *
 * @see InstructionAssessment
 */
public final class OpcodeAssessor extends X86InstructionDescriptionAdapter {

  private final InstructionAssessment _instructionFamily;

  public OpcodeAssessor(InstructionAssessment instructionFamily) {
    super();
    _instructionFamily = instructionFamily;
  }

  @Override
  public final void visitOperandCode(OperandCode operandCode, Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion) {
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
      case U:
      case W:
        _instructionFamily.haveModRMByte();
        break;
      default:
        break;
    }
  }

  @Override
  public final void visitRegisterOperandCode(X86RegisterOperandCode registerOperandCode, Designation position, ExternalPresence externalPresence) {
    _instructionFamily.haveOperandSizeVariants();
  }

  @Override
  public final void visitModRMGroup(ModRMGroup modRMGroup) {
    _instructionFamily.setModRMGroup(modRMGroup);
  }

  @Override
  public final void visitModCase(ModCase modCase) throws TemplateNotNeededException {
    _instructionFamily.haveModRMByte();
  }

  @Override
  public final void visitString(String s) {
    if (s.startsWith("J") || s.startsWith("j")) {
      _instructionFamily.beJump();
    }
  }
}

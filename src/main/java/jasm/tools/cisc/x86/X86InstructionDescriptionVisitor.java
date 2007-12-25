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
import jasm.tools.ExternalOmission;
import jasm.tools.ExternalPresence;
import jasm.tools.InstructionConstraint;
import jasm.tools.InstructionDescription;
import jasm.tools.TestArgumentExclusion;
import jasm.tools.cisc.TemplateNotNeededException;
import jasm.util.HexByte;
import jasm.x86.FPStackRegister;
import jasm.x86.GeneralRegister;
import jasm.x86.SegmentRegister;

/**
 * Almost like the visitor pattern.
 * Specialized dispatch over InstructionDescription objects.
 */
public interface X86InstructionDescriptionVisitor {

  void visitOperandCode(OperandCode operandCode, Designation designation, ArgumentRange argumentRange, TestArgumentExclusion testArgumentExclusion) throws TemplateNotNeededException;

  void visitAddressingMethodCode(AddressingMethodCode addressingMethodCode, Designation designation) throws TemplateNotNeededException;

  void visitOperandTypeCode(OperandTypeCode operandTypeCode) throws TemplateNotNeededException;

  void visitRegisterOperandCode(RegisterOperandCode registerOperandCode, Designation designation, ExternalPresence externalPresence);

  void visitGeneralRegister(GeneralRegister generalRegister, Designation designation, ExternalPresence externalPresence);

  void visitSegmentRegister(SegmentRegister segmentRegister, Designation designation);

  void visitModRMGroup(ModRMGroup modRMGroup) throws TemplateNotNeededException;

  void visitModCase(ModCase modCase) throws TemplateNotNeededException;

  void visitFloatingPointOperandCode(FloatingPointOperandCode floatingPointOperandCode, Designation designation, TestArgumentExclusion testArgumentExclusion) throws TemplateNotNeededException;

  void visitFPStackRegister(FPStackRegister fpStackRegister, Designation designation);

  void visitString(String string);

  void visitInteger(Integer integer, Designation designation);

  void visitHexByte(HexByte hexByte) throws TemplateNotNeededException;

  void visitInstructionConstraint(InstructionConstraint constraint);

  public static final class Static {
    /**
     * @return whether the specification constitutes an operand
     * @throws TemplateNotNeededException
     */
    private static boolean visitSpecification(X86InstructionDescriptionVisitor visitor, Object specification,
                                              final Designation designation, ArgumentRange argumentRange,
                                              final TestArgumentExclusion testArgumentExclusion, ExternalPresence externalPresence) throws TemplateNotNeededException {
      if (specification instanceof OperandCode) {
        visitor.visitOperandCode((OperandCode) specification, designation, argumentRange, testArgumentExclusion);
        return true;
      } else if (specification instanceof AddressingMethodCode) {
        visitor.visitAddressingMethodCode((AddressingMethodCode) specification, designation);
        return true;
      } else if (specification instanceof OperandTypeCode) {
        visitor.visitOperandTypeCode((OperandTypeCode) specification);
        return false;
      } else if (specification instanceof RegisterOperandCode) {
        visitor.visitRegisterOperandCode((RegisterOperandCode) specification, designation, externalPresence);
        return true;
      } else if (specification instanceof GeneralRegister) {
        visitor.visitGeneralRegister((GeneralRegister) specification, designation, externalPresence);
        return true;
      } else if (specification instanceof SegmentRegister) {
        visitor.visitSegmentRegister((SegmentRegister) specification, designation);
        return true;
      } else if (specification instanceof ModRMGroup) {
        visitor.visitModRMGroup((ModRMGroup) specification);
        return false;
      } else if (specification instanceof ModCase) {
        visitor.visitModCase((ModCase) specification);
        return false;
      } else if (specification instanceof FloatingPointOperandCode) {
        visitor.visitFloatingPointOperandCode((FloatingPointOperandCode) specification, designation, testArgumentExclusion);
        return true;
      } else if (specification instanceof FPStackRegister) {
        visitor.visitFPStackRegister((FPStackRegister) specification, designation);
        return true;
      } else if (specification instanceof String) {
        visitor.visitString((String) specification);
        return false;
      } else if (specification instanceof Integer) {
        visitor.visitInteger((Integer) specification, designation);
        return true;
      } else if (specification instanceof ArgumentRange) {
        final ArgumentRange newArgumentRange = (ArgumentRange) specification;
        return visitSpecification(visitor, newArgumentRange.wrappedSpecification(), designation, newArgumentRange, testArgumentExclusion, externalPresence);
      } else if (specification instanceof HexByte) {
        visitor.visitHexByte((HexByte) specification);
        return false;
      } else if (specification instanceof TestArgumentExclusion) {
        final TestArgumentExclusion exclusion = (TestArgumentExclusion) specification;
        return visitSpecification(visitor, exclusion.wrappedSpecification(), designation, argumentRange, exclusion, externalPresence);
      } else if (specification instanceof ExternalOmission) {
        final ExternalOmission omission = (ExternalOmission) specification;
        return visitSpecification(visitor, omission.wrappedSpecification(), designation, argumentRange, testArgumentExclusion, ExternalPresence.OMITTED);
      } else {
        throw new IllegalStateException("unknown instruction description specification: " + specification);
      }
    }

    /**
     * @return whether this instruction description is to be used to create a template in the given context
     */
    public static boolean visitInstructionDescription(X86InstructionDescriptionVisitor visitor, InstructionDescription instructionDescription) {
      try {
        int designationIndex = 0;
        for (Object specification : instructionDescription) {
          final Designation designation = Designation.values()[designationIndex];
          if (visitSpecification(visitor, specification, designation, ArgumentRange.UNSPECIFIED, TestArgumentExclusion.NONE, ExternalPresence.EXPLICIT)) {
            designationIndex++;
          }
        }
        return true;
      } catch (TemplateNotNeededException templateNotNeededException) {
        return false;
      }
    }
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc;

import jasm.tools.InstructionConstraint;
import jasm.tools.InstructionDescription;
import jasm.tools.risc.field.RiscField;
import java.util.List;

public interface RiscInstructionDescriptionVisitor {

  void visitField(RiscField field);

  void visitConstant(RiscConstant constant);

  void visitString(String string);

  void visitConstraint(InstructionConstraint constraint);

  public static final class Static {
    private Static() {
    }

    private static void visitSpecification(RiscInstructionDescriptionVisitor visitor, Object specification) {
      if (specification instanceof RiscField) {
        visitor.visitField((RiscField) specification);
      } else if (specification instanceof RiscConstant) {
        visitor.visitConstant((RiscConstant) specification);
      } else if (specification instanceof String) {
        visitor.visitString((String) specification);
      } else if (specification instanceof InstructionConstraint) {
        visitor.visitConstraint((InstructionConstraint) specification);
      } else {
        throw new IllegalStateException("unknown instructionDescription specification: " + specification);
      }
    }

    private static void visitSpecifications(RiscInstructionDescriptionVisitor visitor, List<Object> specifications) {
      for (Object specification : specifications) {
        visitSpecification(visitor, specification);
      }
    }

    public static void visitInstructionDescription(RiscInstructionDescriptionVisitor visitor, InstructionDescription instructionDescription) {
      visitSpecifications(visitor, instructionDescription.specifications());
    }
  }

}

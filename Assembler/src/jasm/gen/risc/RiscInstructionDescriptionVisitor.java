/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.risc;

import com.sun.max.collect.Sequence;
import com.sun.max.program.ProgramError;
import jasm.gen.InstructionConstraint;
import jasm.gen.InstructionDescription;
import jasm.gen.risc.field.RiscField;

/**
 *
 *
 * @author Bernd Mathiske
 */
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
                ProgramError.unexpected("unknown instructionDescription specification: " + specification);
            }
        }

        private static void visitSpecifications(RiscInstructionDescriptionVisitor visitor, Sequence<Object> specifications) {
            for (Object specification : specifications) {
                visitSpecification(visitor, specification);
            }
        }

        public static void visitInstructionDescription(RiscInstructionDescriptionVisitor visitor, InstructionDescription instructionDescription) {
            visitSpecifications(visitor, instructionDescription.specifications());
        }
    }

}

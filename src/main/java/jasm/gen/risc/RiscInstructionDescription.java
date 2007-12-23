/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc;

import jasm.gen.InstructionDescription;
import jasm.gen.risc.field.InputOperandField;
import jasm.gen.risc.field.RiscField;
import jasm.util.ProgramError;
import java.util.List;

public final class RiscInstructionDescription extends InstructionDescription {

    RiscInstructionDescription(List<Object> specifications) {
        super(specifications);

        int bits = 0;
        int mask = 0;
        for (Object specification : specifications) {
            final RiscField field;
            if (specification instanceof RiscField) {
                field = (RiscField) specification;
                if (field instanceof InputOperandField) {
                    // Cannot recover the value of these fields from an assembled instruction
                    // with support for a simultaneous equation solver
                    beNotDisassemblable();
                }
            } else if (specification instanceof RiscConstant) {
                field = ((RiscConstant) specification).field();
            } else {
                continue;
            }
            bits += field.bitRange().encodedWidth();
            final int fieldMask = field.bitRange().instructionMask();
            if ((fieldMask & mask) != 0) {
                ProgramError.unexpected("RISC instruction field defines bits also defined by another field: " + field.name() + "[" + field.bitRange() + "]");
            }
            mask |= fieldMask;
        }

        if (bits != 32) {
            ProgramError.unexpected("RISC instruction description describes " + bits + " instruction field bits: " + specifications);
        }
    }

    private boolean _synthetic;

    public InstructionDescription beSynthetic() {
        _synthetic = true;
        return this;
    }

    @Override
    public boolean isSynthetic() {
        return _synthetic;
    }

}

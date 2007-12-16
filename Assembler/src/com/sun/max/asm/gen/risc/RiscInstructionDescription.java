/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ebbd66fb-3dfb-474b-88e0-f020954a5147*/
package com.sun.max.asm.gen.risc;

import com.sun.max.asm.gen.InstructionDescription;
import com.sun.max.asm.gen.risc.field.InputOperandField;
import com.sun.max.asm.gen.risc.field.RiscField;
import com.sun.max.collect.MutableSequence;
import com.sun.max.program.ProgramError;

/**
 *
 *
 * @author Bernd Mathiske
 */
public final class RiscInstructionDescription extends InstructionDescription {

    RiscInstructionDescription(MutableSequence<Object> specifications) {
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

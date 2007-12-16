/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=cd183128-2a91-4e3c-a930-7afdd95bd486*/
/**
 *
 */
package com.sun.max.asm.gen.risc;

import com.sun.max.annotate.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.bitRange.*;
import com.sun.max.asm.gen.risc.field.*;
import com.sun.max.lang.*;

/**
 * Disassembles an assembled RISC instruction to show the value of each field in the instruction as
 * well as the bits occupied by the field.
 *
 * @author Doug Simon
 */
class RiscFieldDisassembler<Template_Type extends Template> implements RiscInstructionDescriptionVisitor {

    private final Template_Type _template;
    private final int _assembledInstruction;
    private String _string;

    public RiscFieldDisassembler(Template_Type template, byte[] assembledInstruction) {
        assert assembledInstruction.length == 4;
        _template = template;
        _assembledInstruction = assembledInstruction[0] << 24 | ((assembledInstruction[1] & 0xFF) << 16) | ((assembledInstruction[2] & 0xFF) << 8) | (assembledInstruction[3] & 0xFF);
    }

    @Override
    public String toString() {
        if (_string == null) {
            _string = "";
            RiscInstructionDescriptionVisitor.Static.visitInstructionDescription(this, _template.instructionDescription());
        }
        return _string;
    }

    public void visitConstant(RiscConstant constant) {
        visitField(constant.field());
    }

    public void visitConstraint(InstructionConstraint constraint) {
    }

    public void visitField(RiscField field) {
        if (_string.length() != 0) {
            _string += ' ';
        }
        final int value;
        final BitRange bitRange = field.bitRange();
        final int width = bitRange.width();

        if (field instanceof OperandField) {
            value = ((OperandField) field).extract(_assembledInstruction);
        } else {
            value = bitRange.extractUnsignedInt(_assembledInstruction);
        }
        String binary = Integer.toBinaryString(value);
        if (binary.length() > width) {
            binary = binary.substring(binary.length() - width);
        } else if (binary.length() < width) {
            binary = Strings.times('0', width - binary.length()) + binary;
        }

        _string += field.name() + "[" + bitRange + "]=" + value + "{" + binary + "}";
    }

    public void visitString(String string) {
    }


}

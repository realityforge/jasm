/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc;

import jasm.gen.InstructionConstraint;
import jasm.gen.Template;
import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.field.OperandField;
import jasm.gen.risc.field.RiscField;
import jasm.util.lang.Strings;

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

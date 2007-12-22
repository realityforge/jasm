/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.ppc;

import jasm.Argument;
import jasm.dis.DisassembledLabel;
import jasm.dis.GlobalLabelMapper;
import jasm.gen.risc.RiscExternalInstruction;
import jasm.util.collect.Sequence;

/**
 * Output of PowerPC instructions in external assembler format.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class PPCExternalInstruction extends RiscExternalInstruction {

    PPCExternalInstruction(PPCTemplate template, Sequence<Argument> arguments) {
        super(template, arguments);
    }

    public PPCExternalInstruction(PPCTemplate template, Sequence<Argument> arguments, int offset, Sequence<DisassembledLabel> labels) {
        super(template, arguments, offset, labels);
    }

    public PPCExternalInstruction(PPCTemplate template, Sequence<Argument> arguments, int offset, Sequence<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        super(template, arguments, offset, labels, globalLabelMapper);
    }

    @Override
    public boolean isAbsoluteBranch() {
        // An absolute branch instruction in PowerPC has an AA field with its bit set
        return Sequence.Static.containsEqual(_template.optionFields(), PPCFields._aa) && (_template.opcode() & PPCFields._aa.bitRange().instructionMask()) != 0;
    }
}

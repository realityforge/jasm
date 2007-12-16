/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=3b559590-3fa8-4f6d-928a-6d0aae092737*/
package jasm.gen.risc.ppc;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.dis.DisassembledLabel;
import jasm.dis.GlobalLabelMapper;
import jasm.gen.risc.RiscExternalInstruction;

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
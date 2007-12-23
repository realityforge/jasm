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
import java.util.List;

/**
 * Output of PowerPC instructions in external assembler format.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class PPCExternalInstruction extends RiscExternalInstruction {

    PPCExternalInstruction(PPCTemplate template, List<Argument> arguments) {
        super(template, arguments);
    }

  public PPCExternalInstruction(PPCTemplate template, List<Argument> arguments, int offset, List<DisassembledLabel> labels, GlobalLabelMapper globalLabelMapper) {
        super(template, arguments, offset, labels, globalLabelMapper);
    }

    @Override
    public final boolean isAbsoluteBranch() {
        // An absolute branch instruction in PowerPC has an AA field with its bit set
      return _template.optionFields().contains(PPCFields.aa) && (_template.opcode() & PPCFields.aa.bitRange().instructionMask()) != 0;
    }
}

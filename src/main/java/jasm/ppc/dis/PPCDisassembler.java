/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc.dis;

import jasm.WordWidth;
import jasm.dis.DisassembledInstruction;
import jasm.dis.risc.RiscDisassembler;
import jasm.gen.risc.ppc.PPCAssembly;
import jasm.gen.risc.ppc.PPCTemplate;

/**
 *
 *
 * @author Bernd Mathiske
 */
public abstract class PPCDisassembler<DisassembledInstruction_Type extends DisassembledInstruction<PPCTemplate>>
        extends RiscDisassembler<PPCTemplate, DisassembledInstruction_Type> {

    protected PPCDisassembler(PPCAssembly assembly, WordWidth addressWidth) {
        super(assembly, addressWidth);
    }

}

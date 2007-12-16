/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.dis.ppc;

import com.sun.max.lang.Endianness;
import jasm.dis.DisassembledInstruction;
import jasm.dis.risc.RiscDisassembler;
import jasm.gen.risc.ppc.PPCAssembly;
import jasm.gen.risc.ppc.PPCTemplate;
import jasm.util.WordWidth;

/**
 *
 *
 * @author Bernd Mathiske
 */
public abstract class PPCDisassembler<DisassembledInstruction_Type extends DisassembledInstruction<PPCTemplate>>
        extends RiscDisassembler<PPCTemplate, DisassembledInstruction_Type> {

    protected PPCDisassembler(PPCAssembly assembly, WordWidth addressWidth) {
        super(assembly, addressWidth, Endianness.BIG);
    }

}

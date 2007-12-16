/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=296a5002-b096-495c-b022-7a05e7a77948*/
package jasm.dis.sparc;

import com.sun.max.lang.Endianness;
import jasm.dis.DisassembledInstruction;
import jasm.dis.risc.RiscDisassembler;
import jasm.gen.risc.sparc.SPARCAssembly;
import jasm.gen.risc.sparc.SPARCTemplate;
import jasm.util.WordWidth;

/**
 *
 *
 * @author Bernd Mathiske
 */
public abstract class SPARCDisassembler<DisassembledInstruction_Type extends DisassembledInstruction<SPARCTemplate>>
        extends RiscDisassembler<SPARCTemplate, DisassembledInstruction_Type> {

    protected SPARCDisassembler(SPARCAssembly assembly, WordWidth addressWidth) {
        super(assembly, addressWidth, Endianness.BIG);
    }

}

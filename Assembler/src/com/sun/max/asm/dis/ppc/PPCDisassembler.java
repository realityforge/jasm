/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ed10b00c-4996-44f5-a41b-7469480f246d*/
package com.sun.max.asm.dis.ppc;

import com.sun.max.asm.dis.*;
import com.sun.max.asm.dis.risc.*;
import com.sun.max.asm.gen.risc.ppc.*;
import com.sun.max.lang.*;

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

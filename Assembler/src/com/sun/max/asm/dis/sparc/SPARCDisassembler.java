/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=296a5002-b096-495c-b022-7a05e7a77948*/
package com.sun.max.asm.dis.sparc;

import com.sun.max.asm.dis.*;
import com.sun.max.asm.dis.risc.*;
import com.sun.max.asm.gen.risc.sparc.*;
import com.sun.max.lang.*;

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

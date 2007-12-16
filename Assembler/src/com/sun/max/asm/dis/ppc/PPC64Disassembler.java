/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d1f423ec-4981-41bd-be8f-0ab5e0ef0586*/
package com.sun.max.asm.dis.ppc;

import com.sun.max.asm.*;
import com.sun.max.asm.gen.risc.ppc.*;
import com.sun.max.asm.ppc.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;

/**
 * 
 *
 * @author Bernd Mathiske
 */
public class PPC64Disassembler extends PPCDisassembler<PPC64DisassembledInstruction> {

    private final long _startAddress;
    
    public PPC64Disassembler(long startAddress) {
        super(PPCAssembly.ASSEMBLY, WordWidth.BITS_64);
        _startAddress = startAddress;
    }
    
    @Override
    protected PPC64DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, PPCTemplate template, Sequence<Argument> arguments) {
        return new PPC64DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new PPC64Assembler(_startAddress + offset);
    }

}

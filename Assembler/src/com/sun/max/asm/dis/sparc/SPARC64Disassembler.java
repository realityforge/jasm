/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b26c3f79-3f29-4d32-b809-471f27689627*/
package com.sun.max.asm.dis.sparc;

import com.sun.max.asm.*;
import com.sun.max.asm.gen.risc.sparc.*;
import com.sun.max.asm.sparc.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;

/**
 * 
 *
 * @author Bernd Mathiske
 */
public class SPARC64Disassembler extends SPARCDisassembler<SPARC64DisassembledInstruction> {

    private final long _startAddress;
    
    public SPARC64Disassembler(long startAddress) {
        super(SPARCAssembly.ASSEMBLY, WordWidth.BITS_64);
        _startAddress = startAddress;
    }
    
    @Override
    protected SPARC64DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, SPARCTemplate template, Sequence<Argument> arguments) {
        return new SPARC64DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new SPARC64Assembler(_startAddress + offset);
    }

}

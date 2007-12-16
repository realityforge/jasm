/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=2bffb866-4cc7-49c9-b03d-056b501cfbcf*/
package com.sun.max.asm.dis.sparc;

import com.sun.max.asm.Argument;
import com.sun.max.asm.Assembler;
import com.sun.max.asm.gen.risc.sparc.SPARCAssembly;
import com.sun.max.asm.gen.risc.sparc.SPARCTemplate;
import com.sun.max.asm.sparc.SPARC32Assembler;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.WordWidth;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class SPARC32Disassembler extends SPARCDisassembler<SPARC32DisassembledInstruction> {

    private final int _startAddress;

    public SPARC32Disassembler(int startAddress) {
        super(SPARCAssembly.ASSEMBLY, WordWidth.BITS_32);
        _startAddress = startAddress;
    }

    @Override
    protected SPARC32DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, SPARCTemplate template, Sequence<Argument> arguments) {
        return new SPARC32DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new SPARC32Assembler(_startAddress + offset);
    }

}

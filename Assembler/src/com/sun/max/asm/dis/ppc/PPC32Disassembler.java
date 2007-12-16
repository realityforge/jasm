/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8bf76a1c-2892-43f5-bffa-9ef6880f6200*/
package com.sun.max.asm.dis.ppc;

import com.sun.max.asm.Argument;
import com.sun.max.asm.Assembler;
import com.sun.max.asm.gen.risc.ppc.PPCAssembly;
import com.sun.max.asm.gen.risc.ppc.PPCTemplate;
import com.sun.max.asm.ppc.PPC32Assembler;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.WordWidth;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class PPC32Disassembler extends PPCDisassembler<PPC32DisassembledInstruction> {

    private final int _startAddress;

    public PPC32Disassembler(int startAddress) {
        super(PPCAssembly.ASSEMBLY, WordWidth.BITS_32);
        _startAddress = startAddress;
    }

    @Override
    protected PPC32DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, PPCTemplate template, Sequence<Argument> arguments) {
        return new PPC32DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new PPC32Assembler(_startAddress + offset);
    }

}

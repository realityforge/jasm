/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.dis.ppc;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.Assembler;
import jasm.gen.risc.ppc.PPCAssembly;
import jasm.gen.risc.ppc.PPCTemplate;
import jasm.ppc.PPC32Assembler;
import jasm.util.WordWidth;

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

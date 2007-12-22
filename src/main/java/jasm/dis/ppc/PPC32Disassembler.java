/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.ppc;

import jasm.Argument;
import jasm.Assembler;
import jasm.WordWidth;
import jasm.gen.risc.ppc.PPCAssembly;
import jasm.gen.risc.ppc.PPCTemplate;
import jasm.ppc.PPC32Assembler;
import java.util.List;

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
    protected PPC32DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, PPCTemplate template, List<Argument> arguments) {
        return new PPC32DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new PPC32Assembler(_startAddress + offset);
    }

}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.sparc;

import jasm.Argument;
import jasm.Assembler;
import jasm.gen.risc.sparc.SPARCAssembly;
import jasm.gen.risc.sparc.SPARCTemplate;
import jasm.sparc.SPARC32Assembler;
import jasm.util.WordWidth;
import java.util.List;

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
    protected SPARC32DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, SPARCTemplate template, List<Argument> arguments) {
        return new SPARC32DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new SPARC32Assembler(_startAddress + offset);
    }

}

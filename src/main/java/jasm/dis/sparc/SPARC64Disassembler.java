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
import jasm.sparc.SPARC64Assembler;
import jasm.util.WordWidth;
import jasm.util.collect.Sequence;

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
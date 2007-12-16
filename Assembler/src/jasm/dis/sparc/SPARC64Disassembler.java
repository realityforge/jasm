/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.dis.sparc;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.Assembler;
import jasm.gen.risc.sparc.SPARCAssembly;
import jasm.gen.risc.sparc.SPARCTemplate;
import jasm.sparc.SPARC64Assembler;
import jasm.util.WordWidth;

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

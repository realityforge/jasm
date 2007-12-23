/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64.dis;

import jasm.Argument;
import jasm.Assembler;
import jasm.WordWidth;
import jasm.amd64.as.AMD64Assembler;
import jasm.gen.cisc.amd64.AMD64Assembly;
import jasm.gen.cisc.amd64.AMD64Template;
import jasm.gen.cisc.x86.X86Opcode;
import jasm.util.HexByte;
import jasm.x86.dis.X86Disassembler;
import jasm.x86.dis.X86InstructionHeader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Instantiate this class to disassemble AMD64 instruction streams.
 *
 * @author Bernd Mathiske
 */
public final class AMD64Disassembler extends X86Disassembler<AMD64Template, AMD64DisassembledInstruction> {

    private final long _startAddress;

    public AMD64Disassembler(long startAddress) {
        super(AMD64Assembly.ASSEMBLY, WordWidth.BITS_64);
        _startAddress = startAddress;
    }

    @Override
    protected final boolean isRexPrefix(HexByte opcode) {
        return X86Opcode.isRexPrefix(opcode);
    }

    @Override
    protected final AMD64DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, AMD64Template template, List<Argument> arguments) {
        return new AMD64DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected final Assembler createAssembler(int offset) {
        return new AMD64Assembler(_startAddress + offset);
    }

    private static Map<X86InstructionHeader, LinkedList<AMD64Template>> _headerToTemplates = X86InstructionHeader.createMapping(AMD64Assembly.ASSEMBLY, WordWidth.BITS_64);

    @Override
    protected final Map<X86InstructionHeader, LinkedList<AMD64Template>> headerToTemplates() {
        return _headerToTemplates;
    }

}

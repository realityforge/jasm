/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.amd64;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.Assembler;
import jasm.amd64.AMD64Assembler;
import jasm.dis.x86.X86Disassembler;
import jasm.dis.x86.X86InstructionHeader;
import jasm.gen.cisc.amd64.AMD64Assembly;
import jasm.gen.cisc.amd64.AMD64Template;
import jasm.gen.cisc.x86.X86Opcode;
import jasm.util.HexByte;
import jasm.util.WordWidth;
import java.util.Map;

/**
 * Instantiate this class to disassemble AMD64 instruction streams.
 *
 * @author Bernd Mathiske
 */
public class AMD64Disassembler extends X86Disassembler<AMD64Template, AMD64DisassembledInstruction> {

    private final long _startAddress;

    public AMD64Disassembler(long startAddress) {
        super(AMD64Assembly.ASSEMBLY, WordWidth.BITS_64);
        _startAddress = startAddress;
    }

    @Override
    protected boolean isRexPrefix(HexByte opcode) {
        return X86Opcode.isRexPrefix(opcode);
    }

    @Override
    protected AMD64DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, AMD64Template template, Sequence<Argument> arguments) {
        return new AMD64DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new AMD64Assembler(_startAddress + offset);
    }

    private static Map<X86InstructionHeader, AppendableSequence<AMD64Template>> _headerToTemplates = X86InstructionHeader.createMapping(AMD64Assembly.ASSEMBLY, WordWidth.BITS_64);

    @Override
    protected Map<X86InstructionHeader, AppendableSequence<AMD64Template>> headerToTemplates() {
        return _headerToTemplates;
    }

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d725708d-f679-4023-a578-460de18e0bfa*/
package jasm.dis.amd64;

import jasm.Argument;
import jasm.Assembler;
import jasm.util.WordWidth;
import jasm.amd64.AMD64Assembler;
import jasm.dis.x86.X86Disassembler;
import jasm.dis.x86.X86InstructionHeader;
import jasm.gen.cisc.amd64.AMD64Assembly;
import jasm.gen.cisc.amd64.AMD64Template;
import jasm.gen.cisc.x86.X86Opcode;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.Sequence;
import jasm.util.HexByte;
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

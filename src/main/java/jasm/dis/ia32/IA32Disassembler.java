/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.ia32;

import jasm.Argument;
import jasm.Assembler;
import jasm.dis.x86.X86Disassembler;
import jasm.dis.x86.X86InstructionHeader;
import jasm.gen.cisc.ia32.IA32Assembly;
import jasm.gen.cisc.ia32.IA32Template;
import jasm.ia32.IA32Assembler;
import jasm.util.HexByte;
import jasm.WordWidth;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Instantiate this class to disassemble IA32 instruction streams.
 *
 * @author Bernd Mathiske
 */
public class IA32Disassembler extends X86Disassembler<IA32Template, IA32DisassembledInstruction> {

    private final int _startAddress;

    public IA32Disassembler(int startAddress) {
        super(IA32Assembly.ASSEMBLY, WordWidth.BITS_32);
        _startAddress = startAddress;
    }

    @Override
    protected boolean isRexPrefix(HexByte opcode) {
        return false;
    }

    @Override
    protected IA32DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, IA32Template template, List<Argument> arguments) {
        return new IA32DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new IA32Assembler(_startAddress + offset);
    }

    private static Map<X86InstructionHeader, LinkedList<IA32Template>> _headerToTemplates =
        X86InstructionHeader.createMapping(IA32Assembly.ASSEMBLY, WordWidth.BITS_32);

    @Override
    protected Map<X86InstructionHeader, LinkedList<IA32Template>> headerToTemplates() {
        return _headerToTemplates;
    }

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=bdd25a69-9d1f-4b4f-85cc-547cbfd7a630*/
package jasm.dis.ia32;

import jasm.Argument;
import jasm.Assembler;
import jasm.dis.x86.X86Disassembler;
import jasm.dis.x86.X86InstructionHeader;
import jasm.gen.cisc.ia32.IA32Assembly;
import jasm.gen.cisc.ia32.IA32Template;
import jasm.ia32.IA32Assembler;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.WordWidth;
import com.sun.max.util.HexByte;
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
    protected IA32DisassembledInstruction createDisassembledInstruction(int offset, byte[] bytes, IA32Template template, Sequence<Argument> arguments) {
        return new IA32DisassembledInstruction(_startAddress, offset, bytes, template, arguments);
    }

    @Override
    protected Assembler createAssembler(int offset) {
        return new IA32Assembler(_startAddress + offset);
    }

    private static Map<X86InstructionHeader, AppendableSequence<IA32Template>> _headerToTemplates = X86InstructionHeader.createMapping(IA32Assembly.ASSEMBLY, WordWidth.BITS_32);

    @Override
    protected Map<X86InstructionHeader, AppendableSequence<IA32Template>> headerToTemplates() {
        return _headerToTemplates;
    }

}

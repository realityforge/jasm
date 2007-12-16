/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=bdd25a69-9d1f-4b4f-85cc-547cbfd7a630*/
package com.sun.max.asm.dis.ia32;

import java.util.*;

import com.sun.max.asm.*;
import com.sun.max.asm.dis.x86.*;
import com.sun.max.asm.gen.cisc.ia32.*;
import com.sun.max.asm.ia32.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;


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

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d725708d-f679-4023-a578-460de18e0bfa*/
package com.sun.max.asm.dis.amd64;

import java.util.*;

import com.sun.max.asm.*;
import com.sun.max.asm.amd64.*;
import com.sun.max.asm.dis.x86.*;
import com.sun.max.asm.gen.cisc.amd64.*;
import com.sun.max.asm.gen.cisc.x86.*;
import com.sun.max.collect.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

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

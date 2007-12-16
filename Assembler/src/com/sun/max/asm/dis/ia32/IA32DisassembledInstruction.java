/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a53a08f1-7599-4c3f-bd9c-5de6ee70f2b0*/
package com.sun.max.asm.dis.ia32;

import com.sun.max.asm.Argument;
import com.sun.max.asm.dis.Address32Instruction;
import com.sun.max.asm.dis.x86.X86DisassembledInstruction;
import com.sun.max.asm.gen.ImmediateArgument;
import com.sun.max.asm.gen.cisc.ia32.IA32Template;
import com.sun.max.collect.Sequence;

/**
 * @author Bernd Mathiske
 */
public class IA32DisassembledInstruction extends X86DisassembledInstruction<IA32Template> implements Address32Instruction {

    private final Address32Instruction.Mixin _addressInstruction;

    IA32DisassembledInstruction(int startAddress, int offset, byte[] bytes, IA32Template template, Sequence<Argument> arguments) {
        super(offset, bytes, template, arguments);
        _addressInstruction = new Address32Instruction.Mixin(this, startAddress);
    }

    public int address() {
        return _addressInstruction.address();
    }

    public String addressString() {
        return _addressInstruction.addressString();
    }

    public int addressToOffset(ImmediateArgument argument) {
        return _addressInstruction.addressToOffset(argument);
    }

}

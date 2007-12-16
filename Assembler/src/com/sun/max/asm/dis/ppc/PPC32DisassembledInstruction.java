/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=17ae4415-01ba-40b7-8a8f-f6b8e2a64c9b*/
package com.sun.max.asm.dis.ppc;

import com.sun.max.asm.Argument;
import com.sun.max.asm.dis.Address32Instruction;
import com.sun.max.asm.gen.ImmediateArgument;
import com.sun.max.asm.gen.risc.ppc.PPCTemplate;
import com.sun.max.collect.Sequence;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class PPC32DisassembledInstruction extends PPCDisassembledInstruction implements Address32Instruction {

    private final Address32Instruction.Mixin _addressInstruction;

    PPC32DisassembledInstruction(int startAddress, int offset, byte[] bytes, PPCTemplate template, Sequence<Argument> arguments) {
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

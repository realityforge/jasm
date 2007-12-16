/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.dis.ppc;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.dis.Address32Instruction;
import jasm.gen.ImmediateArgument;
import jasm.gen.risc.ppc.PPCTemplate;

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

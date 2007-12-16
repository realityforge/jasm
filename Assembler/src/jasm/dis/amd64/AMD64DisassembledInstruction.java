/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1ba4ceb4-dcfd-4cfc-9896-54f03e442a4c*/
package jasm.dis.amd64;

import com.sun.max.collect.Sequence;
import jasm.Argument;
import jasm.dis.Address64Instruction;
import jasm.dis.x86.X86DisassembledInstruction;
import jasm.gen.ImmediateArgument;
import jasm.gen.cisc.amd64.AMD64Template;

/**
 * @author Bernd Mathiske
 */
public class AMD64DisassembledInstruction extends X86DisassembledInstruction<AMD64Template> implements Address64Instruction {

    private final Address64Instruction.Mixin _addressInstruction;

    AMD64DisassembledInstruction(long startAddress, int offset, byte[] bytes, AMD64Template template, Sequence<Argument> arguments) {
        super(offset, bytes, template, arguments);
        _addressInstruction = new Address64Instruction.Mixin(this, startAddress);
    }

    public long address() {
        return _addressInstruction.address();
    }

    public String addressString() {
        return _addressInstruction.addressString();
    }

    public int addressToOffset(ImmediateArgument argument) {
        return _addressInstruction.addressToOffset(argument);
    }

}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.amd64;

import jasm.util.collect.Sequence;
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

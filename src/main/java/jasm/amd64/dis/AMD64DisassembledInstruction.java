/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64.dis;

import jasm.Argument;
import jasm.dis.Address64Instruction;
import jasm.gen.ImmediateArgument;
import jasm.gen.cisc.amd64.AMD64Template;
import jasm.x86.dis.X86DisassembledInstruction;
import java.util.List;

public final class AMD64DisassembledInstruction extends X86DisassembledInstruction<AMD64Template> implements Address64Instruction {

    private final Address64Instruction.Mixin _addressInstruction;

    AMD64DisassembledInstruction(long startAddress, int offset, byte[] bytes, AMD64Template template, List<Argument> arguments) {
        super(offset, bytes, template, arguments);
        _addressInstruction = new Address64Instruction.Mixin(this, startAddress);
    }

    public final long address() {
        return _addressInstruction.address();
    }

    public final String addressString() {
        return _addressInstruction.addressString();
    }

    public final int addressToOffset(ImmediateArgument argument) {
        return _addressInstruction.addressToOffset(argument);
    }

}

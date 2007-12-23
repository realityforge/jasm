/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc.dis;

import jasm.Argument;
import jasm.dis.Address32Instruction;
import jasm.gen.ImmediateArgument;
import jasm.gen.risc.ppc.PPCTemplate;
import java.util.List;

public final class PPC32DisassembledInstruction extends PPCDisassembledInstruction implements Address32Instruction {

    private final Address32Instruction.Mixin _addressInstruction;

    PPC32DisassembledInstruction(int startAddress, int offset, byte[] bytes, PPCTemplate template, List<Argument> arguments) {
        super(offset, bytes, template, arguments);
        _addressInstruction = new Address32Instruction.Mixin(this, startAddress);
    }

    public final int address() {
        return _addressInstruction.address();
    }

    public final String addressString() {
        return _addressInstruction.addressString();
    }

    public final int addressToOffset(ImmediateArgument argument) {
        return _addressInstruction.addressToOffset(argument);
    }
}

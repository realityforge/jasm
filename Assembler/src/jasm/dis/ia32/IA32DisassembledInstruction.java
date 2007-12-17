/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.ia32;

import jasm.util.collect.Sequence;
import jasm.Argument;
import jasm.dis.Address32Instruction;
import jasm.dis.x86.X86DisassembledInstruction;
import jasm.gen.ImmediateArgument;
import jasm.gen.cisc.ia32.IA32Template;

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

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis.sparc;

import jasm.Argument;
import jasm.dis.Address64Instruction;
import jasm.gen.ImmediateArgument;
import jasm.gen.risc.sparc.SPARCTemplate;
import java.util.List;

/**
 *
 *
 * @author Bernd Mathiske
 */
public final class SPARC64DisassembledInstruction extends SPARCDisassembledInstruction implements Address64Instruction {

    private final Address64Instruction.Mixin _addressInstruction;

    SPARC64DisassembledInstruction(long startAddress, int offset, byte[] bytes, SPARCTemplate template, List<Argument> arguments) {
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

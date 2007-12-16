/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=537d7b6b-3a9b-4e1a-89a3-529c4c290851*/
package jasm.dis.sparc;

import jasm.Argument;
import jasm.dis.Address64Instruction;
import jasm.gen.ImmediateArgument;
import jasm.gen.risc.sparc.SPARCTemplate;
import com.sun.max.collect.Sequence;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class SPARC64DisassembledInstruction extends SPARCDisassembledInstruction implements Address64Instruction {

    private final Address64Instruction.Mixin _addressInstruction;

    SPARC64DisassembledInstruction(long startAddress, int offset, byte[] bytes, SPARCTemplate template, Sequence<Argument> arguments) {
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

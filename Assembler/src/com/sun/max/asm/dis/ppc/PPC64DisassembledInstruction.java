/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c2f9ab55-e4f9-4478-bb68-c4bff6978228*/
package com.sun.max.asm.dis.ppc;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.dis.*;
import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.ppc.*;
import com.sun.max.collect.*;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class PPC64DisassembledInstruction extends PPCDisassembledInstruction implements Address64Instruction {

    private final Address64Instruction.Mixin _addressInstruction;

    PPC64DisassembledInstruction(long startAddress, int offset, byte[] bytes, PPCTemplate template, Sequence<Argument> arguments) {
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

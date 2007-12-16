/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=88d6bb90-c720-4bd2-89ae-5fa13ef0d31f*/
package com.sun.max.asm.dis;

import com.sun.max.annotate.*;
import com.sun.max.asm.gen.*;

/**
 * Mixin delegation style (for lack of multiple class inheritance in the Java(TM) Programming Language).
 *
 * @author Bernd Mathiske
 */
public interface Address32Instruction extends AddressInstruction {

    int address();
    
    public static class Mixin implements Address32Instruction {

        private final int _startAddress;
        private final DisassembledInstruction _disassembledInstruction;

        public Mixin(DisassembledInstruction disassembledInstruction, int startAddress) {
            _startAddress = startAddress;
            _disassembledInstruction = disassembledInstruction;
        }
        
        @Implement(Address32Instruction.class)
        public int address() {
            return _startAddress + startOffset();
        }

        @Implement(AddressInstruction.class)
        public int startOffset() {
            return _disassembledInstruction.startOffset();
        }
        
        @Implement(AddressInstruction.class)
        public String addressString() {
            return String.format("0x%08X", address());
        }

        @Implement(AddressInstruction.class)
        public int addressToOffset(ImmediateArgument argument) {
            final int argumentAddress = (int) argument.asLong();
            return argumentAddress - _startAddress;
        }
    }

}

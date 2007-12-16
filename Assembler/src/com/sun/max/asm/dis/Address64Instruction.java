/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=9aa886ec-74b0-4727-b53b-27d5b34fe87e*/
package com.sun.max.asm.dis;

import com.sun.max.annotate.*;
import com.sun.max.asm.gen.*;

/**
 * Mixin delegation style (for lack of multiple class inheritance in the Java(TM) Programming Language).
 *
 * @author Bernd Mathiske
 */
public interface Address64Instruction extends AddressInstruction {

    long address();
    
    public static class Mixin implements Address64Instruction {

        private final long _startAddress;
        private final DisassembledInstruction _disassembledInstruction;

        public Mixin(DisassembledInstruction disassembledInstruction, long startAddress) {
            _startAddress = startAddress;
            _disassembledInstruction = disassembledInstruction;
        }
        
        @Implement(Address64Instruction.class)
        public long address() {
            return _startAddress + startOffset();
        }

        @Implement(AddressInstruction.class)
        public int startOffset() {
            return _disassembledInstruction.startOffset();
        }
        
        @Implement(AddressInstruction.class)
        public String addressString() {
            return String.format("0x%016X", address());
        }

        @Implement(AddressInstruction.class)
        public int addressToOffset(ImmediateArgument argument) {
            final long argumentAddress = argument.asLong();
            final long result = argumentAddress - _startAddress;
            if (result > Integer.MAX_VALUE) {
                return -1;
            }
            return (int) result;
        }
    }

}

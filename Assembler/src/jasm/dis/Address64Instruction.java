/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.dis;

import jasm.gen.ImmediateArgument;

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

        public long address() {
            return _startAddress + startOffset();
        }

        public int startOffset() {
            return _disassembledInstruction.startOffset();
        }

        public String addressString() {
            return String.format("0x%016X", address());
        }

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

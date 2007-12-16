/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis;

import jasm.gen.ImmediateArgument;

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

        public int address() {
            return _startAddress + startOffset();
        }

        public int startOffset() {
            return _disassembledInstruction.startOffset();
        }

        public String addressString() {
            return String.format("0x%08X", address());
        }

        public int addressToOffset(ImmediateArgument argument) {
            final int argumentAddress = (int) argument.asLong();
            return argumentAddress - _startAddress;
        }
    }

}

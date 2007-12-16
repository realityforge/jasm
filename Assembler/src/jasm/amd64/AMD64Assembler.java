/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.amd64;

import jasm.Assembler64;
import jasm.AssemblyException;
import jasm.InstructionSet;
import jasm.Label;

/**
 * Instantiate this class to assemble AMD64 instructions.
 *
 * @author Bernd Mathiske
 */
public class AMD64Assembler extends AMD64LabelAssembler implements Assembler64 {

    @Override
    public final InstructionSet instructionSet() {
        return InstructionSet.AMD64;
    }

    private long _startAddress; // address of first instruction

    public AMD64Assembler(long startAddress) {
        _startAddress = startAddress;
    }

    public AMD64Assembler() {
    }

    public long startAddress() {
        return _startAddress;
    }

    public void setStartAddress(long address) {
        _startAddress = address;
    }

    public void fixLabel(Label label, long address) {
        fixLabel64(label, address);
    }

    public long address(Label label) throws AssemblyException {
        return address64(label);
    }
}

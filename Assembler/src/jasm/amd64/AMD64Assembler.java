/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
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

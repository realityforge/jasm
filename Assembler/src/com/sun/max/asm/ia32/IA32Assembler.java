/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e19286e4-b44f-4071-ab3c-ce1a4961889b*/
package com.sun.max.asm.ia32;

import com.sun.max.asm.Assembler32;
import com.sun.max.asm.AssemblyException;
import com.sun.max.asm.InstructionSet;
import com.sun.max.asm.Label;

/**
 * Instatiate this class to assemble IA32 instructions.
 *
 * @author Bernd Mathiske
 */
public class IA32Assembler extends IA32LabelAssembler implements Assembler32 {

    @Override
    public final InstructionSet instructionSet() {
        return InstructionSet.IA32;
    }

    private int _startAddress; // address of first instruction

    public int startAddress() {
        return _startAddress;
    }

    public IA32Assembler() {
    }

    public IA32Assembler(int startAddress) {
        _startAddress = startAddress;
    }

    public void fixLabel(Label label, int address) {
        fixLabel32(label, address);
    }

    public int address(Label label) throws AssemblyException {
        return address32(label);
    }

}

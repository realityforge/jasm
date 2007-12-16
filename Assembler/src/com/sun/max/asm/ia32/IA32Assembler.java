/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e19286e4-b44f-4071-ab3c-ce1a4961889b*/
package com.sun.max.asm.ia32;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;

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

    @Implement(Assembler32.class)
    public int startAddress() {
        return _startAddress;
    }

    public IA32Assembler() {
    }

    public IA32Assembler(int startAddress) {
        _startAddress = startAddress;
    }

    @Implement(Assembler32.class)
    public void fixLabel(Label label, int address) {
        fixLabel32(label, address);
    }
    
    @Implement(Assembler32.class)
    public int address(Label label) throws AssemblyException {
        return address32(label);
    }

}

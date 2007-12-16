/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d50a56b5-3cd4-4d2f-862c-d3ea05e743a7*/
package com.sun.max.asm.sparc;

import com.sun.max.asm.Assembler32;
import com.sun.max.asm.AssemblyException;
import com.sun.max.asm.Label;

/**
 * The concrete class for a 32-bit SPARC assembler.

 * @author Bernd Mathiske
 */
public class SPARC32Assembler extends SPARCAssembler implements Assembler32 {

    private final int _startAddress; // address of first instruction

    public SPARC32Assembler(int startAddress) {
        _startAddress = startAddress;
    }

    public int startAddress() {
        return _startAddress;
    }

    public void fixLabel(Label label, int address) {
        fixLabel32(label, address);
    }

    public int address(Label label) throws AssemblyException {
        return address32(label);
    }

}

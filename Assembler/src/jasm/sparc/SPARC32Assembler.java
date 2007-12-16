/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.sparc;

import jasm.Assembler32;
import jasm.AssemblyException;
import jasm.Label;

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

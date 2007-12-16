/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e9158016-fa87-41db-b24a-fca8aa4c9846*/
package com.sun.max.asm.ppc;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;


/**
 * The concrete class for a 32-bit PowerPC assembler.

 * @author Bernd Mathiske
 */
public class PPC32Assembler extends PPCAssembler implements Assembler32 {

    private final int _startAddress; // address of first instruction

    public PPC32Assembler(int startAddress) {
        _startAddress = startAddress;
    }

    @Implement(Assembler32.class)
    public int startAddress() {
        return _startAddress;
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

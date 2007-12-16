/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0214ac12-bedd-4991-8634-cfc2ed4db004*/
package com.sun.max.asm.ppc;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;

/**
 * The concrete class for a 64-bit PowerPC assembler.
 * 
 * @author Bernd Mathiske
 */
public class PPC64Assembler extends PPCAssembler implements Assembler64 {

    private long _startAddress; // address of first instruction

    public PPC64Assembler() {
    }

    public PPC64Assembler(long startAddress) {
        _startAddress = startAddress;
    }

    @Implement(Assembler64.class)
    public long startAddress() {
        return _startAddress;
    }

    @Implement(Assembler64.class)
    public void setStartAddress(long address) {
        _startAddress = address;
    }
    
    @Implement(Assembler64.class)
    public void fixLabel(Label label, long address) {
        fixLabel64(label, address);
    }
    
    @Implement(Assembler64.class)
    public long address(Label label) throws AssemblyException {
        return address64(label);
    }

}

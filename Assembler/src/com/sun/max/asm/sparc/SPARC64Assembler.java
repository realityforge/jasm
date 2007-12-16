/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f1f8c87f-b06b-49a5-917c-509fd75eb9fa*/
package com.sun.max.asm.sparc;

import com.sun.max.asm.Assembler64;
import com.sun.max.asm.AssemblyException;
import com.sun.max.asm.Label;

/**
 * The concrete class for a 64-bit SPARC assembler.
 *
 * @author Bernd Mathiske
 */
public class SPARC64Assembler extends SPARCAssembler implements Assembler64 {

    private long _startAddress; // address of first instruction

    public SPARC64Assembler() {
    }

    public SPARC64Assembler(long startAddress) {
        _startAddress = startAddress;
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

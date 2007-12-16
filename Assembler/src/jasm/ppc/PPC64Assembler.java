/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0214ac12-bedd-4991-8634-cfc2ed4db004*/
package jasm.ppc;

import jasm.Assembler64;
import jasm.AssemblyException;
import jasm.Label;

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

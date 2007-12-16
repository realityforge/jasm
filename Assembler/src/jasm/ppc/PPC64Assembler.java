/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
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

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=59b102d2-1868-4b7f-b120-d794bc3ecf54*/
package com.sun.max.asm;

import com.sun.max.program.*;

/**
 * 
 *
 * @author Bernd Mathiske
 */
public abstract class LabelAddressInstruction extends LabelInstruction {

    protected LabelAddressInstruction(Assembler assembler, int startOffset, int endOffset, Label label) {
        super(assembler, startOffset, endOffset, label);
        assembler.addFixedLengthLabelInstruction(this);
    }
    
    public int labelAddressAsInt() throws AssemblyException {
        final Assembler32 assembler = (Assembler32) assembler();
        switch (label().state()) {
            case BOUND: {
                return assembler.startAddress() + label().offset();
            }
            case FIXED_32: {
                return assembler.address(label());
            }
            case FIXED_64: {
                ProgramError.unexpected("64-bit address requested for 32-bit assembler");
                return -1;
            }
            default: {
                throw new AssemblyException("unassigned label");
            }
        }
    }

    public long labelAddressAsLong() throws AssemblyException {
        final Assembler64 assembler = (Assembler64) assembler();
        switch (label().state()) {
            case BOUND: {
                return assembler.startAddress() + label().offset();
            }
            case FIXED_64: {
                return assembler.address(label());
            }
            case FIXED_32: {
                ProgramError.unexpected("32-bit address requested for 64-bit assembler");
                return -1;
            }
            default: {
                throw new AssemblyException("unassigned label");
            }
        }
    }
}

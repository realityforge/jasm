/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=640e4510-40c9-4c8f-a101-06ed223d1548*/
package com.sun.max.asm.gen.risc.bitRange;


/**
 * A bit range that has its least significant bit on the left and its most significant bit on the right.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 * @author Dave Ungar
 * @author Adam Spitz
 */
public class AscendingBitRange extends SimpleBitRange {
    
    public AscendingBitRange(int firstBitIndex, int lastBitIndex) {
        super(firstBitIndex, lastBitIndex);
        if (firstBitIndex > lastBitIndex) {
            throw new IllegalArgumentException("bit ranges are specified from left to right, and ascending notation starts at 0 and goes up to 31");
        }
    }

    @Override
    public AscendingBitRange move(boolean left, int bits) {
        if (left) {
            return new AscendingBitRange(_firstBitIndex - bits, _lastBitIndex - bits); 
        }
        return new AscendingBitRange(_firstBitIndex + bits, _lastBitIndex + bits); 
    }

    @Override 
    public int numberOfLessSignificantBits() {
        return (32 - _lastBitIndex) - 1;
    }
    
    @Override 
    public int width() {
        return (_lastBitIndex - _firstBitIndex) + 1;
    }
}

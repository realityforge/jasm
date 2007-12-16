/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7865240e-414c-4e98-ba17-0d7a017b142c*/
package com.sun.max.asm.gen.risc.bitRange;


/**
 * The bit range order of an instruction set is how the bit positions of instruction fields
 * are specified in the architecture manual.
 * 
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public enum BitRangeOrder {

    DESCENDING {
        @Override
        public SimpleBitRange createSimpleBitRange(int firstBitIndex, int lastBitIndex) {
            return new DescendingBitRange(firstBitIndex, lastBitIndex);
        }
    },
    
    ASCENDING {
        @Override 
        public SimpleBitRange createSimpleBitRange(int firstBitIndex, int lastBitIndex) {
            return new AscendingBitRange(firstBitIndex, lastBitIndex);
        }
    };
    
    public abstract SimpleBitRange createSimpleBitRange(int firstBitIndex, int lastBitIndex);
    
}

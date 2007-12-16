/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.bitRange;


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

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.bitRange;


/**
 * A bit range that has its most significant bit on the left and its least significant bit on the right.
 */
public final class DescendingBitRange extends SimpleBitRange {

    public DescendingBitRange(int firstIndex, int lastIndex) {
        super(firstIndex, lastIndex);
        if (firstIndex < lastIndex) {
            throw new IllegalArgumentException("bit ranges are specified from left to right, and descending notation starts at 31 and goes down to 0");
        }
    }

    @Override
    public final DescendingBitRange move(boolean left, int bits) {
        if (left) {
            return new DescendingBitRange(_firstBitIndex + bits, _lastBitIndex + bits);
        }
        return new DescendingBitRange(_firstBitIndex - bits, _lastBitIndex - bits);
    }

    @Override
    public final int numberOfLessSignificantBits() {
        return _lastBitIndex;
    }

    @Override
    public final int width() {
        return (_firstBitIndex - _lastBitIndex) + 1;
    }
}

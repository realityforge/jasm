/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.bitRange;


/**
 * A bit range that has its least significant bit on the left and its most significant bit on the right.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 * @author Dave Ungar
 * @author Adam Spitz
 */
public final class AscendingBitRange extends SimpleBitRange {

    public AscendingBitRange(int firstBitIndex, int lastBitIndex) {
        super(firstBitIndex, lastBitIndex);
        if (firstBitIndex > lastBitIndex) {
            throw new IllegalArgumentException("bit ranges are specified from left to right, and ascending notation starts at 0 and goes up to 31");
        }
    }

    @Override
    public final AscendingBitRange move(boolean left, int bits) {
        if (left) {
            return new AscendingBitRange(_firstBitIndex - bits, _lastBitIndex - bits);
        }
        return new AscendingBitRange(_firstBitIndex + bits, _lastBitIndex + bits);
    }

    @Override
    public final int numberOfLessSignificantBits() {
        return (32 - _lastBitIndex) - 1;
    }

    @Override
    public final int width() {
        return (_lastBitIndex - _firstBitIndex) + 1;
    }
}

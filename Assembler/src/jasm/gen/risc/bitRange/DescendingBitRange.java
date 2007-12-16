/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=390d9d0c-998e-4070-b8b4-ac5878d313a1*/
package jasm.gen.risc.bitRange;


/**
 * A bit range that has its most significant bit on the left and its least significant bit on the right.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 * @author Dave Ungar
 * @author Adam Spitz
 */
public class DescendingBitRange extends SimpleBitRange {

    public DescendingBitRange(int firstIndex, int lastIndex) {
        super(firstIndex, lastIndex);
        if (firstIndex < lastIndex) {
            throw new IllegalArgumentException("bit ranges are specified from left to right, and descending notation starts at 31 and goes down to 0");
        }
    }

    @Override
    public DescendingBitRange move(boolean left, int bits) {
        if (left) {
            return new DescendingBitRange(_firstBitIndex + bits, _lastBitIndex + bits);
        }
        return new DescendingBitRange(_firstBitIndex - bits, _lastBitIndex - bits);
    }

    @Override
    public int numberOfLessSignificantBits() {
        return _lastBitIndex;
    }

    @Override
    public int width() {
        return (_firstBitIndex - _lastBitIndex) + 1;
    }
}
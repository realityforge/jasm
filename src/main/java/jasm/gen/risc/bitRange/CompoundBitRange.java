/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.bitRange;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A range of bits that is composed of several disjoint subranges.
 */
public final class CompoundBitRange extends BitRange {

    public CompoundBitRange() {
        super();
    }

    private ArrayList<ContiguousBitRange> _contiguousBitRanges = new ArrayList<ContiguousBitRange>();

  public final void add(ContiguousBitRange contiguousBitRange) {
        _contiguousBitRanges.add(contiguousBitRange);
    }

    @Override
    public final CompoundBitRange move(boolean left, int bits) {
        final CompoundBitRange movedRange = new CompoundBitRange();
        for (ContiguousBitRange contiguousBitRange : _contiguousBitRanges) {
            movedRange.add((ContiguousBitRange) contiguousBitRange.move(left, bits));
        }
        return movedRange;
    }

    @Override
    public final int width() {
        int result = 0;
        for (ContiguousBitRange contiguousBitRange : _contiguousBitRanges) {
            result += contiguousBitRange.width();
        }
        return result;
    }

    @Override
    public final int encodedWidth() {
        int result = 0;
        for (ContiguousBitRange contiguousBitRange : _contiguousBitRanges) {
            result += contiguousBitRange.encodedWidth();
        }
        return result;
    }

    @Override
    public final int instructionMask() {
        int mask = 0;
        for (ContiguousBitRange contiguousBitRange : _contiguousBitRanges) {
            mask |= contiguousBitRange.instructionMask();
        }
        return mask;
    }

    @Override
    public final int numberOfLessSignificantBits() {
        int result = 32;
        for (ContiguousBitRange contiguousBitRange : _contiguousBitRanges) {
            final int n = contiguousBitRange.numberOfLessSignificantBits();
            if (n < result) {
                result = n;
            }
        }
        return result;
    }

    @Override
    public final boolean equals(Object other) {
        if (!(other instanceof CompoundBitRange)) {
            return false;
        }
        final CompoundBitRange compoundBitRange = (CompoundBitRange) other;
        return _contiguousBitRanges.equals(compoundBitRange._contiguousBitRanges);
    }

    @Override
    public final int hashCode() {
        return _contiguousBitRanges.hashCode();
    }

    @Override
    public final String toString() {
        String result = null;
        for (ContiguousBitRange contiguousBitRange : _contiguousBitRanges) {
            if (result != null) {
                result += "," + contiguousBitRange;
            } else {
                result = contiguousBitRange.toString();
            }
        }
        return result;
    }

    /* Extracting */

    @Override
    public final int extractSignedInt(int instruction) {
        final Iterator<ContiguousBitRange> iterator = _contiguousBitRanges.iterator();
        final ContiguousBitRange firstBitRange = iterator.next();
        int signedInt = firstBitRange.extractSignedInt(instruction);
        while (iterator.hasNext()) {
            final ContiguousBitRange contiguousBitRange = iterator.next();
            signedInt <<= contiguousBitRange.width();
            signedInt |= contiguousBitRange.extractUnsignedInt(instruction);
        }
        return signedInt;
    }

    @Override
    public final int extractUnsignedInt(int instruction) {
        int unsignedInt = 0;
        for (ContiguousBitRange contiguousBitRange : _contiguousBitRanges) {
            unsignedInt <<= contiguousBitRange.width();
            unsignedInt |= contiguousBitRange.extractUnsignedInt(instruction);
        }
        return unsignedInt;
    }

    /* Inserting */

    @Override
    public final int assembleUncheckedSignedInt(int signedInt) throws IndexOutOfBoundsException {
        int value = signedInt;
        int result = 0;
        for (int i = _contiguousBitRanges.size() - 1; i >= 0; i--) {
            final ContiguousBitRange contiguousBitRange = _contiguousBitRanges.get(i);
            result |= contiguousBitRange.assembleUncheckedSignedInt(value);
            value >>= contiguousBitRange.width();
        }
        return result;
    }

    @Override
    public final int assembleUncheckedUnsignedInt(int unsignedInt) throws IndexOutOfBoundsException {
        int value = unsignedInt;
        int result = 0;
        for (int i = _contiguousBitRanges.size() - 1; i >= 0; i--) {
            final ContiguousBitRange contiguousBitRange = _contiguousBitRanges.get(i);
            result |= contiguousBitRange.assembleUncheckedUnsignedInt(value);
            value >>>= contiguousBitRange.width();
        }
        return result;
    }

    @Override
    public final String encodingString(String value, boolean signed, boolean checked) {
        final StringBuilder sb = new StringBuilder();
        int shift = 0;
        for (int i = _contiguousBitRanges.size() - 1; i >= 0; i--) {
            final ContiguousBitRange contiguousBitRange = _contiguousBitRanges.get(i);
            final String bits = (shift == 0) ? value : "(" + value + (signed ? " >> " : " >>> ") + shift + ")";
            final String encoding = contiguousBitRange.encodingString(bits, signed, false);
            if (encoding.length() != 0) {
                if (sb.length() != 0) {
                    sb.append(" | ");
                }
                sb.append(encoding);
            }
            shift += contiguousBitRange.width();
        }
        return sb.toString();
    }
}

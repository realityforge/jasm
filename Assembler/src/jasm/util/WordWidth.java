/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=965daa4f-e3d7-4169-8512-ed72cd296924*/
package jasm.util;

import com.sun.max.lang.Ints;
import com.sun.max.lang.Longs;

/**
 * A word width value describes many bits there are in a machine word.
 *
 * @author Bernd Mathiske
 */
public enum WordWidth {

    BITS_8(8, byte.class, Byte.MIN_VALUE, Byte.MAX_VALUE),
    BITS_16(16, short.class, Short.MIN_VALUE, Short.MAX_VALUE),
    BITS_32(32, int.class, Integer.MIN_VALUE, Integer.MAX_VALUE),
    BITS_64(64, long.class, Long.MIN_VALUE, Long.MAX_VALUE);

    private final int _nBits;
    private final Class _canonicalPrimitiveType;
    private final long _min;
    private final long _max;

    private WordWidth(int nBits, Class canonicalPrimitiveType, long min, long max) {
        _nBits = nBits;
        _canonicalPrimitiveType = canonicalPrimitiveType;
        _min = min;
        _max = max;
    }

    public final int numberOfBits() {
        return _nBits;
    }

    public final int numberOfBytes() {
        return _nBits / 8;
    }

    public Class canonicalPrimitiveType() {
        return _canonicalPrimitiveType;
    }

    public long min() {
        return _min;
    }

    public long max() {
        return _max;
    }

    public boolean lessThan(WordWidth other) {
        return numberOfBits() < other.numberOfBits();
    }

    public boolean lessEqual(WordWidth other) {
        return numberOfBits() <= other.numberOfBits();
    }

    public boolean greaterThan(WordWidth other) {
        return numberOfBits() > other.numberOfBits();
    }

    public boolean greaterEqual(WordWidth other) {
        return numberOfBits() >= other.numberOfBits();
    }

    @Override
    public String toString() {
        return Integer.toString(_nBits);
    }

    public static WordWidth fromInt(int wordWidth) {
        if (wordWidth <= 8) {
            return WordWidth.BITS_8;
        }
        if (wordWidth <= 16) {
            return WordWidth.BITS_16;
        }
        if (wordWidth <= 32) {
            return WordWidth.BITS_32;
        }
        return WordWidth.BITS_64;
    }

    /**
     * @return which word width is minimally required to represent all the non-one bits in the signed argument, and a sign bit
     */
    public static WordWidth signedEffective(int signed) {
        return fromInt(Ints.numberOfEffectiveSignedBits(signed));
    }

    /**
     * @return which word width is minimally required to represent all the non-zero bits in the unsigned argument
     */
    public static WordWidth unsignedEffective(int unsigned) {
        return fromInt(Ints.numberOfEffectiveUnsignedBits(unsigned));
    }

    /**
     * @return which word width is minimally required to represent all the non-one bits in the signed argument, and a sign bit
     */
    public static WordWidth signedEffective(long signed) {
        return fromInt(Longs.numberOfEffectiveSignedBits(signed));
    }

    /**
     * @return which word width is minimally required to represent all the non-zero bits in the unsigned argument
     */
    public static WordWidth unsignedEffective(long unsigned) {
        return fromInt(Longs.numberOfEffectiveUnsignedBits(unsigned));
    }
}

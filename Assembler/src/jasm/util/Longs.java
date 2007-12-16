/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import com.sun.max.lang.Strings;

/**
 * Additonal methods that one might want in java.lang.Long.
 *
 * @author Bernd Mathiske
 */
public final class Longs {

    private Longs() {
    }

    public static int compare(long greater, long lesser) {
        if (greater > lesser) {
            return 1;
        }
        if (greater == lesser) {
            return 0;
        }
        return -1;
    }

    public static int numberOfEffectiveSignedBits(long signed) {
        if (signed >= 0) {
            return 65 - Long.numberOfLeadingZeros(signed);
        }
        return 65 - Long.numberOfLeadingZeros(~signed);
    }

    public static int numberOfEffectiveUnsignedBits(long unsigned) {
        return 64 - Long.numberOfLeadingZeros(unsigned);
    }

    public static byte getByte(long value, int index) {
        return (byte) ((value >> (index * 8)) & 0xffL);
    }

    public static String toPaddedHexString(long n, char pad) {
        final String s = Long.toHexString(n);
        return Strings.times(pad, 16 - s.length()) + s;
    }

}

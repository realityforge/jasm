/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5080a7b0-efc5-4705-aaa2-54373c3cb837*/
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

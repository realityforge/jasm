/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

/**
 * Additonal methods that one might want in java.lang.Integer
 * and int array stuff.
 *
 * @author Bernd Mathiske
 */
public final class Ints {

    // Utility classes should not be instantiated.
    private Ints() {
    }

  public static int numberOfEffectiveSignedBits(int signed) {
        if (signed >= 0) {
            return 33 - Integer.numberOfLeadingZeros(signed);
        }
        return 33 - Integer.numberOfLeadingZeros(~signed);
    }

    public static int numberOfEffectiveUnsignedBits(int unsigned) {
        return 32 - Integer.numberOfLeadingZeros(unsigned);
    }

  public static int roundedUp(int value, int by) {
        final int rest = value % by;
        if (rest == 0) {
            return value;
        }
        if (value < 0) {
            return value - rest;
        }
        return value + (by - rest);
    }

    public static String toHexLiteral(int value) {
        return "0x" + String.format("%08X", value);
    }

  public static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public static int[] append(int[] array, int element) {
        final int resultLength = array.length + 1;
        final int[] result = new int[resultLength];
        System.arraycopy(array, 0, result, 0, array.length);
        result[array.length] = element;
        return result;
    }

  public static int[] createRange(int first, int last) {
        if (first > last) {
            throw new IllegalArgumentException();
        }
        final int n = last + 1 - first;
        final int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = first + i;
        }
        return result;
    }

}

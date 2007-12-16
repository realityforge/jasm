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
 * Additonal methods that one might want in java.lang.Integer
 * and int array stuff.
 *
 * @author Bernd Mathiske
 */
public final class Ints {

    // Utility classes should not be instantiated.
    private Ints() {
    }

    public static int compare(int greater, int lesser) {
        if (greater > lesser) {
            return 1;
        }
        if (greater == lesser) {
            return 0;
        }
        return -1;
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

    public static int log2(int n) {
        if (n <= 0) {
            throw new ArithmeticException();
        }
        return 31 - Integer.numberOfLeadingZeros(n);
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

    public static String toPaddedHexString(int n, char pad) {
        final String s = Integer.toHexString(n);
        return Strings.times(pad, 8 - s.length()) + s;
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

    public static int[] append(int[] head, int[] tail) {
        final int[] result = new int[head.length + tail.length];
        System.arraycopy(head, 0, result, 0, head.length);
        System.arraycopy(tail, 0, result, head.length, tail.length);
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

    public static void copyAll(int[] fromArray, int[] toArray) {
        for (int i = 0; i < fromArray.length; i++) {
            toArray[i] = fromArray[i];
        }
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * Adjacent elements are separated by the specified separator. Elements are
     * converted to strings as by <tt>String.valueOf(int)</tt>.
     *
     * @param array     the array whose string representation to return
     * @param separator the separator to use
     * @return a string representation of <tt>array</tt>
     * @throws NullPointerException if {@code array} or {@code separator} is null
     */
    public static String toString(int[] array, String separator) {
        if (array == null || separator == null) {
            throw new NullPointerException();
        }
        if (array.length == 0) {
            return "";
        }

        final StringBuilder buf = new StringBuilder();
        buf.append(array[0]);

        for (int i = 1; i < array.length; i++) {
            buf.append(separator);
            buf.append(array[i]);
        }

        return buf.toString();
    }

}

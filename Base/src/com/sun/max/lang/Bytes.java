/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.lang;

import com.sun.max.io.Streams;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Byte array operations.
 *
 * @author Bernd Mathiske
 */
public final class Bytes {

    private Bytes() {
    }

    public static int zeroExtendedToInt(byte b) {
        final char ch = (char) b;
        return ch;
    }

    public static boolean equals(byte[] array1, byte[] array2, int length) {
        if (array1.length < length || array2.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(byte[] array1, byte[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        return equals(array1, array2, array1.length);
    }

    public static void copy(byte[] fromArray, int fromStartIndex, byte[] toArray,
                            final int toStartIndex, int nBytes) {
        for (int i = 0; i < nBytes; i++) {
            toArray[toStartIndex + i] = fromArray[fromStartIndex + i];
        }
    }

    public static void copy(byte[] fromArray, byte[] toArray, int nBytes) {
        copy(fromArray, 0, toArray, 0, nBytes);
    }

    public static void copyAll(byte[] fromArray, byte[] toArray, int toStartIndex) {
        copy(fromArray, 0 , toArray, toStartIndex, fromArray.length);
    }

    public static void copyAll(byte[] fromArray, byte[] toArray) {
        copy(fromArray, 0 , toArray, 0, fromArray.length);
    }

    public static byte[] getSection(byte[] fromArray, int startIndex, int endIndex) {
        final int length = endIndex - startIndex;
        final byte[] result = new byte[length];
        copy(fromArray, startIndex, result, 0, length);
        return result;
    }

    public static void clear(final byte[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) 0;
        }
    }

    public static String toHexLiteral(byte value) {
        return "0x" + String.format("%02X", value);
    }

    public static String toHexLiteral(byte[] values) {
        String s = "0x";
        for (byte value : values) {
            s += String.format("%02X", value);
        }
        return s;
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
    public static String toString(byte[] array, String separator) {
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

    public static byte[] fromInputStream(InputStream inputStream) throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Streams.copy(inputStream, outputStream);
        return outputStream.toByteArray();
    }

}

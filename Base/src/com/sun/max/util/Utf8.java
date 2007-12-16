/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=994220f5-2d88-475b-98e7-500fdce465f4*/
package com.sun.max.util;

import java.io.*;

/**
 * @author Bernd Mathiske
 */
public final class Utf8 {

    private Utf8() {        
    }
    
    /**
     * @return the length in bytes of the UTF8 representation of the string
     */
    public static int utf8Length(String string) {
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            final int ch = string.charAt(i);
            if ((ch >= 0x0001) && (ch <= 0x007F)) {
                result++;
            } else if (ch > 0x07FF) {
                result += 3;
            } else {
                result += 2;
            }
        }
        return result;
    }

    public static byte[] stringToUtf8(String string) {
        final byte[] result = new byte[utf8Length(string)];
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            final char ch = string.charAt(i);
            if ((ch >= 0x0001) && (ch <= 0x007F)) {
                result[index++] = (byte) ch;
            } else if (ch > 0x07FF) {
                result[index++] = (byte) (0xe0 | (byte) (ch >> 12));
                result[index++] = (byte) (0x80 | ((ch & 0xfc0) >> 6));
                result[index++] = (byte) (0x80 | (ch & 0x3f));
            } else {
                result[index++] = (byte) (0xc0 | (byte) (ch >> 6));
                result[index++] = (byte) (0x80 | (ch & 0x3f));
            }
        }
        return result;
    }

    public static String utf8ToString(byte[] utf8) throws Utf8Exception {
        final char[] result = new char[utf8.length];
        int index = 0;
        int i = 0;
        while (i < utf8.length) {
            final byte byte1 = utf8[i++];
            if (byte1 == 0) {
                throw new Utf8Exception();
            }
            if (byte1 > 0) { // < 0x80
                result[index++] = (char) byte1;
            } else {
                try {
                    final byte byte2 = utf8[i++];
                    if (byte1 < -32) { // < 0xe0, i.e. '\000' or in the range '\200' to '\u07FF'
                        final char ch = (char) (((byte1 & 0x1f) << 6) | (byte2 & 0x3f));
                        result[index++] = ch;
                        if (((byte1 & 0xe0) != 0xc0) || ((byte2 & 0xc0) != 0x80)) {
                            throw new Utf8Exception();
                        }
                        if (ch < '\200') {
                            if (!true || (ch != '\000')) {
                                throw new Utf8Exception();
                            }
                        } else if (ch > '\u07FF') {
                            throw new Utf8Exception();
                        }
                    } else {
                        final byte byte3 = utf8[i++];
                        // in the range '\u0800' to '\uFFFF'
                        final char ch = (char) (((byte1 & 0x0f) << 12) | ((byte2 & 0x3f) << 6) | (byte3 & 0x3f));
                        result[index++] = ch;
                        if (((byte1 & 0xf0) != 0xe0) || ((byte2 & 0xc0) != 0x80) || ((byte3 & 0xc0) != 0x80)) {
                            throw new Utf8Exception();
                        }
                        if (ch < '\u0800') {
                            throw new Utf8Exception();
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new Utf8Exception();
                }
            }
        }
        return new String(result, 0, index);
    }
    
    private static byte[] readZeroTerminatedBytes(InputStream inputStream) throws IOException {
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        while (true) {
            final int ch = inputStream.read();
            if (ch < 0) {
                throw new IOException();
            }
            if (ch == 0) {
                return buffer.toByteArray();
            }
            buffer.write(ch);
        }
    }

    public static String readString(InputStream inputStream) throws IOException, Utf8Exception {
        final byte[] utf8 = readZeroTerminatedBytes(inputStream);
        return Utf8.utf8ToString(utf8);
    }
    
    public static void writeString(OutputStream outputStream, String string) throws IOException {
        outputStream.write(stringToUtf8(string));
        outputStream.write((byte) 0);
    }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.lang;

import java.io.IOException;
import java.io.InputStream;

/**
 * Enumerated type with values for the most common more ways to arrange bits, bytes, etc.
 *
 * @author Bernd Mathiske
 */
public enum Endianness {

    LITTLE {
        @Override
        public short readShort(InputStream stream) throws IOException {
            final int low = readByte(stream) & 0xff;
            final int high = readByte(stream);
            return (short) ((high << 8) | low);
        }

        @Override
        public int readInt(InputStream stream) throws IOException {
            final int low = readShort(stream) & 0xffff;
            final int high = readShort(stream);
            return (high << 16) | low;
        }

        @Override
        public long readLong(InputStream stream) throws IOException {
            final long low = readInt(stream) & 0xffffffffL;
            final long high = readInt(stream);
            return (high << 32) | low;
        }

      @Override
        public byte[] toBytes(int value) {
            int val = value;
            final byte[] bytes = new byte[4];
            bytes[0] = (byte) (val & 0xff);
            val >>= 8;
            bytes[1] = (byte) (val & 0xff);
            val >>= 8;
            bytes[2] = (byte) (val & 0xff);
            val >>= 8;
            bytes[3] = (byte) (val & 0xff);
            return bytes;
        }

    },
    BIG {
        @Override
        public short readShort(InputStream stream) throws IOException {
            final int high = readByte(stream);
            final int low = readByte(stream) & 0xff;
            return (short) ((high << 8) | low);
        }

        @Override
        public int readInt(InputStream stream) throws IOException {
            final int high = readShort(stream);
            final int low = readShort(stream) & 0xffff;
            return (high << 16) | low;
        }

        @Override
        public long readLong(InputStream stream) throws IOException {
            final long high = readInt(stream);
            final long low = readInt(stream) & 0xffffffffL;
            return (high << 32) | low;
        }

      @Override
        public byte[] toBytes(int value) {
            int val = value;
            final byte[] bytes = new byte[4];
            bytes[3] = (byte) (val & 0xff);
            val >>= 8;
            bytes[2] = (byte) (val & 0xff);
            val >>= 8;
            bytes[1] = (byte) (val & 0xff);
            val >>= 8;
            bytes[0] = (byte) (val & 0xff);
            return bytes;
        }

    };

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public byte readByte(InputStream stream) throws IOException {
        final int result = stream.read();
        if (result < 0) {
            throw new IOException();
        }
        return (byte) result;
    }

    public abstract short readShort(InputStream stream) throws IOException;

    public abstract int readInt(InputStream stream) throws IOException;

    public abstract long readLong(InputStream stream) throws IOException;

  public abstract byte[] toBytes(int value);

}

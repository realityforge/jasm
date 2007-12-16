/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.lang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
        public void writeShort(OutputStream stream, short value) throws IOException {
            short val = value;
            stream.write(val & 0xff);
            val >>= 8;
            stream.write(val & 0xff);
        }

        @Override
        public void writeInt(OutputStream stream, int value) throws IOException {
            int val = value;
            stream.write(val & 0xff);
            val >>= 8;
            stream.write(val & 0xff);
            val >>= 8;
            stream.write(val & 0xff);
            val >>= 8;
            stream.write(val & 0xff);
        }

        @Override
        public void writeLong(OutputStream stream, long value) throws IOException {
            long val = value;
            stream.write((int) val & 0xff);
            val >>= 8;
            stream.write((int) val & 0xff);
            val >>= 8;
            stream.write((int) val & 0xff);
            val >>= 8;
            stream.write((int) val & 0xff);
            val >>= 8;
            stream.write((int) val & 0xff);
            val >>= 8;
            stream.write((int) val & 0xff);
            val >>= 8;
            stream.write((int) val & 0xff);
            val >>= 8;
            stream.write((int) val & 0xff);
        }

        @Override
        public byte[] toBytes(short value) {
            short val = value;
            final byte[] bytes = new byte[2];
            bytes[0] = (byte) (val & 0xff);
            val >>= 8;
            bytes[1] = (byte) (val & 0xff);
            return bytes;
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

        @Override
        public byte[] toBytes(long value) {
            long val = value;
            final byte[] bytes = new byte[8];
            bytes[0] = (byte) (val & 0xff);
            val >>= 8;
            bytes[1] = (byte) (val & 0xff);
            val >>= 8;
            bytes[2] = (byte) (val & 0xff);
            val >>= 8;
            bytes[3] = (byte) (val & 0xff);
            val >>= 8;
            bytes[4] = (byte) (val & 0xff);
            val >>= 8;
            bytes[5] = (byte) (val & 0xff);
            val >>= 8;
            bytes[6] = (byte) (val & 0xff);
            val >>= 8;
            bytes[7] = (byte) (val & 0xff);
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
        public void writeShort(OutputStream stream, short value) throws IOException {
            stream.write((value >> 8) & 0xff);
            stream.write(value & 0xff);
        }

        @Override
        public void writeInt(OutputStream stream, int value) throws IOException {
            stream.write((value >> 24) & 0xff);
            stream.write((value >> 16) & 0xff);
            stream.write((value >> 8) & 0xff);
            stream.write(value & 0xff);
        }

        @Override
        public void writeLong(OutputStream stream, long value) throws IOException {
            stream.write((int) (value >> 56) & 0xff);
            stream.write((int) (value >> 48) & 0xff);
            stream.write((int) (value >> 40) & 0xff);
            stream.write((int) (value >> 32) & 0xff);
            stream.write((int) (value >> 24) & 0xff);
            stream.write((int) (value >> 16) & 0xff);
            stream.write((int) (value >> 8) & 0xff);
            stream.write((int) value & 0xff);
        }

        @Override
        public byte[] toBytes(short value) {
            short val = value;
            final byte[] bytes = new byte[2];
            bytes[1] = (byte) (val & 0xff);
            val >>= 8;
            bytes[0] = (byte) (val & 0xff);
            return bytes;
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

        @Override
        public byte[] toBytes(long value) {
            long val = value;
            final byte[] bytes = new byte[8];
            bytes[7] = (byte) (val & 0xff);
            val >>= 8;
            bytes[6] = (byte) (val & 0xff);
            val >>= 8;
            bytes[5] = (byte) (val & 0xff);
            val >>= 8;
            bytes[4] = (byte) (val & 0xff);
            val >>= 8;
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

    public abstract void writeShort(OutputStream stream, short value) throws IOException;

    public abstract void writeInt(OutputStream stream, int value) throws IOException;

    public abstract void writeLong(OutputStream stream, long value) throws IOException;

    public byte[] toBytes(byte value) {
        final byte[] bytes = new byte[1];
        bytes[0] = value;
        return bytes;
    }

    public abstract byte[] toBytes(short value);

    public abstract byte[] toBytes(int value);

    public abstract byte[] toBytes(long value);
}

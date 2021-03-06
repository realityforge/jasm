/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import java.io.IOException;
import java.io.InputStream;

public class EndianUtil {
  public static short readLEShort(InputStream stream) throws IOException {
    final int low = readByte(stream) & 0xff;
    final int high = readByte(stream);
    return (short) ((high << 8) | low);
  }

  public static int readLEInt(InputStream stream) throws IOException {
    final int low = readLEShort(stream) & 0xffff;
    final int high = readLEShort(stream);
    return (high << 16) | low;
  }

  public static long readLELong(InputStream stream) throws IOException {
    final long low = readLEInt(stream) & 0xffffffffL;
    final long high = readLEInt(stream);
    return (high << 32) | low;
  }

  public static short readBEShort(InputStream stream) throws IOException {
    final int high = readByte(stream);
    final int low = readByte(stream) & 0xff;
    return (short) ((high << 8) | low);
  }

  public static int readBEInt(InputStream stream) throws IOException {
    final int high = readBEShort(stream);
    final int low = readBEShort(stream) & 0xffff;
    return (high << 16) | low;
  }

  public static long readBELong(InputStream stream) throws IOException {
    final long high = readBEInt(stream);
    final long low = readBEInt(stream) & 0xffffffffL;
    return (high << 32) | low;
  }

  public static byte readByte(InputStream stream) throws IOException {
    final int result = stream.read();
    if (result < 0) {
      throw new IOException();
    }
    return (byte) result;
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

public final class HexUtil {

  public static String toHexLiteral(long value) {
    return String.format("0x%016X", value);
  }

  public static String toHexLiteral(int value) {
    return String.format("0x%08X", value);
  }

  public static String toHexLiteral(byte value) {
    return String.format("0x%02X", value);
  }
}

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
}

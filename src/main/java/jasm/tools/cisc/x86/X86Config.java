/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

public class X86Config {
  /** Whether to support 16 bit addressing. */
  private static boolean c_are16BitAddressesSupported;
  /** Whether to support 16 bit addressing. */
  private static boolean c_are16BitOffsetsSupported;

  public static boolean are16BitAddressesSupported() {
    return c_are16BitAddressesSupported;
  }

  public static void support16BitAddresses() {
    c_are16BitAddressesSupported = true;
  }

  public static boolean are16BitOffsetsSupported() {
    return c_are16BitOffsetsSupported;
  }

  public static void support16BitOffsets() {
    c_are16BitOffsetsSupported = true;
  }
}

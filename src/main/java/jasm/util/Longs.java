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
 * Additonal methods that one might want in java.lang.Long.
 */
public final class Longs {
  public static int numberOfEffectiveSignedBits(long signed) {
    if (signed >= 0) {
      return 65 - Long.numberOfLeadingZeros(signed);
    }
    return 65 - Long.numberOfLeadingZeros(~signed);
  }

  public static int numberOfEffectiveUnsignedBits(long unsigned) {
    return 64 - Long.numberOfLeadingZeros(unsigned);
  }

}

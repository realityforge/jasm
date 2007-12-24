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
 * Additonal methods that one might want in java.lang.Integer
 * and int array stuff.
 */
public final class Ints {
  public static int numberOfEffectiveSignedBits(int signed) {
    if (signed >= 0) {
      return 33 - Integer.numberOfLeadingZeros(signed);
    }
    return 33 - Integer.numberOfLeadingZeros(~signed);
  }

  public static int numberOfEffectiveUnsignedBits(int unsigned) {
    return 32 - Integer.numberOfLeadingZeros(unsigned);
  }
}

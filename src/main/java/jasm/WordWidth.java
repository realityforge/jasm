/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import jasm.util.Ints;
import jasm.util.Longs;

/**
 * A word width value describes many bits there are in a machine word.
 *
 * @author Bernd Mathiske
 */
public enum WordWidth {

  BITS_8(8, byte.class),
  BITS_16(16, short.class),
  BITS_32(32, int.class),
  BITS_64(64, long.class);

  private final int _nBits;
  private final Class _canonicalPrimitiveType;

  private WordWidth(int nBits, Class canonicalPrimitiveType) {
    _nBits = nBits;
    _canonicalPrimitiveType = canonicalPrimitiveType;
  }

  public final int numberOfBits() {
    return _nBits;
  }

  public final int numberOfBytes() {
    return _nBits / 8;
  }

  public Class canonicalPrimitiveType() {
    return _canonicalPrimitiveType;
  }

  public boolean lessThan(WordWidth other) {
    return numberOfBits() < other.numberOfBits();
  }

  public boolean greaterThan(WordWidth other) {
    return numberOfBits() > other.numberOfBits();
  }

  public boolean greaterEqual(WordWidth other) {
    return numberOfBits() >= other.numberOfBits();
  }

  @Override
  public String toString() {
    return Integer.toString(_nBits);
  }

  public static WordWidth fromInt(int wordWidth) {
    if (wordWidth <= 8) {
      return WordWidth.BITS_8;
    }
    if (wordWidth <= 16) {
      return WordWidth.BITS_16;
    }
    if (wordWidth <= 32) {
      return WordWidth.BITS_32;
    }
    return WordWidth.BITS_64;
  }

  /**
   * @return which word width is minimally required to represent all the non-one bits in the signed argument, and a sign bit
   */
  public static WordWidth signedEffective(int signed) {
    return fromInt(Ints.numberOfEffectiveSignedBits(signed));
  }

  /**
   * @return which word width is minimally required to represent all the non-zero bits in the unsigned argument
   */
  public static WordWidth unsignedEffective(int unsigned) {
    return fromInt(Ints.numberOfEffectiveUnsignedBits(unsigned));
  }

  /**
   * @return which word width is minimally required to represent all the non-one bits in the signed argument, and a sign bit
   */
  public static WordWidth signedEffective(long signed) {
    return fromInt(Longs.numberOfEffectiveSignedBits(signed));
  }

  /**
   * @return which word width is minimally required to represent all the non-zero bits in the unsigned argument
   */
  public static WordWidth unsignedEffective(long unsigned) {
    return fromInt(Longs.numberOfEffectiveUnsignedBits(unsigned));
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.bitRange;

/**
 * A range of bits that contributes to a field's value but does not occupy any bit
 * positions in an instruction. The implicit bits are 0. This type of bit range
 * is typically used to represent the low-order bits for a field value's that is
 * always modulo {@code n} where {@code n > 1}. That is, an aligned value.
 */
public final class OmittedBitRange extends ContiguousBitRange {

  private int _width;

  OmittedBitRange(int width) {
    super();
    _width = width;
    assert width > 0;
  }

  @Override
  public final int width() {
    return _width;
  }

  @Override
  public final int encodedWidth() {
    return 0;
  }

  @Override
  public final BitRange move(boolean left, int bits) {
    return this;
  }

  /* Accessing */

  @Override
  public final int instructionMask() {
    return 0;
  }

  @Override
  public final int numberOfLessSignificantBits() {
    return 32;
  }

  @Override
  public final boolean equals(Object other) {
    if (!(other instanceof OmittedBitRange)) {
      throw new Error("Invalid argument type\n");
    }
    final OmittedBitRange omittedBitRange = (OmittedBitRange) other;
    return _width == omittedBitRange._width;
  }

  @Override
  public final int hashCode() {
    return _width;
  }

  /* Extracting */
  @Override
  public final int extractSignedInt(int syllable) {
    return 0;
  }

  @Override
  public final int extractUnsignedInt(int syllable) {
    return 0;
  }

  /* Inserting */
  @Override
  public final int assembleUncheckedSignedInt(int signedInt) {
    return 0;
  }

  @Override
  public final int assembleUncheckedUnsignedInt(int unsignedInt) {
    return 0;
  }

  @Override
  public final String encodingString(String value, boolean signed, boolean checked) {
    return "";
  }

  @Override
  public final String toString() {
    return "omit" + _width;
  }
}

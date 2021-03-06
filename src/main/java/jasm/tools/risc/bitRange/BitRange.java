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
 * A {@code BitRange} is a specification of how a field's value is encoded in the
 * bit positions in an instruction. The bit positions are not necessarily contiguous.
 * In addition, one or more implicit bits for a field's value can be specified with an
 * {@link OmittedBitRange}.
 */
public abstract class BitRange {

  /**
   * Creates a bit range from {@code bits}, a series of from-to pairs (inclusive) or negative numbers.
   * For example, if {@code bits} is the integer array {@code {2, 4, 30, 31, -2, 18, 18}} then
   * the field encodes an 8 bit value where bits 7:5 of the value are encoded in bit positions
   * 2:4 of the instruction, bits 4:3 of the value are encoded in bit positions 30:31 of the instruction,
   * bits 2:1 of the value are both 0 and bit 0 of the value is encoded in bit position 18 of the instruction.
   * This bitrange has a {@link #width width} of 8 and an {@link #encodedWidth encoded width} of 6.
   *
   * @param bits  the bit range specification
   * @param order how contiguous bit ranges are specified in the relevant architecture manual
   */
  public static BitRange create(int[] bits, BitRangeOrder order) {
    if (bits.length == 2) {
      final int first = bits[0];
      final int last = bits[1];
      return order.createSimpleBitRange(first, last);
    } else if (bits.length > 2) {
      final CompoundBitRange compoundBitRange = new CompoundBitRange();
      int i = 0;
      while (i < bits.length) {
        final int first = bits[i];
        i++;
        if (first >= 0) {
          final int last = bits[i];
          i++;
          compoundBitRange.add(order.createSimpleBitRange(first, last));
        } else {
          compoundBitRange.add(new OmittedBitRange(-first));
        }
      }
      return compoundBitRange;
    } else if (bits.length == 1) {
      final int omittedWidth = bits[0];
      if (omittedWidth < 0) {
        return new OmittedBitRange(-omittedWidth);
      }
      // else this is an error; fall through
    }
    throw new IllegalStateException("invalid bit range");
  }

  /**
   * @return the number of bits required to represent the range of values represented by the
   *         field associated with this bit range
   */
  public abstract int width();

  /**
   * @return the number of bits required to encode the range of values represented by the
   *         field associated with this bit range (which may be less than {@link #width}
   *         if the range includes an {@link OmittedBitRange})
   */
  public abstract int encodedWidth();

  /** @return the number of bits that would be less significant than those specified by this bit range */
  public abstract int numberOfLessSignificantBits();

  /*
  * @return a mask that expresses this bit range's mere width, indicating a value range for operands
  */
  public final int valueMask() {
    final int width = width();
    if (width == 32) {
      return ~0;
    }
    return (1 << width) - 1;
  }

  /** @return a mask with the bits of this range set to 1 in the actually addressed bit positions */
  public abstract int instructionMask();

  @Override
  public abstract boolean equals(Object other);

  @Override
  public abstract int hashCode();

  public abstract int extractSignedInt(int instruction);

  public abstract int extractUnsignedInt(int instruction);

  public abstract int assembleUncheckedSignedInt(int signedInt);

  public abstract int assembleUncheckedUnsignedInt(int unsignedInt);

  /**
   * Gets the Java source code to encode {@code value} into the field represented by this bit range.
   *
   * @param value   the value to be encoded
   * @param signed  specifies if the value is signed
   * @param checked specifies if {@code value} is guaranteed to be within the valid range of values for this bit range
   *                (and therefore does not require masking)
   * @return the Java source code to encode {@code value} into the field represented by this bit range
   */
  public abstract String encodingString(String value, boolean signed, boolean checked);

  public abstract BitRange move(boolean left, int bits);

  protected final void checkRangeOfSignedInt(int signedInt) throws IllegalArgumentException {
    final int width = width();
    final int mostNegative = -1 << (width - 1);
    final int tooPositive = 1 << (width - 1);

    if (signedInt < mostNegative) {
      throw new IllegalArgumentException(Integer.toHexString(signedInt) + " < " + Integer.toHexString(mostNegative) + " and so is too negative to fit in a signed " + width + "-bit bit-range");
    }
    if (signedInt >= tooPositive) {
      throw new IllegalArgumentException(Integer.toHexString(signedInt) + " >= " + Integer.toHexString(tooPositive) + " and so is too positive to fit in a signed " + width + "-bit bit-range");
    }
  }

  protected final void checkRangeOfUnsignedInt(int unsignedInt) throws IllegalArgumentException {
    if (width() < 32 && unsignedInt < 0) {
      throw new IllegalArgumentException(Integer.toHexString(unsignedInt) + " is negative and so cannot fit in an unsigned " + width() + "-bit bit-range");
    }
    if (unsignedInt <= valueMask()) {
      return;
    }
    throw new IllegalArgumentException(Integer.toHexString(unsignedInt) + " > " + Integer.toHexString(valueMask()) + " and so is too positive to fit in an unsigned " + width() + "-bit bit-range");
  }

  public final int assembleSignedInt(int signedInt) throws IllegalArgumentException {
    checkRangeOfSignedInt(signedInt);
    return assembleUncheckedSignedInt(signedInt);
  }

  public final int assembleUnsignedInt(int unsignedInt) throws IllegalArgumentException {
    checkRangeOfUnsignedInt(unsignedInt);
    return assembleUncheckedUnsignedInt(unsignedInt);
  }

}

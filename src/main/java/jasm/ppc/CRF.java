/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc;

import jasm.EnumerableArgument;
import jasm.SymbolSet;

/**
 * The constants denoting the eight 4-bit fields into which the 32-bit Condition Register
 * is logically partitioned.
 */
public enum CRF implements EnumerableArgument {

  CR0, CR1, CR2, CR3, CR4, CR5, CR6, CR7;
  /** Index of the bit in a 4-bit Condition Register field indicating a <i>less than</i> condition. */
  public static final int LT = 0;

  /** Index of the bit in a 4-bit Condition Register field indicating a <i>greater than</i> condition. */
  public static final int GT = 1;

  /** Index of the bit in a 4-bit Condition Register field indicating an <i>equal</i> condition. */
  public static final int EQ = 2;

  /** Index of the bit in a 4-bit Condition Register field indicating a <i>summary overflow</i> condition. */
  public static final int SO = 3;

  /** Index of the bit in a 4-bit Condition Register field indicating an <i>unordered (after floating-point comparison)</i> condition. */
  public static final int UN = 3;

  public static final SymbolSet<CRF> SYMBOLS = SymbolSet.fromEnum(CRF.class);

  /** Determines if a mask of bits only selects one of the 8 condition register fields. */
  public static boolean isExactlyOneCRFSelected(int mask) {
    return (mask & (mask - 1)) == 0 && mask > 0 && mask <= 128;
  }

  public int value() {
    return ordinal();
  }

  public long asLong() {
    return value();
  }

  public String externalValue() {
    return Integer.toString(ordinal());
  }

  public String disassembledValue() {
    return externalValue();
  }

  /**
   * Given the index of a bit within this 4-bit field, returns the index of the same bit
   * in the 32-bit Condition Register.
   *
   * @throws IllegalArgumentException if n is not between 0 and 3 inclusive
   */
  private int bitFor(int n) {
    if (n < 0 || n > 3) {
      throw new IllegalArgumentException("bit specifier must be between 0 and 3");
    }
    return ordinal() * 4 + n;
  }

  /** @return the index of the bit within the 32-bit Condition Register corresponding to the <i>less than</i> bit in this Condition Register field */
  public int lt() {
    return bitFor(LT);
  }

  /** @return the index of the bit within the 32-bit Condition Register corresponding to the <i>greater than</i> bit in this Condition Register field */
  public int gt() {
    return bitFor(GT);
  }

  /** @return the index of the bit within the 32-bit Condition Register corresponding to the <i>equal</i> bit in this Condition Register field */
  public int eq() {
    return bitFor(EQ);
  }

  /** @return the index of the bit within the 32-bit Condition Register corresponding to the <i>summary overflow</i> bit in this Condition Register field */
  public int so() {
    return bitFor(SO);
  }

  /** @return the index of the bit within the 32-bit Condition Register corresponding to the <i>unordered (after floating-point comparison)</i> bit in this Condition Register field */
  public int un() {
    return bitFor(UN);
  }
}

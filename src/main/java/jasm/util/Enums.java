/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import jasm.util.lang.ArrayUtil;
import jasm.util.lang.StaticLoophole;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/**
 * Additional dealings with Enum types.
 *
 * @author Bernd Mathiske
 */
public final class Enums {
  /**
   * A "power sequence" is like a "power set" (the set of all possible subsets),
   * but with Set replaced by Sequence, using "natural" ordering.
   * Each sequence representing a subset is ordered according to ascending enum ordinals.
   * The sequence of sequences is ordered as if sorting an array of integers derived from enum bit sets.
   *
   * For example, "powerSequence(Enum_Type.class).get(11)",
   * i.e. querying a power sequence with index 11 (having bits 1, 2 and 8 set)
   * will return the sequence containing the enum values with the ordinals 1, 2 and 8, in that order.
   */
  public static <Enum_Type extends Enum<Enum_Type>> List<List<Enum_Type>> powerSequence(Class<Enum_Type> enumType) {
    final EnumSet<Enum_Type> values = EnumSet.allOf(enumType);
    final int nSubSets = (int) Math.pow(values.size(), 2);
    final List<Enum_Type>[] results = ArrayUtil.create(List.class, nSubSets);
    for (int subSetIndex = 0; subSetIndex < nSubSets; subSetIndex++) {
      final Object[] subSet = new Object[Integer.bitCount(subSetIndex)];
      int i = 0;
      for (Enum_Type value : values) {
        if ((subSetIndex & (1 << value.ordinal())) != 0) {
          subSet[i] = value;
          i++;
        }
      }
      results[subSetIndex] = StaticLoophole.cast( Arrays.asList(subSet) );
    }
    return Arrays.asList(results);
  }

  /**
   * @return the index into the "power sequence" of the enum set's Enum type that corresponds to the given enum set
   *
   * @see #powerSequence(Class)
   */
  public static <Enum_Type extends Enum<Enum_Type>> int powerSequenceIndex(EnumSet<Enum_Type> enumSet) {
    int result = 0;
    for (Enum_Type value : enumSet) {
      result |= 1 << value.ordinal();
    }
    return result;
  }
}

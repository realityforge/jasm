/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import java.util.EnumSet;
import com.sun.max.collect.Sequence;
import com.sun.max.collect.MutableSequence;
import com.sun.max.collect.ArraySequence;

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
    public static <Enum_Type extends Enum<Enum_Type>> Sequence<Sequence<Enum_Type>> powerSequence(Class<Enum_Type> enumType) {
        final EnumSet<Enum_Type> values = EnumSet.allOf(enumType);
        final int nSubSets = (int) Math.pow(values.size(), 2);
        final MutableSequence<Sequence<Enum_Type>> result = new ArraySequence<Sequence<Enum_Type>>(nSubSets);
        for (int subSetIndex = 0; subSetIndex < nSubSets; subSetIndex++) {
            final MutableSequence<Enum_Type> subSet = new ArraySequence<Enum_Type>(Integer.bitCount(subSetIndex));
            result.set(subSetIndex, subSet);
            int i = 0;
            for (Enum_Type value : values) {
                if ((subSetIndex & (1 << value.ordinal())) != 0) {
                    subSet.set(i, value);
                    i++;
                }
            }
        }
        return result;
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

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import java.util.EnumSet;

/**
 * Additional dealings with Enum types.
 *
 * @author Bernd Mathiske
 */
public final class Enums {

    private Enums() {
    }

    public static String fullName(Enum e) {
        return e.getClass().getCanonicalName() + "." + e.name();
    }

    public static <Enum_Type extends Enum<Enum_Type>> Enum_Type fromString(final Class<Enum_Type> enumClass, String name) {
        for (Enum_Type enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.name().equals(name)) {
                return enumConstant;
            }
        }
        return null;
    }

    /**
     * A "power sequence" is like a "power set" (the set of all possible subsets),
     * but with Set replaced by Sequence, using "natural" ordering.
     * Each sequence representing a subset is ordered according to ascending enum ordinals.
     * The sequence of sequences is ordered as if sorting an array of integers derived from enum bit sets.
     *
     * For example, "powerSequence(Enum_Type.class).get(11)",
     * i.e. querying a power sequence with index 11 (having bits 1, 2 and 8 set)
     * will return the sequence containing the enum values with the ordinals 1, 2 and 8, in that order.
     *
     * @see #powerSequenceIndex(Enum)
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

    public static int powerSequenceIndex(Enum value) {
        return 1 << value.ordinal();
    }

    /**
     * Test whether the given constant is among the allowed constants.
     * If so, return the given constant, otherwise return the first allowed constant.
     * If no constant is allowed return null.
     */
    public static <Enum_Type extends Enum<Enum_Type>> Enum_Type constrain(Enum_Type constant, Enum_Type... allowedConstants) {
        if (allowedConstants.length == 0) {
            return null;
        }
        for (Enum_Type e : allowedConstants) {
            if (e == constant) {
                return constant;
            }
        }
        return allowedConstants[0];
    }
}

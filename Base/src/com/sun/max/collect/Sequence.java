/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import java.util.Iterator;

/**
 * A Sequence presents an immutable view of a linear collection.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public interface Sequence<Element_Type> extends Iterable<Element_Type>, Cloneable {

    /**
     * Gets the number of elements in this sequence.
     */
    int length();

    /**
     * Determines if this sequence is empty.
     */
    boolean isEmpty();

    /**
     * Gets the element from this sequence located at a given index.
     *
     * @throws IndexOutOfBoundsException if {@code 0 < index || index >= length()}
     */
    Element_Type get(int index);

    /**
     * Gets the first element from this sequence.
     *
     * @throws IndexOutOfBoundsException if this sequence is {@linkplain #isEmpty() empty}
     */
    Element_Type first();

    /**
     * Gets the lasst element from this sequence.
     *
     * @throws IndexOutOfBoundsException if this sequence is {@linkplain #isEmpty() empty}
     */
    Element_Type last();

    /**
     * Gets an iterator over the elements in this sequence.
     */
    Iterator<Element_Type> iterator();

    Sequence<Element_Type> clone();

    public final class Static {

        /**
         * Returns a canonical object representing the empty sequence of a given type.
         */
        public static <Element_Type> Sequence<Element_Type> empty() {
            return new ArraySequence<Element_Type>(0);
        }

        /**
         * Returns true if {@code sequence} contains an element identical to {@code value}. More formally, returns true
         * if and only if {@code sequence} contains at least one element {@code e} such that
         * {@code (value == e)}.
         */
        public static boolean containsIdentical(Sequence sequence, Object value) {
            for (Object element : sequence) {
                if (element == value) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Returns true if {@code sequence} contains an element equal to {@code value}. More formally, returns true
         * if and only if {@code sequence} contains at least one element {@code e} such that
         * {@code (value == null ? e == null : value.equals(e))}.
         */
        public static boolean containsEqual(Sequence sequence, Object value) {
            for (Object element : sequence) {
                if (element.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Returns the index in {@code sequence} of the first occurrence identical to {@code value}, or -1 if
         * {@code sequence} does not contain {@code value}. More formally, returns the lowest index
         * {@code i} such that {@code (sequence.get(i) == value)}, or -1 if there is no such index.
         */
        public static int indexOfIdentical(Sequence sequence, Object value) {
            int i = 0;
            for (Object element : sequence) {
                if (element == value) {
                    return i;
                }
                ++i;
            }
            return -1;
        }

        public static <Element_Type> Element_Type[] toArray(Sequence<? extends Element_Type> sequence, Class<Element_Type> elementType) {
            final Element_Type[] array = com.sun.max.lang.Arrays.create(elementType, sequence.length());
            for (int i = 0; i < sequence.length(); i++) {
                array[i] = sequence.get(i);
            }
            return array;
        }

        /**
         * Extracts the elements from a given sequence that are {@linkplain Class#isInstance(Object) instances of} a given class
         * and returns them in a new sequence.
         */
        public static <Element_Type, Sub_Type extends Element_Type> AppendableSequence<Sub_Type> filter(Iterable<Element_Type> sequence, Class<Sub_Type> subType) {
            final AppendableSequence<Sub_Type> result = new ArrayListSequence<Sub_Type>();
            for (Element_Type element : sequence) {
                if (subType.isInstance(element)) {
                    result.append(subType.cast(element));
                }
            }
            return result;
        }
    }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.collect;

import com.sun.max.lang.StaticLoophole;
import com.sun.max.util.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    /**
     * Creates a transformed version of this sequence where each element in the returned sequence
     * is the result of applying a {@linkplain MapFunction transformation} to the corresponding
     * element in this sequence.
     *
     * @param <To_Type>  the type of the elements in the returned sequence
     * @param toType     the type of the elements in the returned sequence
     * @param mapFunction the trnasformation function to apply to each element of this sequence
     */
    <To_Type> Sequence<To_Type> map(Class<To_Type> toType, MapFunction<Element_Type, To_Type> mapFunction);

    public final class Static {

        private Static() {
        }

        private static final Sequence<Object> EMPTY = new ArraySequence<Object>(0);

        /**
         * Returns a canonical object representing the empty sequence of a given type.
         */
        public static <Element_Type> Sequence<Element_Type> empty(Class<Element_Type> elementType) {
            final Class<Sequence<Element_Type>> sequenceType = null;
            return StaticLoophole.cast(sequenceType, EMPTY);
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
         * Returns the index in {@code sequence} of the first occurrence equal to {@code value}, or -1 if
         * {@code sequence} does not contain {@code value}. More formally, returns the lowest index
         * {@code i} such that {@code (value == null ? sequence.get(i) == null : value.equals(sequence.get(i)))},
         * or -1 if there is no such index.
         */
        public static int indexOfEqual(Sequence sequence, Object value) {
            int i = 0;
            for (Object element : sequence) {
                if (element.equals(value)) {
                    return i;
                }
                ++i;
            }
            return -1;
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

        /**
         * Returns a string representation of the contents of the specified iterable.
         * Adjacent elements are separated by the specified separator. Elements are
         * converted to strings by {@link String#valueOf(Object)}.
         *
         * @param iterable   the iterable whose string representation to return
         * @param separator  the separator to use
         * @param toStringFunction function that converts {@code Element_Type} to {@code String}. If
         *                   this parameter is {@code null}, then the {@link Object#toString} method
         *                   will be used
         * @return a string representation of {@code sequence}
         * @throws NullPointerException if {@code sequence} or {@code separator} is null
         */
        public static <Element_Type> String toString(Iterable<? extends Element_Type> iterable, MapFunction<Element_Type, String> toStringFunction, String separator) {
            if (iterable == null || separator == null) {
                throw new NullPointerException();
            }

            final Iterator<? extends Element_Type> iterator = iterable.iterator();
            if (!iterator.hasNext()) {
                return "";
            }
            boolean hasNext = iterator.hasNext();
            final StringBuilder buf = new StringBuilder();
            while (hasNext) {
                final Element_Type element = iterator.next();
                final String string = toStringFunction == null ? String.valueOf(element) : toStringFunction.map(element);
                buf.append(element == iterable ? "(this Iterable)" : string);
                hasNext = iterator.hasNext();
                if (hasNext) {
                    buf.append(separator);
                }
            }

            return buf.toString();
        }

        /**
         * Filters an iterable with a given predicate and return a sequence with the elments that matched the predicate.
         * If the returned sequence will only be iterated over, consider using a {@link FilterIterator} instead.
         */
        public static <Element_Type> AppendableSequence<Element_Type> filter(Iterable<Element_Type> sequence, Predicate<? super Element_Type> predicate) {
            final AppendableSequence<Element_Type> result = new ArrayListSequence<Element_Type>();
            for (Element_Type element : sequence) {
                if (predicate.evaluate(element)) {
                    result.append(element);
                }
            }
            return result;
        }

        public static <Element_Type> Sequence<Element_Type> filterNonNull(Sequence<Element_Type> sequence) {
            return filter(sequence, new Predicate<Element_Type>() {
                public boolean evaluate(Element_Type element) {
                    return element != null;
                }
            });
        }

        public static <Element_Type> Sequence<Element_Type> reverse(Sequence<Element_Type> sequence) {
            int i = sequence.length();
            final MutableSequence<Element_Type> result = new ArraySequence<Element_Type>(i);
            for (Element_Type element : sequence) {
                i--;
                result.set(i, element);
            }
            return result;
        }

        public static <Element_Type> Sequence<Element_Type> sort(Sequence<Element_Type> sequence, Class<Element_Type> elementType) {
            final Element_Type[] array = toArray(sequence, elementType);
            Arrays.sort(array);
            return new ArraySequence<Element_Type>(array);
        }

        public static <Element_Type> List<Element_Type> toArrayList(Sequence<Element_Type> sequence) {
            final List<Element_Type> arrayList = new ArrayList<Element_Type>(sequence.length());
            for (Element_Type element : sequence) {
                arrayList.add(element);
            }
            return arrayList;
        }

        public static <Element_Type> Sequence<Element_Type> prepended(Element_Type element, Sequence<Element_Type> sequence) {
            final MutableSequence<Element_Type> result = new ArraySequence<Element_Type>(1 + sequence.length());
            MutableSequence.Static.copy(sequence, result, 1);
            result.set(0, element);
            return result;
        }

        public static <Element_Type> Sequence<Element_Type> appended(Sequence<Element_Type> sequence, Element_Type element) {
            final MutableSequence<Element_Type> result = new ArraySequence<Element_Type>(sequence.length() + 1);
            MutableSequence.Static.copy(sequence, result);
            result.set(sequence.length(), element);
            return result;
        }

    }
}

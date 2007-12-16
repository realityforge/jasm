/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.lang;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.MapFunction;
import com.sun.max.util.Predicate;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Additonal methods that one could expect in java.util.Arrays.
 *
 * @author Bernd Mathiske
 */
public final class Arrays {

    private Arrays() {

    }

    public static <Element_Type> Element_Type[] create(Class<Element_Type> elementType, int length) {
        final Object array = Array.newInstance(elementType, length);
        final Class<Element_Type[]> arrayType = null;
        return StaticLoophole.cast(arrayType, array);
    }

    public static <Element_Type> Element_Type[] fromElements(Element_Type... elements) {
        return elements;
    }

    public static <Element_Type> Element_Type[] from(Class<Element_Type> elementType, Iterable<Element_Type> elements) {
        final List<Element_Type> vector = new Vector<Element_Type>();
        for (Element_Type element : elements) {
            vector.add(element);
        }
        return vector.toArray(create(elementType, vector.size()));
    }

    public static <Element_Type> Element_Type[] from(Class<Element_Type> elementType, Element_Type[] elements) {
        final List<Element_Type> vector = new Vector<Element_Type>();
        for (Element_Type element : elements) {
            vector.add(element);
        }
        return vector.toArray(create(elementType, vector.size()));
    }

    public static <Element_Type> Iterator<Element_Type> iterator(Element_Type[] array) {
        return java.util.Arrays.asList(array).iterator();
    }

    public static <Element_Type> Iterable<Element_Type> iterable(Element_Type[] array) {
        return java.util.Arrays.asList(array);
    }

    public static <Element_Type> Collection<Element_Type> collection(Element_Type[] array) {
        return java.util.Arrays.asList(array);
    }

    public static <Element_Type> boolean equals(Element_Type[] a, Element_Type[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                if (b[i] != null) {
                    return false;
                }
            } else if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new array containing a subrange of the given array.
     *
     * @param array The array to copy from
     * @param index The index at which to start copying
     * @return A new array of the same type, containing a copy of the subrange starting at the indicated index
     */
    public static <Element_Type> Element_Type[] subArray(Element_Type[] array, int index) {
        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final int resultLength = array.length - index;
        final Object resultArray = Array.newInstance(array.getClass().getComponentType(), resultLength);
        final Class<Element_Type[]> arrayType = null;
        final Element_Type[] result = StaticLoophole.cast(arrayType, resultArray);
        System.arraycopy(array, index, result, 0, resultLength);
        return result;
    }

    public static <Element_Type> Element_Type[] subArray(Element_Type[] array, int index, int length) {
        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final Class<Element_Type[]> arrayType = null;
        final Element_Type[] result = StaticLoophole.cast(arrayType, Array.newInstance(array.getClass().getComponentType(), length));
        System.arraycopy(array, index, result, 0, length);
        return result;
    }

    /**
     * Copys the (partial) contents of one array to another array and returns the value of the destination array. This
     * is just a type-safe convenience call for {@link System#arraycopy(Object, int, Object, int, int)} that returns the
     * destination array. Invoking this method is equivalent to:
     *
     * <blockquote><pre>
     *   Arrays.copy(src, 0, dst, 0, src.length)
     * </pre></blockquote>
     *
     * @param src the array to be copied
     * @param dst the array into which the elements of {@code src} should be copied
     * @return the value of the {@code dst} parameter
     *
     * @throws  IndexOutOfBoundsException  if copying would cause access of data outside array bounds.
     * @exception  ArrayStoreException  if an element in {@code src} could not be stored into{@code dst} because of a type mismatch.
     * @exception  NullPointerException if either {@code src} or{@code dst} is {@code null}
     */
    public static <ElementSuper_Type, ElementSub_Type extends ElementSuper_Type> ElementSuper_Type[] copy(ElementSub_Type[] src, ElementSuper_Type[] dst) {
        return copy(src, 0, dst, 0, src.length);
    }

    /**
     * Copys the (partial) contents of one array to another array and returns the value of the destination array. This
     * is just a type-safe convenience call for {@link System#arraycopy(Object, int, Object, int, int)} that returns the
     * destination array.
     *
     * @param src
     *            the array to be copied
     * @param srcPos
     *            starting position in the source array
     * @param dst
     *            the array into which the elements of {@code src} should be copied
     * @param dstPos
     *            starting position in the destination data
     * @param length
     *            the number of array elements to be copied.
     * @return the value of the {@code dst} parameter
     *
     * @throws IndexOutOfBoundsException
     *             if copying would cause access of data outside array bounds.
     * @exception ArrayStoreException
     *                if an element in {@code src} could not be stored into{@code dst} because of a type mismatch.
     * @exception NullPointerException
     *                if either {@code src} or{@code dst} is {@code null}
     */
    public static <ElementSuper_Type, ElementSub_Type extends ElementSuper_Type> ElementSuper_Type[] copy(ElementSub_Type[] src, int srcPos, ElementSuper_Type[] dst, int dstPos, int length) {
        System.arraycopy(src, srcPos, dst, dstPos, length);
        return dst;
    }

    public static <Element_Type> Element_Type[] prepend(Element_Type[] array, Element_Type... additionalElements) {
        final int resultLength = additionalElements.length + array.length;
        final Class<Element_Type[]> arrayType = null;
        final Element_Type[] result = StaticLoophole.cast(arrayType, Array.newInstance(array.getClass().getComponentType(), resultLength));
        System.arraycopy(additionalElements, 0, result, 0, additionalElements.length);
        System.arraycopy(array, 0, result, additionalElements.length, array.length);
        return result;
    }

    public static <Element_Type> Element_Type[] append(Element_Type[] array, Element_Type... additionalElements) {
        final int resultLength = array.length + additionalElements.length;
        final Class<Element_Type[]> arrayType = null;
        final Element_Type[] result = StaticLoophole.cast(arrayType, Array.newInstance(array.getClass().getComponentType(), resultLength));
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(additionalElements, 0, result, array.length, additionalElements.length);
        return result;
    }

    public static <Element_Type> Element_Type[] append(Class<Element_Type> resultElementType,
            final Element_Type[] array, Element_Type... additionalElements) {
        final Element_Type[] result = create(resultElementType, array.length + additionalElements.length);
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(additionalElements, 0, result, array.length, additionalElements.length);
        return result;
    }

    public static <Element_Type> boolean contains(Element_Type[] array, Element_Type value) {
        for (Element_Type element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public static <Element_Type> int find(Element_Type[] array, Element_Type value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static <Element_Type> int countElement(Element_Type[] array, Element_Type element) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                n++;
            }
        }
        return n;
    }

    public static <Element_Type, Result_Type extends Element_Type> Result_Type[] filter(Element_Type[] array, Class<Result_Type> resultType) {
        final List<Element_Type> result = new ArrayList<Element_Type>();
        for (int i = 0; i < array.length; i++) {
            if (resultType.isInstance(array[i])) {
                result.add(array[i]);
            }
        }
        return result.toArray(create(resultType, result.size()));
    }

    public static <Element_Type> Element_Type[] filter(Element_Type[] array, Predicate<? super Element_Type> predicate) {
        final List<Element_Type> result = new ArrayList<Element_Type>();
        for (int i = 0; i < array.length; i++) {
            if (predicate.evaluate(array[i])) {
                result.add(array[i]);
            }
        }
        final Class<Element_Type[]> arrayType = null;
        final Element_Type[] space = StaticLoophole.cast(arrayType, Array.newInstance(array.getClass().getComponentType(), result.size()));
        return result.toArray(space);
    }

    public static <Element_Type> boolean verify(Element_Type[] array, Predicate<? super Element_Type> predicate) {
        for (int i = 0; i < array.length; i++) {
            if (!predicate.evaluate(array[i])) {
                return false;
            }
        }
        return true;
    }

    public static <Element_Type, Sub_Type extends Element_Type> boolean verify(Element_Type[] array, Class<Sub_Type> subType) {
        for (int i = 0; i < array.length; i++) {
            if (!subType.isInstance(array[i])) {
                return false;
            }
        }
        return true;
    }

    public static <From_Type, To_Type> To_Type[] map(From_Type[] from, Class<To_Type> toType, MapFunction<From_Type, To_Type> mapFunction) {
        final To_Type[] to = create(toType, from.length);
        for (int i = 0; i < from.length; i++) {
            to[i] = mapFunction.map(from[i]);
        }
        return to;
    }

    /**
     * Returns a string representation of the contents of the specified array.
     * Adjacent elements are separated by the specified separator. Elements are
     * converted to strings as by <tt>String.valueOf(int)</tt>.
     *
     * @param array     the array whose string representation to return
     * @param separator the separator to use
     * @return a string representation of <tt>array</tt>
     * @throws NullPointerException if {@code array} or {@code separator} is null
     */
    public static <Element_Type> String toString(Element_Type[] array, String separator) {
        if (array == null || separator == null) {
            throw new NullPointerException();
        }
        if (array.length == 0) {
            return "";
        }

        final StringBuilder buf = new StringBuilder();
        buf.append(array[0]);

        for (int i = 1; i < array.length; i++) {
            buf.append(separator);
            buf.append(array[i]);
        }

        return buf.toString();
    }

    public static <Element_Type> void mergeEqualElements(Element_Type[] array) {
        final Dictionary<Element_Type, Element_Type> lookup = new Hashtable<Element_Type, Element_Type>();
        for (int i = 0; i < array.length; i++) {
            final Element_Type element = array[i];
            if (element != null) {
                final Element_Type mergedElement = lookup.get(element);
                if (mergedElement != null) {
                    array[i] = mergedElement;
                } else {
                    lookup.put(element, element);
                    array[i] = element;
                }
            }
        }
    }

    public static Object[] flatten(Object[] array) {
        final AppendableSequence<Object> sequence = new ArrayListSequence<Object>();
        for (Object outer : array) {
            if (outer instanceof Object[]) {
                for (Object inner : flatten((Object[]) outer)) {
                    sequence.append(inner);
                }
            } else {
                sequence.append(outer);
            }
        }
        return from(Object.class, sequence);
    }
}

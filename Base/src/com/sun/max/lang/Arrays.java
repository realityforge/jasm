/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.lang;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import java.lang.reflect.Array;
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
        return StaticLoophole.cast(array);
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
        final Element_Type[] result = StaticLoophole.cast(resultArray);
        System.arraycopy(array, index, result, 0, resultLength);
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
      final List<Object> vector = new Vector<Object>();
      for (Object element : sequence) {
          vector.add(element);
      }
      return vector.toArray(create(Object.class, vector.size()));
    }
}

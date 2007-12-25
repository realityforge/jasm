/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jasm.util.StaticLoophole;
import jasm.util.ArrayUtil;

public final class CollectionUtil {
  /**
   * Returns the index in {@code list} of the first occurrence identical to {@code value}, or -1 if
   * {@code list} does not contain {@code value}. More formally, returns the lowest index
   * {@code i} such that {@code (list.get(i) == value)}, or -1 if there is no such index.
   */
  public static int indexOfIdentical(List list, Object value) {
    int i = 0;
    for (Object element : list) {
      if (element == value) {
        return i;
      }
      ++i;
    }
    return -1;
  }

  public static <Element_Type> Element_Type[] toArray(List<? extends Element_Type> sequence, Class<Element_Type> elementType) {
    final Element_Type[] array = StaticLoophole.cast(ArrayUtil.create(elementType, sequence.size()));
    for (int i = 0; i < array.length; i++) {
      array[i] = sequence.get(i);
    }
    return array;
  }

  public static <Element_Type> Set<Element_Type> hashSetFrom(Element_Type... elements) {
    return new HashSet<Element_Type>(Arrays.asList(elements));
  }
}

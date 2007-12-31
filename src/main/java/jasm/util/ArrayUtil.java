/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/** Additonal methods that one could expect in java.util.Arrays. */
public final class ArrayUtil {

  public static Object[] flatten(Object[] array) {
    final ArrayList<Object> sequence = new ArrayList<Object>();
    for (Object outer : array) {
      if (outer instanceof Object[]) {
        for (Object inner : flatten((Object[]) outer)) {
          sequence.add(inner);
        }
      } else {
        sequence.add(outer);
      }
    }
    final List<Object> vector = new Vector<Object>();
    for (Object element : sequence) {
      vector.add(element);
    }
    return vector.toArray(StaticLoophole.create(Object.class, vector.size()));
  }
}

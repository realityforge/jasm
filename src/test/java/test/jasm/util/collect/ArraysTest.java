/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.util.collect;

import jasm.util.lang.Arrays;
import junit.framework.TestCase;

/**
 * @author Bernd Mathiske
 */
public class ArraysTest extends TestCase {

  private Integer[] makeIntegerArray(int nElements) {
    final Integer[] array = new Integer[nElements];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
    if (array.length >= 3) {
      array[2] = null;
    }
    return array;
  }

  private void check_subArray(int nElements) {
    final Integer[] original = makeIntegerArray(nElements);
    final Integer[] array = makeIntegerArray(nElements);

    try {
      Arrays.subArray(array, -1);
      fail();
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      // OK
    }

    Integer[] result = Arrays.subArray(array, 0);
    assertTrue(equals(array, original));
    assertTrue(equals(result, array));

    for (int n = 1; n < array.length; n++) {
      result = Arrays.subArray(array, n);
      assertTrue(result.length == array.length - n);
      for (int i = n; i < array.length; i++) {
        if (array[i] == null) {
          assertNull(result[i - n]);
        } else {
          assertEquals(array[i], result[i - n]);
        }
      }
    }

    result = Arrays.subArray(array, array.length);
    assertTrue(result.length == 0);

    try {
      Arrays.subArray(array, array.length + 1);
      fail();
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      //expected
    }
  }

  public void test_subArray() {
    check_subArray(0);
    check_subArray(1);
    check_subArray(5);
  }

  private void check_clone(int nElements) {
    final Integer[] original = makeIntegerArray(nElements);
    final Integer[] array = makeIntegerArray(nElements);
    Integer[] dst = new Integer[array.length];
    System.arraycopy(array, 0, dst, 0, array.length);
    assertTrue(equals(array, original));
    assertTrue(equals(dst, array));
  }

  public void test_clone() {
    check_clone(0);
    check_clone(1);
    check_clone(8);
  }

  private static <Element_Type> boolean equals(Element_Type[] a, Element_Type[] b) {
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

}

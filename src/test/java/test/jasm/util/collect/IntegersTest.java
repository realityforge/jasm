/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.util.collect;

import jasm.util.Ints;
import junit.framework.TestCase;

/**
 * Tests for {@link Ints}.
 *
 * @author Hiroshi Yamauchi
 */
public class IntegersTest extends TestCase {

  public void test_roundedUp() {
    assertTrue(Ints.roundedUp(11, 4) == 12);
    assertTrue(Ints.roundedUp(0, 4) == 0);
    assertTrue(Ints.roundedUp(3, 1) == 3);
    assertTrue(Ints.roundedUp(-1, 3) == 0);
    try {
      assertTrue(Ints.roundedUp(1, 0) == 0);
      fail();
    } catch (ArithmeticException arithmeticException) {
    }
  }

  public void test_contains() {
    final int[] array = new int[10000];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
    assertTrue(!Ints.contains(array, -1));
    assertTrue(Ints.contains(array, 0));
    assertTrue(Ints.contains(array, 9999));
    assertTrue(!Ints.contains(array, 10000));
    assertTrue(!Ints.contains(array, Integer.MAX_VALUE));
  }

  public void test_append() {
    int[] array = new int[0];
    for (int i = 0; i < array.length; i++) {
      array = Ints.append(array, i);
    }
    for (int i = 0; i < array.length; i++) {
      assertTrue(array[i] == i);
    }
  }

  public void test_createRange() {
    final int[] array = Ints.createRange(0, 1000);
    assertTrue(array.length == 1001);
    assertTrue(array[0] == 0);
    assertTrue(array[array.length - 1] == 1000);
    for (int i = 0; i < array.length; i++) {
      assertTrue(array[i] == i);
    }

    final int[] array2 = Ints.createRange(-1000, 1000);
    assertTrue(array2.length == 2001);
    assertTrue(array2[0] == -1000);
    assertTrue(array2[array2.length - 1] == 1000);
    for (int i = 0; i < array2.length; i++) {
      assertTrue(array2[i] == i - 1000);
    }

    final int[] array3 = Ints.createRange(100, 1000);
    assertTrue(array3.length == 901);
    assertTrue(array3[0] == 100);
    assertTrue(array3[array3.length - 1] == 1000);
    for (int i = 0; i < array3.length; i++) {
      assertTrue(array3[i] == i + 100);
    }

    final int[] array4 = Ints.createRange(-1000, -100);
    assertTrue(array4.length == 901);
    assertTrue(array4[0] == -1000);
    assertTrue(array4[array4.length - 1] == -100);
    for (int i = 0; i < array4.length; i++) {
      assertTrue(array4[i] == i - 1000);
    }

    try {
      Ints.createRange(100, 0);
      assertTrue(false);
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    final int[] array6 = Ints.createRange(1, 1);
    assertTrue(array6.length == 1 && array6[0] == 1);
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.com.sun.max.collect;

import com.sun.max.collect.IntHashMap;
import java.util.Random;
import junit.framework.TestCase;

/**
 * Tests for {@link IntHashMap}.
 *
 * @author Bernd Mathiske
 */
public class IntHashMapTest extends TestCase {
  private static final int N = 1000;

  private final Integer[] _integers = new Integer[N];

  private void initialize() {
    for (int i = 0; i < N; i++) {
      _integers[i] = new Integer(i);
    }
  }

  private void check(IntHashMap<Object> table, int n) {
    for (int i = 0; i < n; i++) {
      final Object entry = table.get(i);
      assertTrue(entry == _integers[i]);
    }
  }

  public void test_serialPut() {
    initialize();
    final IntHashMap<Object> table = new IntHashMap<Object>();
    for (int i = 0; i < N; i++) {
      assertTrue(table.get(i) == null);
      table.put(i, _integers[i] + "");
      table.put(i, _integers[i]);
      check(table, i);
    }
  }

  public void test_randomPut() {
    initialize();
    final IntHashMap<Object> table = new IntHashMap<Object>();
    final Random random = new Random();
    final int[] keys = new int[N];
    for (int i = 0; i < N; i++) {
      int k;
      do {
        k = random.nextInt();
      } while (table.get(k) != null);
      keys[i] = k;
      table.put(k, _integers[i] + "");
      table.put(k, _integers[i]);
    }
    for (int i = 0; i < N; i++) {
      assertTrue(table.get(keys[i]) == _integers[i]);
    }
  }
}

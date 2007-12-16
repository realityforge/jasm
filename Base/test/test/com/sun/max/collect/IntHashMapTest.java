/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=9b95977e-9e0a-4d53-95f1-9c2286da3ee0*/
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

    public IntHashMapTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(IntHashMapTest.class);
    }

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
            int k = 0;
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

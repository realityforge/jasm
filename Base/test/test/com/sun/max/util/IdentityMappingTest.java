/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=003bfdff-7294-494d-ac51-7fd12c5fba0b*/
package test.com.sun.max.util;

import com.sun.max.collect.IdentityMapping;
import com.sun.max.ide.MaxTestCase;

/**
 * Tests for com.sun.max.util.IdentityMapping.
 *
 * @author Hiroshi Yamauchi
 */
public class IdentityMappingTest extends MaxTestCase {

    public IdentityMappingTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(IdentityMappingTest.class);
    }

    private static final class Key {

        private final int _id;

        private Key(int id) {
            _id = id;
        }

        public int id() {
            return _id;
        }

        @Override
        public int hashCode() {
            return _id;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Key)) {
                return false;
            }
            final Key key = (Key) other;
            return _id == key._id;
        }
    }

    private static final class Value {

        private final int _id;

        private Value(int id) {
            _id = id;
        }

        public int id() {
            return _id;
        }
    }

    public void test_basic() {
        final int num = 1;
        final IdentityMapping<Key, Value> map = new IdentityMapping<Key, Value>(Key.class, Value.class);
        final Key[] keys = new Key[num];
        final Value[] values = new Value[num];
        final Value[] values2 = new Value[num];
        for (int i = 0; i < num; i++) {
            keys[i] = new Key(i);
            values[i] = new Value(i);
            values2[i] = new Value(i * 2);
            map.put(keys[i], values[i]);
            assertTrue(map.containsKey(keys[i]));
        }
        for (int i = 0; i < num; i++) {
            assertTrue(map.containsKey(keys[i]));
            assertTrue(map.get(keys[i]) == values[i]);
        }
        assertTrue(!map.containsKey(new Key(-1)));
        for (int i = 0; i < num; i++) {
            map.put(keys[i], values[i]);
            assertTrue(map.get(keys[i]) == values[i]);
        }
        for (int i = 0; i < num; i++) {
            if ((i % 3) == 0) {
                map.put(keys[i], values2[i]);
            }
        }
        for (int i = 0; i < num; i++) {
            if ((i % 3) == 0) {
                assertTrue(map.get(keys[i]) == values2[i]);
            } else {
                assertTrue(map.get(keys[i]) == values[i]);
            }
        }
    }
}

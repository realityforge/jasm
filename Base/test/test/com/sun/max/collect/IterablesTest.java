/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a6a72968-a716-4b0b-80f9-a52ed7aed04a*/
package test.com.sun.max.collect;

import com.sun.max.annotate.Implement;
import com.sun.max.collect.Iterables;
import com.sun.max.ide.MaxTestCase;
import java.util.Enumeration;

/**
 * Tests for com.sun.max.util.Iterables.
 *
 * @author Hiroshi Yamauchi
 */
public class IterablesTest extends MaxTestCase {

    public IterablesTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(IterablesTest.class);
    }

    public void test_from() {
        final Iterable<Integer> iterable = Iterables.from(new Integer(0), new Integer(1), new Integer(2));
        int sum = 0;
        for (Integer i : iterable) {
            sum += i;
        }
        assertTrue(sum == 3);
    }

    private static final class StringEnumeration implements Enumeration<String> {
        private String[] _strings;
        private int _index;

        private StringEnumeration(String... strings) {
            _strings = strings;
            _index = 0;
        }

        @Implement(Enumeration.class)
        public boolean hasMoreElements() {
            if (_index < _strings.length) {
                return true;
            }
            return false;
        }

        @Implement(Enumeration.class)
        public String nextElement() {
            return _strings[_index++];
        }
    }

    public void test_fromEnumeration() {
        final StringEnumeration enumeration = new StringEnumeration(new String[] {"I", "am", "a", "cat"});
        final Iterable<String> iterable = Iterables.fromEnumeration(enumeration);
        String concat = "";
        for (String s : iterable) {
            concat += s;
        }
        assertTrue(concat.equals("Iamacat"));
    }

    public void test_empty() {
        final Iterable<String> iterable = Iterables.empty();
        int counter = 0;
        String concat = "";
        for (String s : iterable) {
            concat += s;
            counter++;
        }
        assertTrue(counter == 0);
    }

}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package test.com.sun.max.collect;

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

    private static final class StringEnumeration implements Enumeration<String> {
        private String[] _strings;
        private int _index;

        private StringEnumeration(String... strings) {
            _strings = strings;
            _index = 0;
        }

        public boolean hasMoreElements() {
            if (_index < _strings.length) {
                return true;
            }
            return false;
        }

        public String nextElement() {
            return _strings[_index++];
        }
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

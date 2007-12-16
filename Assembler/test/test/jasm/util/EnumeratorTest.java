/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d9fdf10c-6e11-4296-966c-35bc182bd1b0*/
package test.jasm.util;

import com.sun.max.annotate.Implement;
import com.sun.max.ide.MaxTestCase;
import jasm.util.Enumerable;
import jasm.util.Enumerator;
import jasm.util.Symbol;

/**
 * Tests for jasm.util.Enumerator.
 *
 * @author Hiroshi Yamauchi
 */
public class EnumeratorTest extends MaxTestCase {

    public EnumeratorTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(EnumeratorTest.class);
    }

    private static final class NonSuccessiveEnumerator<E extends Enum<E> & Enumerable<E>> extends Enumerator<E> {
        private NonSuccessiveEnumerator(Class<E> type) {
            super(type);
        }
    }
    private static enum NonSuccessiveEnum implements Enumerable<NonSuccessiveEnum> {
        E0(0), E100(100), E1000(1000);

        private final int _value;
        private NonSuccessiveEnum(int value) {
            _value = value;
        }
        @Implement(Symbol.class)
        public int value() {
            return _value;
        }
        @Implement(Enumerable.class)
        public Enumerator<NonSuccessiveEnum> enumerator() {
            return new NonSuccessiveEnumerator<NonSuccessiveEnum>(NonSuccessiveEnum.class);
        }
    }

    public void test_value() {
        assertTrue(NonSuccessiveEnum.E0.ordinal() == 0);
        assertTrue(NonSuccessiveEnum.E100.ordinal() == 1);
        assertTrue(NonSuccessiveEnum.E1000.ordinal() == 2);
        assertTrue(NonSuccessiveEnum.E0.value() == 0);
        assertTrue(NonSuccessiveEnum.E100.value() == 100);
        assertTrue(NonSuccessiveEnum.E1000.value() == 1000);
    }

    public void test_enumerator() {
        final Enumerator<NonSuccessiveEnum> enumerator = NonSuccessiveEnum.E0.enumerator();
        assertTrue(enumerator.type() == NonSuccessiveEnum.class);
        int sum = 0;
        for (NonSuccessiveEnum e : enumerator) {
            sum += e.value();
        }
        assertTrue(sum == 1100);
        assertTrue(enumerator.fromValue(0) == NonSuccessiveEnum.E0);
        assertTrue(enumerator.fromValue(100) == NonSuccessiveEnum.E100);
        assertTrue(enumerator.fromValue(1000) == NonSuccessiveEnum.E1000);
        assertTrue(enumerator.fromValue(1) == null);
    }
}

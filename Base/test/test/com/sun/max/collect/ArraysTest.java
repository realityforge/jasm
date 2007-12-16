/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package test.com.sun.max.collect;

import com.sun.max.ide.MaxTestCase;
import com.sun.max.lang.Arrays;

/**
 * @author Bernd Mathiske
 */
public class ArraysTest extends MaxTestCase {

    public ArraysTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(ArraysTest.class);
    }

    private Object[] makeObjectArray(int nElements) {
        final Object[] array = new Object[nElements];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Integer(i);
        }
        return array;
    }

    private Integer[] makeIntegerArray(int nElements) {
        final Integer[] array = new Integer[nElements];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Integer(i);
        }
        if (array.length >= 3) {
            array[2] = null;
        }
        return array;
    }

    private String[] makeStringArray(int nElements) {
        final String[] array = new String[nElements];
        for (int i = 0; i < array.length; i++) {
            array[i] = "string: " + i;
        }
        return array;
    }

    public void test_equals() {
        Integer[] a = makeIntegerArray(0);
        Integer[] b = makeIntegerArray(0);
        assertTrue(Arrays.equals(a, b));

        a = makeIntegerArray(1);
        b = makeIntegerArray(1);
        assertTrue(Arrays.equals(a, b));
        b[0] = new Integer(7);
        assertFalse(Arrays.equals(a, b)); // different element value

        b = makeIntegerArray(2);
        assertFalse(Arrays.equals(a, b)); // different length

        a = makeIntegerArray(5);
        b = makeIntegerArray(5);
        assertTrue(Arrays.equals(a, b));
        a[1] = null;
        assertFalse(Arrays.equals(a, b)); // null value
        b[1] = null;
        assertTrue(Arrays.equals(a, b));

        Object[] x = makeObjectArray(5);
        Object[] y = makeObjectArray(5);
        assertTrue(Arrays.equals(x, y));
        x[3] = "Hello";
        assertFalse(Arrays.equals(x, y)); // totally different value

        x = makeObjectArray(10);
        y = makeIntegerArray(10);
        assertFalse(Arrays.equals(x, y)); // y[2] == null

        x = makeIntegerArray(0);
        y = makeStringArray(0);
        assertTrue(Arrays.equals(x, y));
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
        assertTrue(Arrays.equals(array, original));
        assertTrue(Arrays.equals(result, array));

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
        final Integer[] result = Arrays.copy(array, new Integer[array.length]);
        assertTrue(Arrays.equals(array, original));
        assertTrue(Arrays.equals(result, array));
    }

    public void test_clone() {
        check_clone(0);
        check_clone(1);
        check_clone(8);
    }

}

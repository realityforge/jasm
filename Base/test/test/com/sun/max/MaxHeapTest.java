/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package test.com.sun.max;

import com.sun.max.ide.MaxTestCase;

/**
 * Helps finding out whether the JVM executing this test can populate object heaps with sizes beyond 4GB.
 * Run HotSpot with -verbose:gc to see heap numbers.
 *
 * @author Bernd Mathiske
 */
public class MaxHeapTest extends MaxTestCase {

    public MaxHeapTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(MaxHeapTest.class);
    }

    private final int _numberOfArrays = 128;
    private final int _leafLength = 1024 * 1024;

    private int[][] _objects = new int[_numberOfArrays][];

    public void test_max() {
        for (int i = 0; i < _numberOfArrays; i++) {
            _objects[i] = new int[_leafLength];
        }
    }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d0ce656f-84f1-4055-9400-68597dace0b6*/
package test.com.sun.max.util;

import com.sun.max.ide.MaxTestCase;
import com.sun.max.util.Deferrable;

/**
 * Tests for {@link Deferrable}.
 *
 * @author Hiroshi Yamauchi
 */
public class DeferrableTest extends MaxTestCase {

    public DeferrableTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(DeferrableTest.class);
    }

    private int _counter;

    public void test_immediate_run() {
        _counter = 0;
        final Deferrable.Queue queue = Deferrable.createRunning();
        new Deferrable(queue) {
            public void run() {
                _counter = 19;
            }
        };
        assertTrue(_counter == 19);
    }

    public void test_deferred_run() {
        _counter = 0;
        final Deferrable.Queue queue = Deferrable.createRunning();
        new Deferrable.Block(queue) {
            public void run() {
                assertTrue(_counter == 0);
                for (int i = 0; i < 100; i++) {
                    new Deferrable(queue) {
                        public void run() {
                            _counter++;
                        }
                    };
                }
            }
        };
        assertTrue(_counter == 100);
    }
}

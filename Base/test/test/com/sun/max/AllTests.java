/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e6360a20-9fbb-4f64-977f-e17ed56f30b6*/
package test.com.sun.max;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;

/**
 * @author Bernd Mathiske
 */
@RunWith(org.junit.runners.AllTests.class)
public final class AllTests {

    private AllTests() {

    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(AllTests.suite());
    }

    public static Test suite() {
        final TestSuite suite = new TestSuite(AllTests.class.getPackage().getName());
        //$JUnit-BEGIN$
        suite.addTest(test.com.sun.max.lang.AllTests.suite());
        suite.addTest(test.com.sun.max.util.AllTests.suite());
        suite.addTest(test.com.sun.max.collect.AllTests.suite());
        suite.addTest(test.com.sun.max.annotate.AllTests.suite());
        suite.addTest(test.com.sun.max.io.AllTests.suite());
        //$JUnit-END$
        return suite;
    }
}

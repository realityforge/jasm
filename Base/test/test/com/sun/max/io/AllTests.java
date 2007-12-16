/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=76774b4a-26fb-45a4-8be5-4010efcdaa4d*/
package test.com.sun.max.io;

import junit.framework.*;

import org.junit.runner.*;

/**
 * @author Doug Simon
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
        suite.addTestSuite(StreamsTest.class);
        //$JUnit-END$
        return suite;
    }
    
    
}

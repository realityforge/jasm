/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=99f6d7b8-88ff-4467-a351-64a72ab45d98*/
package test.com.sun.max.util;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Hiroshi Yamauchi
 */
@org.junit.runner.RunWith(org.junit.runners.AllTests.class)
public final class AllTests {

    private AllTests() {
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(AllTests.suite());
    }

    public static Test suite() {
        final TestSuite suite = new TestSuite(AllTests.class.getPackage().getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(DeferrableTest.class);
        suite.addTestSuite(EnumeratorTest.class);
        suite.addTestSuite(HexByteTest.class);
        suite.addTestSuite(IdentityHashMappingTest.class);
        suite.addTestSuite(IdentityMappingTest.class);
        suite.addTestSuite(JavaIdentifierTest.class);
        suite.addTestSuite(Utf8Test.class);
        //$JUnit-END$
        return suite;
    }
}

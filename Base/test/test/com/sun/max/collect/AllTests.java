/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=30a43c07-c30d-43eb-9c5d-10b117cc7afc*/
package test.com.sun.max.collect;

import junit.framework.*;

import org.junit.runner.*;

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
        suite.addTestSuite(ArraysTest.class);
        suite.addTestSuite(ArraySequenceTest.class);
        suite.addTestSuite(BytesTest.class);
        suite.addTestSuite(ByteVectorTest.class);
        suite.addTestSuite(IntegersTest.class);
        suite.addTestSuite(IntHashMapTest.class);
        suite.addTestSuite(IterablesTest.class);
        //$JUnit-END$
        return suite;
    }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5ffc9656-445b-40b3-a356-479dfbd40891*/
package test.com.sun.max.asm.amd64;

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
        suite.addTestSuite(InternalTest.class);
        suite.addTestSuite(BoundLabelTest.class);
        suite.addTestSuite(RawDisassemblerAndExternalTest.class);
        //$JUnit-END$
        return suite;
    }
    
}

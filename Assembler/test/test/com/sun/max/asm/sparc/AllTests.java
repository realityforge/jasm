/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=652f43fd-1076-4e43-ac29-31569215abee*/
package test.com.sun.max.asm.sparc;

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
        suite.addTestSuite(InternalTest.class);
        suite.addTestSuite(RawDisassemblerAndExternalTest.class);
        //$JUnit-END$
        return suite;
    }

}

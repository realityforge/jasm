/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7a11c3c3-ed2d-4179-abfe-5d108b1f2476*/
package test.com.sun.max.asm;

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
        suite.addTestSuite(MethodAnnotationsTest.class);
        suite.addTestSuite(test.com.sun.max.asm.sparc.InternalTest.class);
        suite.addTestSuite(test.com.sun.max.asm.ia32.InternalTest.class);
        suite.addTestSuite(test.com.sun.max.asm.amd64.InternalTest.class);
        suite.addTestSuite(test.com.sun.max.asm.ppc.InternalTest.class);
        suite.addTestSuite(test.com.sun.max.asm.sparc.RawDisassemblerTest.class);
        suite.addTestSuite(test.com.sun.max.asm.ia32.RawDisassemblerTest.class);
        suite.addTestSuite(test.com.sun.max.asm.amd64.RawDisassemblerTest.class);
        suite.addTestSuite(test.com.sun.max.asm.ppc.RawDisassemblerTest.class);
        //$JUnit-END$
        return suite;
    }

}

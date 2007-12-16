/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=67efedfd-6e24-4e4b-9b72-27a8b39f6b95*/
package test.com.sun.max.annotate;

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
        //$JUnit-END$
        return suite;
    }


}

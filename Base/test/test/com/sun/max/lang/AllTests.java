/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f7793bf2-570d-4f42-9abc-3be664d4a65b*/
package test.com.sun.max.lang;

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
        suite.addTestSuite(IntsTest.class);
        suite.addTestSuite(LongsTest.class);
        suite.addTestSuite(WordWidthTest.class);
        suite.addTestSuite(StringsTest.class);
        //$JUnit-END$
        return suite;
    }


}

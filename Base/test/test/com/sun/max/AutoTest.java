/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a57e8729-e92c-40d4-9d66-0e9206b485bc*/
package test.com.sun.max;

import junit.framework.Test;

@org.junit.runner.RunWith(org.junit.runners.AllTests.class)
public final class AutoTest {

    private AutoTest() {
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(AutoTest.suite());
    }

    public static Test suite() {
        return AllTests.suite();
    }
}

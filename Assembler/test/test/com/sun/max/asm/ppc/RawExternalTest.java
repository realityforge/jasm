/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4ff544f8-4db7-4412-b8e2-966f90abe7a1*/
package test.com.sun.max.asm.ppc;

import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.risc.ppc.PPC32AssemblyTester;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;
import junit.framework.Test;
import junit.framework.TestSuite;
import test.com.sun.max.asm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated PowerPC assembler against an external assembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawExternalTest extends ExternalAssemblerTestCase {

    public RawExternalTest() {
        super();
    }

    public RawExternalTest(String name) {
        super(name);
    }

    public static Test suite() {
        final TestSuite suite = new TestSuite(RawExternalTest.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(RawExternalTest.class);
        //$JUnit-END$
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(RawExternalTest.class);
    }

    public void test_assemble() throws FileNotFoundException, IOException {
        run(new PPC32AssemblyTester(EnumSet.of(AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }

}

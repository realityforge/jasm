/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=43a1b28f-058a-4394-890a-8f39336951c4*/
package test.com.sun.max.asm.ia32;

import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.cisc.ia32.IA32AssemblyTester;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;
import junit.framework.Test;
import junit.framework.TestSuite;
import test.com.sun.max.asm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated IA32 assembler against an external assembler.
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
        run(new IA32AssemblyTester(EnumSet.of(AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }

}

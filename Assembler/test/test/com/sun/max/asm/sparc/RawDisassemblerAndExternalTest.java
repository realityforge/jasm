/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5b60bc2d-c78c-40c9-949a-d1f2a911e2a5*/
package test.com.sun.max.asm.sparc;

import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.risc.sparc.SPARC32AssemblyTester;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;
import junit.framework.Test;
import junit.framework.TestSuite;
import test.com.sun.max.asm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated SPARC assembler against an external
 * assembler. The assembler is also tested by ensuring that its output
 * can be disassembled.
 *
 * @author Doug Simon
 * @author Bernd Mathiske
 */
public class RawDisassemblerAndExternalTest extends ExternalAssemblerTestCase {

    public RawDisassemblerAndExternalTest() {
        super();
    }

    public RawDisassemblerAndExternalTest(String name) {
        super(name);
    }

    public static Test suite() {
        final TestSuite suite = new TestSuite(RawDisassemblerAndExternalTest.class.getName());
        // $JUnit-BEGIN$
        suite.addTestSuite(RawDisassemblerAndExternalTest.class);
        // $JUnit-END$
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(RawDisassemblerAndExternalTest.class);
    }

    public void test_disassemblerAndExternalAssembler() throws FileNotFoundException, IOException {
        run(new SPARC32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER, AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }
}

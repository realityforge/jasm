/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c1a44141-bf7a-4a14-b65f-de6ee7fd0a59*/
package test.com.sun.max.asm.ppc;

import java.io.*;
import java.util.*;

import junit.framework.*;
import test.com.sun.max.asm.*;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.ppc.*;

/**
 * JUnit harness for testing the generated PowerPC assembler against an external
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
        run(new PPC32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER, AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b2b6661e-e005-41b0-bcde-5aa43f61ff63*/
package test.com.sun.max.asm.amd64;

import java.io.*;
import java.util.*;

import junit.framework.*;
import test.com.sun.max.asm.*;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.amd64.*;

/**
 * JUnit harness for testing the generated AMD64 assembler against an external
 * assembler. The assembler is also tested by ensuring that its output
 * can be disassembled.
 * 
 * @author Bernd Mathiske
 * @author Doug Simon
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
        run(new AMD64AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER, AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }

}

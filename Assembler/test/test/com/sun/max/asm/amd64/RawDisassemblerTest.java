/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f99530d4-ab33-4489-94a6-9e71915bc7d1*/
package test.com.sun.max.asm.amd64;

import java.io.*;
import java.util.*;

import junit.framework.*;
import test.com.sun.max.asm.*;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.amd64.*;

/**
 * JUnit harness for testing the generated AMD64 assembler against a disassembler.
 * 
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawDisassemblerTest extends AssemblerTestCase {

    public RawDisassemblerTest() {
        super();
    }

    public RawDisassemblerTest(String name) {
        super(name);
    }

    public static Test suite() {
        final TestSuite suite = new TestSuite(RawDisassemblerTest.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(RawDisassemblerTest.class);
        //$JUnit-END$
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(RawDisassemblerTest.class);
    }

    public void test_assemble() throws FileNotFoundException, IOException {
        run(new AMD64AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER)));
    }
}

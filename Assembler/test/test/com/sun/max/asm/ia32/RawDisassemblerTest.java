/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8fb9fc40-7861-47bc-85ee-8c50b753beb7*/
package test.com.sun.max.asm.ia32;

import java.io.*;
import java.util.*;

import junit.framework.*;
import test.com.sun.max.asm.*;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.ia32.*;


/**
 * JUnit harness for testing the generated IA32 assembler against a disassembler.
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

    public void test_disassembler() throws FileNotFoundException, IOException {
        run(new IA32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER)));
    }
}

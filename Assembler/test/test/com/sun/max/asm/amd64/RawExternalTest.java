/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b71d6b2c-b088-4150-bd89-b299e0b272c7*/
package test.com.sun.max.asm.amd64;

import java.io.*;
import java.util.*;

import junit.framework.*;
import test.com.sun.max.asm.*;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.cisc.amd64.*;

/**
 * JUnit harness for testing the generated AMD64 assembler against an external assembler.
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
        run(new AMD64AssemblyTester(EnumSet.of(AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }

}

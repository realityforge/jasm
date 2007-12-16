/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d47335a4-270c-4a7b-97bd-7fa3ab96a052*/
package test.com.sun.max.asm.sparc;

import java.io.*;
import java.util.*;

import junit.framework.*;
import test.com.sun.max.asm.*;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.sparc.*;

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
        run(new SPARC32AssemblyTester(EnumSet.of(AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }
}

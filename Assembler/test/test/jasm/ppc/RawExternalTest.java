/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4ff544f8-4db7-4412-b8e2-966f90abe7a1*/
package test.jasm.ppc;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.risc.ppc.PPC32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.jasm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated PowerPC assembler against an external assembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawExternalTest extends ExternalAssemblerTestCase {
    public void test_assemble() throws IOException {
        run(new PPC32AssemblyTester(EnumSet.of(AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }
}

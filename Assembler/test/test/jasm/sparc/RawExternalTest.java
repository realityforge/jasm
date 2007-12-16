/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d47335a4-270c-4a7b-97bd-7fa3ab96a052*/
package test.jasm.sparc;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.risc.sparc.SPARC32AssemblyTester;
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
        run(new SPARC32AssemblyTester(EnumSet.of(AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }
}

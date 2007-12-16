/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5b60bc2d-c78c-40c9-949a-d1f2a911e2a5*/
package test.jasm.sparc;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.risc.sparc.SPARC32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.jasm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated SPARC assembler against an external
 * assembler. The assembler is also tested by ensuring that its output
 * can be disassembled.
 *
 * @author Doug Simon
 * @author Bernd Mathiske
 */
public class RawDisassemblerAndExternalTest extends ExternalAssemblerTestCase {
    public void test_disassemblerAndExternalAssembler() throws IOException {
        run(new SPARC32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER, AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }
}

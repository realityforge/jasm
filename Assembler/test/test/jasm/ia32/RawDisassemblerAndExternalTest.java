/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=bf1aaf6d-3625-436c-ad38-5c73d4ff5a31*/
package test.jasm.ia32;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.cisc.ia32.IA32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.jasm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated IA32 assembler against an external
 * assembler. The assembler is also tested by ensuring that its output
 * can be disassembled.
 *
 * @author Doug Simon
 * @author Bernd Mathiske
 */
public class RawDisassemblerAndExternalTest extends ExternalAssemblerTestCase {
    public void test_disassemblerAndExternalAssembler() throws IOException {
        run(new IA32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER, AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }
}

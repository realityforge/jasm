/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c1a44141-bf7a-4a14-b65f-de6ee7fd0a59*/
package test.com.sun.max.asm.ppc;

import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.risc.ppc.PPC32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.com.sun.max.asm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated PowerPC assembler against an external
 * assembler. The assembler is also tested by ensuring that its output
 * can be disassembled.
 *
 * @author Doug Simon
 * @author Bernd Mathiske
 */
public class RawDisassemblerAndExternalTest extends ExternalAssemblerTestCase {
    public void test_disassemblerAndExternalAssembler() throws IOException {
        run(new PPC32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER, AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }

}

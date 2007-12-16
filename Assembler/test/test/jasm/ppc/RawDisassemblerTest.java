/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=21e0b5a1-30f0-44ac-9e9c-bd35eddf807e*/
package test.jasm.ppc;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.risc.ppc.PPC32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.jasm.AssemblerTestCase;

/**
 * JUnit harness for testing the generated PowerPC assembler against a disassembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawDisassemblerTest extends AssemblerTestCase {
    public void test_disassembler() throws IOException {
        run(new PPC32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER)));
    }
}

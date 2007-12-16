/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8fb9fc40-7861-47bc-85ee-8c50b753beb7*/
package test.jasm.ia32;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.cisc.ia32.IA32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.jasm.AssemblerTestCase;

/**
 * JUnit harness for testing the generated IA32 assembler against a disassembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawDisassemblerTest extends AssemblerTestCase {
    public void test_disassembler() throws IOException {
        run(new IA32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER)));
    }
}

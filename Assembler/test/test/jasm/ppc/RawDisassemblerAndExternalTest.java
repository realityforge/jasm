/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm.ppc;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.risc.ppc.PPC32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.jasm.AssemblerTestCase;

/**
 * JUnit harness for testing the generated PowerPC assembler against an external
 * assembler. The assembler is also tested by ensuring that its output
 * can be disassembled.
 *
 * @author Doug Simon
 * @author Bernd Mathiske
 */
public class RawDisassemblerAndExternalTest extends AssemblerTestCase {
    public void test_disassemblerAndExternalAssembler() throws IOException {
        run(new PPC32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER, AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
    }

}

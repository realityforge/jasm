/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=53f72092-c7d6-44dd-a5a4-9c15b36bdb91*/
package test.com.sun.max.asm.sparc;

import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.risc.sparc.SPARC32AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.com.sun.max.asm.AssemblerTestCase;

/**
 * JUnit harness for testing the generated SPARC assembler against a disassembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawDisassemblerTest extends AssemblerTestCase {
    public void test_assemble() throws IOException {
        run(new SPARC32AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER)));
    }
}

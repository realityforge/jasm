/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b2b6661e-e005-41b0-bcde-5aa43f61ff63*/
package test.com.sun.max.asm.amd64;

import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.cisc.amd64.AMD64AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.com.sun.max.asm.ExternalAssemblerTestCase;

/**
 * JUnit harness for testing the generated AMD64 assembler against an external
 * assembler. The assembler is also tested by ensuring that its output
 * can be disassembled.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawDisassemblerAndExternalTest extends ExternalAssemblerTestCase {
  public void test_disassemblerAndExternalAssembler() throws IOException {
    run(new AMD64AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER,
                                           AssemblyTestComponent.EXTERNAL_ASSEMBLER)));
  }
}

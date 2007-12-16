/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f99530d4-ab33-4489-94a6-9e71915bc7d1*/
package test.com.sun.max.asm.amd64;

import com.sun.max.asm.gen.AssemblyTestComponent;
import com.sun.max.asm.gen.cisc.amd64.AMD64AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.com.sun.max.asm.AssemblerTestCase;

/**
 * JUnit harness for testing the generated AMD64 assembler against a disassembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class RawDisassemblerTest extends AssemblerTestCase {
  public void test_assemble() throws IOException {
    run(new AMD64AssemblyTester(EnumSet.of(AssemblyTestComponent.DISASSEMBLER)));
  }
}

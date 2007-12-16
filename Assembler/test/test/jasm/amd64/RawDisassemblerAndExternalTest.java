/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package test.jasm.amd64;

import jasm.gen.AssemblyTestComponent;
import jasm.gen.cisc.amd64.AMD64AssemblyTester;
import java.io.IOException;
import java.util.EnumSet;
import test.jasm.ExternalAssemblerTestCase;

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

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.ppc.performance;

import jasm.dis.Disassembler;
import jasm.ppc.dis.PPC32Disassembler;
import jasm.ppc.as.PPC32Assembler;

public class PPC32PerformanceTester
    extends PPCPerformanceTester {

  protected Disassembler<?, ?> getDisassembler() {
    return new PPC32Disassembler(0);
  }

  protected byte[] assemble() throws Exception {
    return assemble(new PPC32Assembler(0));
  }
}

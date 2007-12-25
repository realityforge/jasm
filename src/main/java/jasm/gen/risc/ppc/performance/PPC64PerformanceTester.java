/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.ppc.performance;

import jasm.dis.Disassembler;
import jasm.ppc.as.PPC64Assembler;
import jasm.ppc.dis.PPC64Disassembler;

public class PPC64PerformanceTester
    extends PPCPerformanceTester {

  protected Disassembler<?, ?> getDisassembler() {
    return new PPC64Disassembler(0);
  }

  protected byte[] assemble() throws Exception {
    return assemble(new PPC64Assembler(0L));
  }
}

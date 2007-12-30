/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc.test.performance;

import jasm.dis.Disassembler;
import jasm.sparc.as.SPARC32Assembler;
import jasm.sparc.dis.SPARC32Disassembler;

public class SPARC32PerformanceTester
    extends SPARCPerformanceTester {

  protected Disassembler<?, ?> getDisassembler() {
    return new SPARC32Disassembler(0);
  }

  protected byte[] assemble() throws Exception {
    return assemble(new SPARC32Assembler(0));
  }
}

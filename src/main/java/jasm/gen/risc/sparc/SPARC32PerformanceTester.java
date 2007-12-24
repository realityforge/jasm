package jasm.gen.risc.sparc;

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

package jasm.gen.risc.sparc;

import jasm.dis.Disassembler;
import jasm.sparc.dis.SPARC32Disassembler;
import jasm.sparc.dis.SPARC64Disassembler;
import jasm.sparc.as.SPARC32Assembler;
import jasm.sparc.as.SPARC64Assembler;

public class SPARC64PerformanceTester
    extends SPARCPerformanceTester {

  protected Disassembler<?, ?> getDisassembler() {
    return new SPARC64Disassembler(0);
  }

  protected byte[] assemble() throws Exception {
    return assemble(new SPARC64Assembler(0));
  }
}

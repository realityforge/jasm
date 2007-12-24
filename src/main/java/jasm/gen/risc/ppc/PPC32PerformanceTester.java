package jasm.gen.risc.ppc;

import jasm.dis.Disassembler;
import jasm.ppc.dis.PPC64Disassembler;
import jasm.ppc.dis.PPC32Disassembler;
import jasm.ppc.as.PPC64Assembler;
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

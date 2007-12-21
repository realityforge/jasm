package jasm;

import jasm.util.WordWidth;

public enum AssemblerDef {
  AMD64(InstructionSet.AMD64, WordWidth.BITS_64, "jasm.gen.cisc.amd64.AMD64AssemblyTester"),
  IA32(InstructionSet.IA32, WordWidth.BITS_32, "jasm.gen.cisc.ia32.IA32AssemblyTester"),
  PPC32(InstructionSet.PPC, WordWidth.BITS_32, "jasm.gen.risc.ppc.PPC32AssemblyTester"),
  PPC64(InstructionSet.PPC, WordWidth.BITS_64, "jasm.gen.risc.ppc.PPC64AssemblyTester"),
  SPARC32(InstructionSet.SPARC, WordWidth.BITS_32, "jasm.gen.risc.sparc.SPARC32AssemblyTester"),
  SPARC64(InstructionSet.SPARC, WordWidth.BITS_64, "jasm.gen.risc.sparc.SPARC64AssemblyTester");

  private final InstructionSet _instructionSet;
  private final WordWidth _wordWidth;
  private final String _testerClassname;

  private AssemblerDef(final InstructionSet instructionSet, final WordWidth wordWidth, final String classname) {
    _instructionSet = instructionSet;
    _wordWidth = wordWidth;
    _testerClassname = classname;
  }

  public InstructionSet getInstructionSet() {
    return _instructionSet;
  }

  public WordWidth getWordWidth() {
    return _wordWidth;
  }

  public String getTesterClassname() {
    return _testerClassname;
  }

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}

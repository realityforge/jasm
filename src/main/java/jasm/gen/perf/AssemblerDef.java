package jasm.gen.perf;

enum AssemblerDef {
  AMD64("jasm.gen.cisc.amd64.AMD64PerformanceTester"),
  IA32("jasm.gen.cisc.ia32.IA32PerformanceTester"),
  PPC32("jasm.gen.risc.ppc.PPC32PerformanceTester"),
  PPC64("jasm.gen.risc.ppc.PPC64PerformanceTester"),
  SPARC32("jasm.gen.risc.sparc.SPARC32PerformanceTester"),
  SPARC64("jasm.gen.risc.sparc.SPARC64PerformanceTester");

  private final String _testerClassname;

  private AssemblerDef(final String classname) {
    _testerClassname = classname;
  }

  public String getTesterClassname() {
    return _testerClassname;
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.test.correctness;

enum AssemblerDef {
  AMD64("jasm.tools.cisc.amd64.correctness.AMD64AssemblyTester"),
  IA32("jasm.tools.cisc.ia32.correctness.IA32AssemblyTester"),
  PPC32("jasm.tools.risc.ppc.correctness.PPC32AssemblyTester"),
  PPC64("jasm.tools.risc.ppc.correctness.PPC64AssemblyTester"),
  SPARC32("jasm.tools.risc.sparc.correctness.SPARC32AssemblyTester"),
  SPARC64("jasm.tools.risc.sparc.correctness.SPARC64AssemblyTester");

  private final String _testerClassname;

  private AssemblerDef(final String classname) {
    _testerClassname = classname;
  }

  public String getTesterClassname() {
    return _testerClassname;
  }
}

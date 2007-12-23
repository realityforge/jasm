/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.test;

enum AssemblerDef {
  AMD64("jasm.gen.cisc.amd64.AMD64AssemblyTester"),
  IA32("jasm.gen.cisc.ia32.IA32AssemblyTester"),
  PPC32("jasm.gen.risc.ppc.PPC32AssemblyTester"),
  PPC64("jasm.gen.risc.ppc.PPC64AssemblyTester"),
  SPARC32("jasm.gen.risc.sparc.SPARC32AssemblyTester"),
  SPARC64("jasm.gen.risc.sparc.SPARC64AssemblyTester");

  private final String _testerClassname;

  private AssemblerDef(final String classname) {
    _testerClassname = classname;
  }

  public String getTesterClassname() {
    return _testerClassname;
  }
}

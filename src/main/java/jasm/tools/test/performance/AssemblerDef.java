/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.test.performance;

enum AssemblerDef {
  AMD64("jasm.tools.cisc.amd64.performance.AMD64PerformanceTester"),
  IA32("jasm.tools.cisc.ia32.performance.IA32PerformanceTester"),
  PPC32("jasm.tools.risc.ppc.performance.PPC32PerformanceTester"),
  PPC64("jasm.tools.risc.ppc.performance.PPC64PerformanceTester"),
  SPARC32("jasm.tools.risc.sparc.performance.SPARC32PerformanceTester"),
  SPARC64("jasm.tools.risc.sparc.performance.SPARC64PerformanceTester");

  private final String _testerClassname;

  private AssemblerDef(final String classname) {
    _testerClassname = classname;
  }

  public String getTesterClassname() {
    return _testerClassname;
  }
}

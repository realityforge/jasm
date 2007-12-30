/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.gen.as;

enum ISADef {
  amd64("jasm.tools.cisc.amd64.gen.as.AMD64AssemblerGenerator"),
  ia32("jasm.tools.cisc.ia32.gen.as.IA32AssemblerGenerator"),
  ppc("jasm.tools.risc.ppc.gen.as.PPCAssemblerGenerator"),
  sparc("jasm.tools.risc.sparc.gen.as.SPARCAssemblerGenerator");

  private final String _generatorClassname;

  ISADef(final String generatorClassname) {
    _generatorClassname = generatorClassname;
  }

  public String getGeneratorClassname() {
    return _generatorClassname;
  }
}

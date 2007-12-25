/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.gen.as;

enum ISADef {
  AMD64("jasm.gen.cisc.amd64.AMD64AssemblerGenerator"),
  IA32("jasm.gen.cisc.ia32.IA32AssemblerGenerator"),
  PPC("jasm.gen.risc.ppc.PPCAssemblerGenerator"),
  SPARC("jasm.gen.risc.sparc.SPARCAssemblerGenerator");

  private final String _generatorClassname;

  ISADef(final String generatorClassname) {
    _generatorClassname = generatorClassname;
  }

  public String getGeneratorClassname() {
    return _generatorClassname;
  }
}

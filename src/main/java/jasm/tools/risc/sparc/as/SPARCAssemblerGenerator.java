/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.sparc.as;

import jasm.Assembler;
import jasm.BigEndianAssembler;
import jasm.tools.risc.RiscAssemblerGenerator;
import jasm.tools.risc.sparc.SPARCTemplate;
import jasm.tools.risc.sparc.SPARCAssembly;

public final class SPARCAssemblerGenerator extends RiscAssemblerGenerator<SPARCTemplate> {

  public SPARCAssemblerGenerator() {
    super(SPARCAssembly.ASSEMBLY);
  }

  @Override
  protected Class<? extends Assembler> parentAssemblerClass() {
    return BigEndianAssembler.class;
  }

  @Override
  protected String getJavadocManualReference(SPARCTemplate template) {
    return
        "\"<a href=\"http://developers.sun.com/solaris/articles/sparcv9.pdf\">The SPARC Architecture Manual, Version 9</a> - Section " +
        template.instructionDescription().architectureManualSection() +
        "\"";
  }
}

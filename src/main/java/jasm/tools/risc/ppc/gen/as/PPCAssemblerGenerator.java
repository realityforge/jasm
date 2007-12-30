/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.ppc.gen.as;

import jasm.Assembler;
import jasm.BigEndianAssembler;
import jasm.ppc.GPR;
import jasm.tools.risc.RiscAssemblerGenerator;
import jasm.tools.risc.ppc.PPCTemplate;
import jasm.tools.risc.ppc.PPCAssembly;
import java.util.List;
import java.util.Set;

/** The program entry point for the PowerPC assembler generator. */
public final class PPCAssemblerGenerator
    extends RiscAssemblerGenerator<PPCTemplate> {

  public PPCAssemblerGenerator() {
    super(PPCAssembly.ASSEMBLY);
  }

  @Override
  protected Set<String> getRawAssemblerImports(final List<PPCTemplate> templates) {
    final Set<String> imports = super.getRawAssemblerImports(templates);
    imports.add("static " + GPR.class.getName());
    return imports;
  }

  @Override
  protected Class<? extends Assembler> parentAssemblerClass() {
    return BigEndianAssembler.class;
  }

  @Override
  protected String getJavadocManualReference(PPCTemplate template) {
    String section = template.instructionDescription().architectureManualSection();
    if (section.indexOf("[Book ") == -1) {
      section += " [Book 1]";
    }
    return "\"<a href=\"http://www.ibm.com/developerworks/eserver/library/es-archguide-v2.html\">PowerPC Architecture Book, Version 2.02</a> - Section " + section + "\"";
  }
}

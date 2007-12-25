/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.ppc;

import jasm.Assembler;
import jasm.BigEndianAssembler;
import jasm.ppc.GPR;
import jasm.tools.risc.RiscAssemblerGenerator;
import jasm.tools.util.IndentWriter;
import java.util.Set;

/**
 * The program entry point for the PowerPC assembler generator.
 */
public final class PPCAssemblerGenerator
    extends RiscAssemblerGenerator<PPCTemplate> {

    public PPCAssemblerGenerator() {
        super(PPCAssembly.ASSEMBLY);
    }

    @Override
    protected void printRawImports(IndentWriter writer, Set<String> packages) {
        super.printRawImports(writer, packages);
        writer.println("import static " + GPR.class.getName() + ".*;");
    }

    @Override
    protected Class<? extends Assembler> endiannessSpecificAssemblerClass() {
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

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.ppc;

import com.sun.max.io.IndentWriter;
import com.sun.max.program.Trace;
import com.sun.max.program.option.ProgramArgumentsParser;
import jasm.Assembler;
import jasm.BigEndianAssembler;
import jasm.gen.risc.RiscAssemblerGenerator;
import jasm.ppc.GPR;
import java.util.Set;

/**
 * The program entry point for the PowerPC assembler generator.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class PPCAssemblerGenerator extends RiscAssemblerGenerator<PPCTemplate> {

    private PPCAssemblerGenerator() {
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

    public static void main(String[] programArguments) {
        final ProgramArgumentsParser programArgumentsParser = new ProgramArgumentsParser(PPCAssemblerGenerator.class.getSimpleName());
        programArgumentsParser.addProgramOption(new Trace());
        programArgumentsParser.parse(programArguments);
        final PPCAssemblerGenerator generator = new PPCAssemblerGenerator();
        generator.generate();
    }

}

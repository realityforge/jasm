/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.sparc;

import jasm.util.program.Trace;
import jasm.util.program.option.ProgramArgumentsParser;
import jasm.Assembler;
import jasm.BigEndianAssembler;
import jasm.gen.risc.RiscAssemblerGenerator;

/**
 *
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class SPARCAssemblerGenerator extends RiscAssemblerGenerator<SPARCTemplate> {

    private SPARCAssemblerGenerator() {
        super(SPARCAssembly.ASSEMBLY);
    }

    @Override
    protected Class<? extends Assembler> endiannessSpecificAssemblerClass() {
        return BigEndianAssembler.class;
    }

    @Override
    protected String getJavadocManualReference(SPARCTemplate template) {
        return "\"<a href=\"http://developers.sun.com/solaris/articles/sparcv9.pdf\">The SPARC Architecture Manual, Version 9</a> - Section " +
            template.instructionDescription().architectureManualSection() + "\"";
    }

    public static void main(String[] programArguments) {
        final ProgramArgumentsParser programArgumentsParser = new ProgramArgumentsParser(SPARCAssemblerGenerator.class.getSimpleName());
        programArgumentsParser.addProgramOption(new Trace());
        programArgumentsParser.parse(programArguments);
        final SPARCAssemblerGenerator generator = new SPARCAssemblerGenerator();
        generator.generate();
    }

}

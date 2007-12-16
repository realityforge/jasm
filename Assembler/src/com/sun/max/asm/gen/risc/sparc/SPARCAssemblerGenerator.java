/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4cb63353-d0d1-41d7-be56-4c602f46e479*/
package com.sun.max.asm.gen.risc.sparc;

import com.sun.max.asm.*;
import com.sun.max.asm.gen.risc.*;
import com.sun.max.program.*;
import com.sun.max.program.option.*;

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

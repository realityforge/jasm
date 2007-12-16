/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ee472d09-6e29-47e7-bb42-173e45a4b5a4*/
package com.sun.max.asm.gen.risc.ppc;


import java.util.*;

import com.sun.max.*;
import com.sun.max.asm.*;
import com.sun.max.asm.gen.risc.*;
import com.sun.max.asm.ppc.*;
import com.sun.max.io.*;
import com.sun.max.program.*;
import com.sun.max.program.option.*;

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
    protected void printRawImports(IndentWriter writer, Set<MaxPackage> packages) {
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

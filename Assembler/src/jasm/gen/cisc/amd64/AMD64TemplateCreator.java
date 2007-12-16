/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.amd64;

import jasm.gen.cisc.x86.InstructionAssessment;
import jasm.gen.cisc.x86.X86InstructionDescription;
import jasm.gen.cisc.x86.X86TemplateContext;
import jasm.gen.cisc.x86.X86TemplateCreator;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class AMD64TemplateCreator extends X86TemplateCreator<AMD64Template> {

    public AMD64TemplateCreator() {
        super(WordWidth.BITS_64);
    }

    @Override
    protected AMD64Template createTemplate(X86InstructionDescription instructionDescription, int serial, InstructionAssessment instructionFamily, X86TemplateContext context) {
        return new AMD64Template(instructionDescription, serial, instructionFamily, context);
    }

}

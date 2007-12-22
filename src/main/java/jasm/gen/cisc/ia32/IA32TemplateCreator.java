/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.ia32;

import jasm.gen.cisc.x86.InstructionAssessment;
import jasm.gen.cisc.x86.X86InstructionDescription;
import jasm.gen.cisc.x86.X86TemplateContext;
import jasm.gen.cisc.x86.X86TemplateCreator;
import jasm.WordWidth;

/**
 * @author Bernd Mathiske
 */
public final class IA32TemplateCreator extends X86TemplateCreator<IA32Template> {

    public IA32TemplateCreator() {
        super(WordWidth.BITS_32);
    }

    @Override
    protected final IA32Template createTemplate(X86InstructionDescription instructionDescription, int serial, InstructionAssessment instructionFamily, X86TemplateContext context) {
        return new IA32Template(instructionDescription, serial, instructionFamily, context);
    }

}

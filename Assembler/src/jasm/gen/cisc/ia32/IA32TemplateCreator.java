/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.ia32;

import jasm.gen.cisc.x86.InstructionAssessment;
import jasm.gen.cisc.x86.X86InstructionDescription;
import jasm.gen.cisc.x86.X86TemplateContext;
import jasm.gen.cisc.x86.X86TemplateCreator;
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public class IA32TemplateCreator extends X86TemplateCreator<IA32Template> {

    public IA32TemplateCreator() {
        super(WordWidth.BITS_32);
    }

    @Override
    protected IA32Template createTemplate(X86InstructionDescription instructionDescription, int serial, InstructionAssessment instructionFamily, X86TemplateContext context) {
        return new IA32Template(instructionDescription, serial, instructionFamily, context);
    }

}

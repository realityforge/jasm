/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a0d68484-0b62-4243-974a-797fea1ecf74*/
package com.sun.max.asm.gen.cisc.ia32;

import com.sun.max.asm.gen.cisc.x86.InstructionAssessment;
import com.sun.max.asm.gen.cisc.x86.X86InstructionDescription;
import com.sun.max.asm.gen.cisc.x86.X86TemplateContext;
import com.sun.max.asm.gen.cisc.x86.X86TemplateCreator;
import com.sun.max.lang.WordWidth;

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

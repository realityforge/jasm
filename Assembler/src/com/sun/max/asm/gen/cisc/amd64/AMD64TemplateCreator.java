/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=79a64776-2c9e-4bae-82c5-78ffd600323f*/
package com.sun.max.asm.gen.cisc.amd64;

import com.sun.max.asm.gen.cisc.x86.InstructionAssessment;
import com.sun.max.asm.gen.cisc.x86.X86InstructionDescription;
import com.sun.max.asm.gen.cisc.x86.X86TemplateContext;
import com.sun.max.asm.gen.cisc.x86.X86TemplateCreator;
import com.sun.max.lang.WordWidth;

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

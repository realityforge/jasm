/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4d107203-692e-4171-a6ee-bdb631fa12b3*/
package jasm.gen.risc.ppc;

import jasm.gen.InstructionDescription;
import jasm.gen.risc.RiscTemplateCreator;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class PPCTemplateCreator extends RiscTemplateCreator<PPCTemplate> {

    PPCTemplateCreator() {
        super();
    }

    @Override
    protected PPCTemplate createTemplate(InstructionDescription instructionDescription) {
        return new PPCTemplate(instructionDescription);
    }

}

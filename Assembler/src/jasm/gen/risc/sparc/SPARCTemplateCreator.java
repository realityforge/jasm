/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7812f40e-328f-40b4-b7ee-af76ed0d40e4*/
package jasm.gen.risc.sparc;

import jasm.gen.InstructionDescription;
import jasm.gen.risc.RiscTemplateCreator;

/**
 *
 *
 * @author Bernd Mathiske
 */
public class SPARCTemplateCreator extends RiscTemplateCreator<SPARCTemplate> {

    SPARCTemplateCreator() {
        super();
    }

    @Override
    protected SPARCTemplate createTemplate(InstructionDescription instructionDescription) {
        return new SPARCTemplate(instructionDescription);
    }

}

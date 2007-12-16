/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a9c15b37-1b33-43a1-8c9f-edc2af627488*/
package com.sun.max.asm.gen.risc.sparc;

import com.sun.max.asm.gen.Assembly;
import com.sun.max.asm.gen.risc.RiscInstructionDescriptionCreator;

/**
 * @author Bernd Mathiske
 */

public abstract class SPARCInstructionDescriptionCreator extends RiscInstructionDescriptionCreator {

    protected SPARCInstructionDescriptionCreator(SPARCTemplateCreator templateCreator) {
        super(SPARCAssembly.ASSEMBLY, templateCreator);
    }

    @Override
    public SPARCAssembly assembly() {
        final Assembly assembly = super.assembly();
        return (SPARCAssembly) assembly;
    }

}

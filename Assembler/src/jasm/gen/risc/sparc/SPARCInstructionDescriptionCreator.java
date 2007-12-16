/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.risc.sparc;

import jasm.gen.Assembly;
import jasm.gen.risc.RiscInstructionDescriptionCreator;

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

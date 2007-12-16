/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.ppc;

import jasm.InstructionSet;

/**
 * The base class for the 32-bit and 64-bit PowerPC assemblers. This class also defines
 * the more complex synthetic PowerPC instructions.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public abstract class PPCAssembler extends PPCLabelAssembler {

    @Override
    public final InstructionSet instructionSet() {
        return InstructionSet.PPC;
    }

}

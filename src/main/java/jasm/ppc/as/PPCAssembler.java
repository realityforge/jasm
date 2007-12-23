/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc.as;

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

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1186d6a8-632b-4fab-a768-50fa90956d24*/
package com.sun.max.asm.ppc;

import com.sun.max.asm.*;

/**
 *
 * @author Bernd Mathiske
 */
public class Package extends AsmPackage {
    public Package() {
        super();
    }

    @Override
    public boolean isPartOfAssembler(InstructionSet instructionSet) {
        return instructionSet == InstructionSet.PPC;
    }
}

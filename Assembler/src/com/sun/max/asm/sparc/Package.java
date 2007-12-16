/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c2de6626-ac07-4727-a251-1c5d7e2a71d1*/
package com.sun.max.asm.sparc;

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
        return instructionSet == InstructionSet.SPARC;
    }
}

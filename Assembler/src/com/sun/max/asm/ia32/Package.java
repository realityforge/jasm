/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4eedd412-1e3b-4ad9-b43e-4d491080585b*/
package com.sun.max.asm.ia32;

import com.sun.max.*;
import com.sun.max.asm.*;

/**
 * @see MaxPackage
 * 
 * @author Bernd Mathiske
 */
public class Package extends AsmPackage {
    public Package() {
        super();
    }

    @Override
    public boolean isPartOfAssembler(InstructionSet instructionSet) {
        return instructionSet == InstructionSet.IA32;
    }
}

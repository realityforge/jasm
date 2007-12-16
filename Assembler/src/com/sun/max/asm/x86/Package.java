/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=25d173e3-7d05-444a-9e19-67ed823c7071*/
package com.sun.max.asm.x86;

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
        return instructionSet == InstructionSet.AMD64 || instructionSet == InstructionSet.IA32;
    }
}

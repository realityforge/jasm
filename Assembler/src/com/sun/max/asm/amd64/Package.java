/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=789a3e9d-95f2-4d2c-80fa-67329b7f9370*/
package com.sun.max.asm.amd64;


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
        return instructionSet == InstructionSet.AMD64;
    }
}

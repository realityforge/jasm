/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ca75b478-44fa-421d-bc0c-4105fca8837d*/
package com.sun.max.asm;

import com.sun.max.*;

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
        return true;
    }
}

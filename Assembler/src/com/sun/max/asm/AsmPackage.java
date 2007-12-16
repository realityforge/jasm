/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b3931a16-2fe2-4b5b-a2e7-1951a0eb6b71*/
package com.sun.max.asm;

import com.sun.max.*;

/**
 * @author Bernd Mathiske
 */
public class AsmPackage extends MaxPackage {
    public AsmPackage() {
        super();
    }
    
    public boolean isPartOfAssembler(InstructionSet instructionSet) {
        return false;
    }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=7812f40e-328f-40b4-b7ee-af76ed0d40e4*/
package com.sun.max.asm.gen.risc.sparc;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.*;

/**
 * 
 *
 * @author Bernd Mathiske
 */
public class SPARCTemplateCreator extends RiscTemplateCreator<SPARCTemplate> {    

    SPARCTemplateCreator() {
        super();
    }
    
    @Override
    protected SPARCTemplate createTemplate(InstructionDescription instructionDescription) {
        return new SPARCTemplate(instructionDescription);
    }
    
}

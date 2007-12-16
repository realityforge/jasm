/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=bb1334d6-3028-472a-bfcb-80bbe7d89154*/
package com.sun.max.asm.gen;

import com.sun.max.asm.*;


/**
 * An operand that does not correspond to a parameter.
 *
 * @author Bernd Mathiske
 */
public interface ImplicitOperand extends Operand {

    Argument argument();
    
    /**
     * Determines whether the operand is to be omitted or explicitly stated in external syntax.
     *
     * @author Bernd Mathiske
     */
    public enum ExternalPresence {
        OMITTED, EXPLICIT;
    }
    
    ExternalPresence externalPresence();
}

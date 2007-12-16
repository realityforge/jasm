/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ca6bb6c4-f83f-4b4c-ae15-a1f3dd91e525*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.asm.gen.*;

/**
 * Description of an assembly instruction operand.
 * 
 * @author Bernd Mathiske
 */
public abstract class X86Operand implements Operand {

    public enum Designation {
        DESTINATION, SOURCE, OTHER;
    }

    private Designation _designation;
    
    protected X86Operand(Designation designation) {
        _designation = designation;
    }

    public Designation designation() {
        return _designation;
    }
    
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ed33c02b-e880-4e6d-b240-28d71f085858*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.asm.gen.*;

/**
 * @author Bernd Mathiske
 */
public enum RegisterOperandCode {

    eAX, eCX, eDX, eBX, eSP, eBP, eSI, eDI,
    rAX, rCX, rDX, rBX, rSP, rBP, rSI, rDI;
    
    public int id() {
        return ordinal() % 8;
    }
    
    public ExternalOmission omitExternally() {
        return new ExternalOmission(this);
    }
    
}

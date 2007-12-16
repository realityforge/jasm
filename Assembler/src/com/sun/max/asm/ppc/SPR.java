/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=695b729f-0c34-4e13-bc0a-fb871309d6ab*/
package com.sun.max.asm.ppc;

import com.sun.max.asm.*;
import com.sun.max.util.*;

/**
 * Special Purpose Registers.
 * 
 * @author Bernd Mathiske
 */
public final class SPR extends AbstractSymbolicArgument {

    private SPR(int value) {
        super(value);
    }

    /**
     * Denotes the Fixed-Point Exception Register. 
     */
    public static final SPR XER = new SPR(1);

    /**
     * Denotes the Link Register. 
     */
    public static final SPR LR = new SPR(8);

    /**
     * Denotes the Count Register. 
     */
    public static final SPR CTR = new SPR(9);
    
    public static final Symbolizer<SPR> SYMBOLIZER = Symbolizer.Static.initialize(SPR.class);
    
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.ppc;

import jasm.AbstractSymbolicArgument;
import jasm.util.Symbolizer;

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

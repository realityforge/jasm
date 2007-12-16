/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8710f661-a86f-4b47-9779-54903ff92c21*/
package com.sun.max.asm.gen.risc.field;

import com.sun.max.asm.gen.risc.bitRange.*;

/**
 * @author Dave Ungar
 * @author Adam Spitz
 * @author Bernd Mathiske
 */
public class ReservedField extends RiscField {

    public ReservedField(BitRange bitRange) {
        super(bitRange);
    }

    public static ReservedField createAscending(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
        return new ReservedField(bitRange);
    }    

    public static ReservedField createDescending(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.DESCENDING);
        return new ReservedField(bitRange);
    }    

}

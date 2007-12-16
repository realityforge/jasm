/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=843d21b5-13e4-447a-ae7c-5922a8cd79a5*/
package com.sun.max.asm.gen.risc.field;

import com.sun.max.asm.gen.risc.bitRange.*;

/**
 * A field that contains an immediate value that is ignored by the hardware.
 * 
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 * @author Doug Simon
 */
public class IgnoredOperandField extends ImmediateOperandField {

    public IgnoredOperandField(BitRange bitRange) {
        super(bitRange);
    }

    public static IgnoredOperandField createAscendingIgnored(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
        return new IgnoredOperandField(bitRange);
    }

    public static IgnoredOperandField createDescendingIgnored(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.DESCENDING);
        return new IgnoredOperandField(bitRange);
    }

}

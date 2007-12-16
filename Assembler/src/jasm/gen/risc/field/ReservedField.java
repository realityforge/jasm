/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.risc.field;

import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.bitRange.BitRangeOrder;

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

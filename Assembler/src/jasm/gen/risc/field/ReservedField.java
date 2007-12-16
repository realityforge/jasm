/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
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

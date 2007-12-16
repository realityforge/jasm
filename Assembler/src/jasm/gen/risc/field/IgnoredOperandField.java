/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.field;

import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.bitRange.BitRangeOrder;

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

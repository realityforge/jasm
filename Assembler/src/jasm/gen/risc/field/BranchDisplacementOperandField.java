/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc.field;

import jasm.gen.OffsetParameter;
import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.bitRange.BitRangeOrder;

/**
 * @author Dave Ungar
 * @author Adam Spitz
 * @author Bernd Mathiske
 */
public class BranchDisplacementOperandField extends AlignedImmediateOperandField implements OffsetParameter {

    public BranchDisplacementOperandField(BitRange bitRange) {
        super(bitRange, 2);
        setSignDependentOperations(SignDependentOperations.SIGNED);
    }

    public static BranchDisplacementOperandField createAscendingBranchDisplacementOperandField(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
        return new BranchDisplacementOperandField(bitRange);
    }

    public static BranchDisplacementOperandField createDescendingBranchDisplacementOperandField(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.DESCENDING);
        final BranchDisplacementOperandField field = new BranchDisplacementOperandField(bitRange);
        field.setVariableName("label");
        return field;
    }

}

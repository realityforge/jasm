/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
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

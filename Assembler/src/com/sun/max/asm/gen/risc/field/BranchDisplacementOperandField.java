/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=3f054089-84d1-409f-8bee-f799b66de069*/
package com.sun.max.asm.gen.risc.field;

import com.sun.max.asm.gen.*;
import com.sun.max.asm.gen.risc.bitRange.*;

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

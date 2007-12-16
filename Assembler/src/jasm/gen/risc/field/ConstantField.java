/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d144abef-5476-4086-a86b-f38f9c2f9303*/
package jasm.gen.risc.field;

import jasm.Argument;
import jasm.gen.risc.RiscConstant;
import jasm.gen.risc.bitRange.BitRange;
import jasm.gen.risc.bitRange.BitRangeOrder;

/**
 * @author Dave Ungar
 * @author Bernd Mathiske
 * @author Adam Spitz
 */
public class ConstantField extends RiscField {

    public ConstantField(BitRange bitRange) {
        super(bitRange);
    }

    public ConstantField(String name, BitRange bitRange) {
        super(bitRange);
        setName(name);
    }

    public RiscConstant constant(Argument argument) {
        return new RiscConstant(this, argument);
    }

    public RiscConstant constant(int value) {
        return new RiscConstant(this, value);
    }

    public static ConstantField createAscending(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.ASCENDING);
        return new ConstantField(bitRange);
    }

    public static ConstantField createDescending(int... bits) {
        final BitRange bitRange = BitRange.create(bits, BitRangeOrder.DESCENDING);
        return new ConstantField(bitRange);
    }

}

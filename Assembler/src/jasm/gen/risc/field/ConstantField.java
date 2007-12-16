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

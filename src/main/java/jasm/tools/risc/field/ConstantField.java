/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.field;

import jasm.tools.risc.RiscConstant;
import jasm.tools.risc.bitRange.BitRange;
import jasm.tools.risc.bitRange.BitRangeOrder;

public final class ConstantField extends RiscField {

  public ConstantField(BitRange bitRange) {
    super(bitRange);
  }

  public ConstantField(String name, BitRange bitRange) {
    super(name, bitRange);
  }

  public final RiscConstant constant(int value) {
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

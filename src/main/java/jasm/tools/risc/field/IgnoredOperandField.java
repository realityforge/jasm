/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.risc.field;

import jasm.tools.risc.bitRange.BitRange;
import jasm.tools.risc.bitRange.BitRangeOrder;

/**
 * A field that contains an immediate value that is ignored by the hardware.
 */
public final class IgnoredOperandField extends ImmediateOperandField {

  public IgnoredOperandField(BitRange bitRange) {
    super(bitRange);
  }

  public static IgnoredOperandField createDescendingIgnored(int... bits) {
    final BitRange bitRange = BitRange.create(bits, BitRangeOrder.DESCENDING);
    return new IgnoredOperandField(bitRange);
  }

}

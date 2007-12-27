/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis;

import jasm.tools.ImmediateArgument;
import jasm.util.HexUtil;

/** Mixin delegation style (for lack of multiple class inheritance in the Java(TM) Programming Language). */
public interface Address64Instruction extends AddressInstruction {

  long address();

  public static final class Mixin implements Address64Instruction {

    private final long _startAddress;
    private final DisassembledInstruction _disassembledInstruction;

    public Mixin(DisassembledInstruction disassembledInstruction, long startAddress) {
      _startAddress = startAddress;
      _disassembledInstruction = disassembledInstruction;
    }

    public final long address() {
      return _startAddress + startOffset();
    }

    public final int startOffset() {
      return _disassembledInstruction.startOffset();
    }

    public final String addressString() {
      return HexUtil.toHexLiteral(address());
    }

    public final int addressToOffset(ImmediateArgument argument) {
      final long argumentAddress = argument.asLong();
      final long result = argumentAddress - _startAddress;
      if (result > Integer.MAX_VALUE) {
        return -1;
      }
      return (int) result;
    }
  }
}

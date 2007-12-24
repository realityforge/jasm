/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis;

import jasm.gen.ImmediateArgument;
import jasm.util.HexUtil;

/**
 * Mixin delegation style (for lack of multiple class inheritance in the Java(TM) Programming Language).
 */
public interface Address32Instruction extends AddressInstruction {

  int address();

  public static final class Mixin implements Address32Instruction {

    private final int _startAddress;
    private final DisassembledInstruction _disassembledInstruction;

    public Mixin(DisassembledInstruction disassembledInstruction, int startAddress) {
      _startAddress = startAddress;
      _disassembledInstruction = disassembledInstruction;
    }

    public final int address() {
      return _startAddress + startOffset();
    }

    public final int startOffset() {
      return _disassembledInstruction.startOffset();
    }

    public final String addressString() {
      return HexUtil.toHexLiteral(address());
    }

    public final int addressToOffset(ImmediateArgument argument) {
      final int argumentAddress = (int) argument.asLong();
      return argumentAddress - _startAddress;
    }
  }
}

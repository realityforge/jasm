/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86.dis;

import jasm.util.HexByte;
import jasm.x86.X86InstructionPrefix;

/**
 * Info about the first few bytes of an x86 instruction,
 * narrowing the set of possible instructions to probe by the disassembler.
 */
public final class X86InstructionHeader {

  boolean _hasAddressSizePrefix;
  //boolean _hasOperandSizePrefix;
  HexByte _rexPrefix;
  X86InstructionPrefix _instructionSelectionPrefix;
  //X86InstructionPrefix _group1Prefix;
  //X86InstructionPrefix _group2Prefix;
  HexByte _opcode1;
  HexByte _opcode2;
  //HexByte _opCode3;

  @Override
  public String toString() {
    return "X86InstructionHeader[AddressPrefix=" + _hasAddressSizePrefix +
           ",rexPrefix=" + _rexPrefix +
           ",instructionSelectionPrefix=" + _instructionSelectionPrefix +
           ",opcode1=" + _opcode1 +
           ",opcode2=" + _opcode2 +
           "]";
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof X86InstructionHeader) {
      final X86InstructionHeader header = (X86InstructionHeader) other;
      return _hasAddressSizePrefix == header._hasAddressSizePrefix &&
             _instructionSelectionPrefix == header._instructionSelectionPrefix &&
             _opcode1 == header._opcode1 &&
             _opcode2 == header._opcode2;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = _hasAddressSizePrefix ? -1 : 1;
    if (_instructionSelectionPrefix != null) {
      result *= _instructionSelectionPrefix.ordinal();
    }
    if (_opcode1 != null) {
      result *= _opcode1.ordinal();
    }
    if (_opcode2 != null) {
      result ^= _opcode2.ordinal();
    }
    if (_instructionSelectionPrefix != null) {
      result += _instructionSelectionPrefix.ordinal() * 1024;
    }
    if (_opcode2 != null) {
      result += _opcode2.ordinal() * 256;
    }
    if (_opcode1 != null) {
      result += _opcode1.ordinal();
    }
    return result;
  }
}

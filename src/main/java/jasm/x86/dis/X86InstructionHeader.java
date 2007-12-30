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
  boolean _hasOperandSizePrefix;
  HexByte _rexPrefix;
  X86InstructionPrefix _group1Prefix;
  X86InstructionPrefix _group2Prefix;
  HexByte _opcode1;
  HexByte _opcode2;
  //HexByte _opCode3;

  @Override
  public String toString() {
    return "X86InstructionHeader[rexPrefix=" + _rexPrefix +
           ",group1Prefix=" + _group1Prefix +
           ",group2Prefix=" + _group2Prefix +
           ",OperandSizePrefix=" + _hasOperandSizePrefix +
           ",AddressSizePrefix=" + _hasAddressSizePrefix +
           ",opcode1=" + _opcode1 +
           ",opcode2=" + _opcode2 +
           "]";
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof X86InstructionHeader) {
      final X86InstructionHeader header = (X86InstructionHeader) other;
      return _hasAddressSizePrefix == header._hasAddressSizePrefix &&
             _hasOperandSizePrefix == header._hasOperandSizePrefix &&
             _group1Prefix == header._group1Prefix &&
             _group2Prefix == header._group2Prefix &&
             _opcode1 == header._opcode1 &&
             _opcode2 == header._opcode2;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = _hasAddressSizePrefix ? -1 : 1;
    result *= _hasOperandSizePrefix ? 13 : -11;
    if (_group1Prefix != null) {
      result *= _group1Prefix.ordinal();
    }
    if (_group2Prefix != null) {
      result *= _group2Prefix.ordinal();
    }
    if (_opcode1 != null) {
      result *= _opcode1.ordinal();
    }
    if (_opcode2 != null) {
      result ^= _opcode2.ordinal();
    }
    if (_group1Prefix != null) {
      result += _group1Prefix.ordinal() * 1024;
    }
    if (_group2Prefix != null) {
      result += _group2Prefix.ordinal() * 73;
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

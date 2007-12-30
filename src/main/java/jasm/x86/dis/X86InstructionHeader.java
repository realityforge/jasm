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

  private final boolean _hasAddressSizePrefix;
  private final HexByte _rexPrefix;
  private final X86InstructionPrefix _group1Prefix;
  private final X86InstructionPrefix _group2Prefix;
  /**
   * This MUST be a object as the templates use the null version of
   * this to indicate that any operand size should match.
   */
  private final X86InstructionPrefix _operandSizePrefix;
  private final HexByte _opcode1;
  private HexByte _opcode2;
  //private final HexByte _opCode3;

  public X86InstructionHeader(final HexByte opcode1,
                              final HexByte opcode2,
                              final boolean hasAddressSizePrefix,
                              final X86InstructionPrefix operandSizePrefix,
                              final HexByte rexPrefix,
                              final X86InstructionPrefix group1Prefix,
                              final X86InstructionPrefix group2Prefix) {
    if (null == opcode1) throw new NullPointerException("opcode1");
    _hasAddressSizePrefix = hasAddressSizePrefix;
    _operandSizePrefix = operandSizePrefix;
    _rexPrefix = rexPrefix;
    _group1Prefix = group1Prefix;
    _group2Prefix = group2Prefix;
    _opcode1 = opcode1;
    _opcode2 = opcode2;
  }

  @Override
  public String toString() {
    return "X86InstructionHeader[rexPrefix=" + _rexPrefix +
           ",group1Prefix=" + _group1Prefix +
           ",group2Prefix=" + _group2Prefix +
           ",OperandSizePrefix=" + _operandSizePrefix +
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
             (_operandSizePrefix == header._operandSizePrefix) &&
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
    if (_operandSizePrefix != null) {
      result += _operandSizePrefix.ordinal() * 137;
    }
    if (_opcode2 != null) {
      result += _opcode2.ordinal() * 256;
    }
    if (_opcode1 != null) {
      result += _opcode1.ordinal();
    }
    return result;
  }

  public boolean hasAddressSizePrefix() {
    return _hasAddressSizePrefix;
  }

  public boolean hasOperandSizePrefix() {
    return null != _operandSizePrefix;
  }

  public HexByte rexPrefix() {
    return _rexPrefix;
  }

  public X86InstructionPrefix group1Prefix() {
    return _group1Prefix;
  }

  public X86InstructionPrefix group2Prefix() {
    return _group2Prefix;
  }

  public HexByte opcode1() {
    return _opcode1;
  }

  public HexByte opcode2() {
    return _opcode2;
  }

  //TODO: Fix this ugly hack - this class should be immutable but due to the way we currently
  //decode fp instructions it is not - eww!
  public void fixOpcode2(final HexByte opcode2) { _opcode2 = opcode2; }
}

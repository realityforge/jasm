/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86.dis2;

import jasm.util.HexByte;
import jasm.x86.X86InstructionPrefix;

public final class X86InstructionHeader {

  private final HexByte _rexPrefix;
  private final X86InstructionPrefix _group1Prefix;
  private final X86InstructionPrefix _group2Prefix;
  private final boolean _hasOperandSizePrefix;
  private final boolean _hasAddressSizePrefix;
  private final HexByte _opcode1;
  private final HexByte _opcode2;
  //private final HexByte _opCode3;

  public X86InstructionHeader(final HexByte opcode1,
                              final HexByte opcode2,
                              final boolean hasAddressSizePrefix,
                              final boolean hasOperandSizePrefix,
                              final HexByte rexPrefix,
                              final X86InstructionPrefix group1Prefix,
                              final X86InstructionPrefix group2Prefix) {
    if (null == opcode1) throw new NullPointerException("opcode1");
    _hasAddressSizePrefix = hasAddressSizePrefix;
    _hasOperandSizePrefix = hasOperandSizePrefix;
    _rexPrefix = rexPrefix;
    _group1Prefix = group1Prefix;
    _group2Prefix = group2Prefix;
    _opcode1 = opcode1;
    _opcode2 = opcode2;
  }

  public boolean hasAddressSizePrefix() { return _hasAddressSizePrefix; }

  public boolean hasOperandSizePrefix() { return _hasOperandSizePrefix; }

  public HexByte rexPrefix() { return _rexPrefix; }

  public X86InstructionPrefix group1Prefix() { return _group1Prefix; }

  public X86InstructionPrefix group2Prefix() { return _group2Prefix; }

  public HexByte opcode1() { return _opcode1; }

  public HexByte opcode2() { return _opcode2; }

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
}
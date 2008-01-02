/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.WordWidth;
import jasm.tools.InstructionDescription;
import jasm.util.HexByte;
import jasm.x86.X86InstructionPrefix;
import java.util.List;

public final class X86InstructionDescription
    extends InstructionDescription<X86InstructionDescription> {

  private boolean _isExternalOperandOrderingInverted = true;
  private WordWidth _defaultOperandSize = WordWidth.BITS_32;
  private X86InstructionPrefix _mandatoryPrefix;
  private WordWidth _requiredAddressSize;
  private WordWidth _requiredOperandSize;
  /** true if descriptor represenets a a prefix rather than an instruction. */
  private boolean _aPrefix;

  private final HexByte _opcode1;
  private final HexByte _opcode2;
  //private final HexByte _opcode3;

  public X86InstructionDescription(final HexByte opcode1,
                                   final HexByte opcode2,
                                   final List<Object> specifications) {
    super(null, specifications);
    _opcode1 = opcode1;
    _opcode2 = opcode2;
  }

  public HexByte opcode1() {
    return _opcode1;
  }

  public HexByte opcode2() {
    return _opcode2;
  }

  public boolean isExternalOperandOrderingInverted() {
    return _isExternalOperandOrderingInverted;
  }

  public void revertExternalOperandOrdering() {
    _isExternalOperandOrderingInverted = false;
  }

  public WordWidth defaultOperandSize() {
    return _defaultOperandSize;
  }

  public X86InstructionPrefix getMandatoryPrefix() {
    return _mandatoryPrefix;
  }

  public X86InstructionDescription setMandatoryPrefix(X86InstructionPrefix mandatoryPrefix) {
    _mandatoryPrefix = mandatoryPrefix;
    return this;
  }

  public X86InstructionDescription setDefaultOperandSize(WordWidth defaultOperandSize) {
    _defaultOperandSize = defaultOperandSize;
    return this;
  }

  public boolean isAPrefix() {
    return _aPrefix;
  }

  public X86InstructionDescription beAPrefix() {
    _aPrefix = true;
    beNotExternallyTestable();
    beNotDisassemblable();
    return this;
  }

  public final WordWidth requiredAddressSize() {
    return _requiredAddressSize;
  }

  public final X86InstructionDescription requireAddressSize(WordWidth requiredAddressSize) {
    _requiredAddressSize = requiredAddressSize;
    return this;
  }

  public final WordWidth requiredOperandSize() {
    return _requiredOperandSize;
  }

  public final X86InstructionDescription requireOperandSize(WordWidth requiredOperandSize) {
    _requiredOperandSize = requiredOperandSize;
    return this;
  }
}

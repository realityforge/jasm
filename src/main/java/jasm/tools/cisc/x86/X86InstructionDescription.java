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
import java.util.List;

public final class X86InstructionDescription
    extends InstructionDescription<X86InstructionDescription> {

  private boolean _isExternalOperandOrderingInverted = true;
  private WordWidth _defaultOperandSize = WordWidth.BITS_32;
  private X86InstructionPrefix _mandatoryPrefix;
  /** true if instruction is a prefix. */
  private boolean _aPrefix;

  public X86InstructionDescription(List<Object> specifications) {
    super(specifications);
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
    return this;
  }
}

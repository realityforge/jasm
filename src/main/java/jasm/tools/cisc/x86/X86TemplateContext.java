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

/** A bundle of choices one can make when creating a template. */
public final class X86TemplateContext implements Cloneable {
  private WordWidth _addressSizeAttribute;
  private WordWidth _operandSizeAttribute;
  private ModRMOpcode _modRMGroupOpcode;
  private ModCase _modCase;
  private RMCase _rmCase;
  private SibIndexCase _sibIndexCase;
  protected SibBaseCase _sibBaseCase;

  X86TemplateContext() {
  }

  public final WordWidth addressSizeAttribute() {
    return _addressSizeAttribute;
  }

  public final void setAddressSizeAttribute(WordWidth addressSizeAttribute) {
    _addressSizeAttribute = addressSizeAttribute;
  }

  public final WordWidth operandSizeAttribute() {
    return _operandSizeAttribute;
  }

  public final void setOperandSizeAttribute(WordWidth operandSizeAttribute) {
    _operandSizeAttribute = operandSizeAttribute;
  }

  public final ModRMOpcode modRMGroupOpcode() {
    return _modRMGroupOpcode;
  }

  public final void setModRMGroupOpcode(ModRMOpcode modRMGroupOpcode) {
    _modRMGroupOpcode = modRMGroupOpcode;
  }

  public final ModCase modCase() {
    return _modCase;
  }

  public final void setModCase(ModCase modCase) {
    _modCase = modCase;
  }

  public final RMCase rmCase() {
    return _rmCase;
  }

  public final void setRMCase(RMCase rmCase) {
    _rmCase = rmCase;
  }

  public final SibIndexCase sibIndexCase() {
    return _sibIndexCase;
  }

  public final void setSibIndexCase(SibIndexCase sibIndexCase) {
    _sibIndexCase = sibIndexCase;
  }

  public final SibBaseCase sibBaseCase() {
    return _sibBaseCase;
  }

  public final void setSibBaseCase(SibBaseCase sibBaseCase) {
    _sibBaseCase = sibBaseCase;
  }

  @Override
  public final X86TemplateContext clone() {
    try {
      return (X86TemplateContext) super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new IllegalStateException("clone() failed", cloneNotSupportedException);
    }
  }

  @Override
  public final String toString() {
    return "<Context: " + _addressSizeAttribute + ", " + _operandSizeAttribute + ", " + _modRMGroupOpcode + ", " + _modCase + ", " + _rmCase + ", " + _sibIndexCase + ", " + _sibBaseCase + ">";
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools;

import jasm.tools.cisc.x86.X86InstructionDescriptionVisitor;
import jasm.tools.risc.RiscInstructionDescriptionVisitor;
import jasm.tools.risc.field.InputOperandField;
import jasm.util.StaticLoophole;
import java.util.Iterator;
import java.util.List;

/**
 * A sequence of objects that describe group of closely related instructions. An
 * instruction template is created for each instruction in the group.
 * <p/>
 * The types of objects that an instruction description contains
 * depend on the whether the underlying platform is CISC or RISC.
 * The types for these two instruction categories are enumerated by
 * the {@code visit...} methods in the {@link RiscInstructionDescriptionVisitor}
 * and {@link X86InstructionDescriptionVisitor} classes.
 */
@SuppressWarnings({"RedundantTypeArguments"})
public abstract class InstructionDescription<InstructionDescription_Type extends InstructionDescription<InstructionDescription_Type>>
    implements Iterable<Object>, Cloneable {

  private static int _nextSerial;
  private int _serial;
  private String _externalName;
  private boolean _isDisassemblable = true;
  private boolean _isExternallyTestable = true;
  /** The components of the description. */
  private final List<Object> _specifications;

  protected InstructionDescription( List<Object> specifications) {
    _specifications = specifications;
    _serial = _nextSerial++;
  }

  public String toString() {
    return "[InstructionDescription " + _externalName + " specifications=" + _specifications + "]";
  }

  public final int serial() {
    return _serial;
  }

  /** @return the objects from which this description is composed */
  public final List<Object> specifications() {
    return _specifications;
  }

  public final String externalName() {
    return _externalName;
  }

  public final InstructionDescription_Type setExternalName(String externalName) {
    _externalName = externalName;
    return StaticLoophole.<InstructionDescription_Type>cast(this);
  }

  /**
   * Determines if the templates created from the description can be recovered from an assembled instruction.
   * This is almost always possible. One example where it isn't is an instruction description that
   * has a parameter that is not correlated one-to-one with some bits in the encoded instruction.
   * In RISC architectures, this will be any instruction that has at least one {@link InputOperandField}
   * parameter.
   */
  public final boolean isDisassemblable() {
    return _isDisassemblable;
  }

  public final InstructionDescription_Type beNotDisassemblable() {
    _isDisassemblable = false;
    return StaticLoophole.<InstructionDescription_Type>cast(this);
  }

  public final boolean isExternallyTestable() {
    return _isExternallyTestable;
  }

  public final InstructionDescription_Type beNotExternallyTestable() {
    _isExternallyTestable = false;
    return StaticLoophole.<InstructionDescription_Type>cast(this);
  }

  public final Iterator<Object> iterator() {
    return _specifications.iterator();
  }

  @Override
  public final InstructionDescription clone() {
    try {
      final InstructionDescription clone = (InstructionDescription) super.clone();
      clone._serial = ++_nextSerial;
      return clone;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new IllegalStateException(cloneNotSupportedException);
    }
  }

  @Override
  public final int hashCode() {
    return _serial;
  }

  @Override
  public final boolean equals(Object object) {
    return object instanceof InstructionDescription && _serial == ((InstructionDescription) object)._serial;
  }
}

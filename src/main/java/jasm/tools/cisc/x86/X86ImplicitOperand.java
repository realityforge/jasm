/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.Argument;
import jasm.tools.ExternalPresence;
import jasm.tools.Immediate8Argument;
import jasm.tools.ImplicitOperand;

/**
 * An operand that is already implicit in the machine instruction,
 * without requiring an assembler method parameter.
 */
public final class X86ImplicitOperand
    extends X86Operand
    implements ImplicitOperand {

  private final ExternalPresence _externalPresence;
  private final Argument _argument;

  public X86ImplicitOperand(Designation designation, ExternalPresence externalPresence, Argument argument) {
    super(designation);
    _externalPresence = externalPresence;
    _argument = argument;
  }

  public final ExternalPresence externalPresence() {
    return _externalPresence;
  }

  public final Class type() {
    return _argument.getClass();
  }

  public final Argument argument() {
    return _argument;
  }

  public final String name() {
    if (_argument instanceof Enum) {
      final Enum enumerable = (Enum) _argument;
      return enumerable.name();
    }
    final Immediate8Argument immediate8Argument = (Immediate8Argument) _argument;
    assert immediate8Argument.value() > 0;
    return immediate8Argument.signedExternalValue();
  }

  @Override
  public final String toString() {
    return "<ImplicitOperand: " + _argument.externalValue() + ">";
  }
}

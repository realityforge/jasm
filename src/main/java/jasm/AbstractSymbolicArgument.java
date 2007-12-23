/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import jasm.util.NamedField;

/**
 * This class provides a skeletal implementation of the {@link SymbolicArgument} interface, to minimize the
 * effort required to implement this interface.
 */
public abstract class AbstractSymbolicArgument
    extends NamedField
    implements SymbolicArgument {

  private final int _value;

  protected AbstractSymbolicArgument(String name, int value) {
    super(name);
    _value = value;
  }

  protected AbstractSymbolicArgument(int value) {
    this(null, value);
  }

  public final int value() {
    return _value;
  }

  public String externalValue() {
    return "%" + name().toLowerCase();
  }

  public final long asLong() {
    return value();
  }

  public final String disassembledValue() {
    return externalValue();
  }

  @Override
  public String toString() {
    return name();
  }
}

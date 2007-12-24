/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import jasm.WordWidth;

public final class Immediate16Argument extends ImmediateArgument {

  private short _value;

  public Immediate16Argument(short value) {
    _value = value;
  }

  @Override
  public final WordWidth width() {
    return WordWidth.BITS_16;
  }

  public final short value() {
    return _value;
  }

  public final long asLong() {
    return value();
  }

  public final String externalValue() {
    return "0x" + Integer.toHexString(_value & 0xffff);
  }

  public final String disassembledValue() {
    return "0x" + String.format("%X", _value);
  }

  @Override
  public final String signedExternalValue() {
    return Integer.toString(_value);
  }

  @Override
  public final Object boxedJavaValue() {
    return new Short(_value);
  }

  @Override
  public final boolean equals(Object other) {
    if (other instanceof Immediate16Argument) {
      final Immediate16Argument argument = (Immediate16Argument) other;
      return _value == argument._value;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return _value;
  }
}

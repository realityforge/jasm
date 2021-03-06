/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86;

import jasm.EnumerableArgument;
import jasm.SymbolSet;

public enum ControlRegister
    implements EnumerableArgument {

  CR0(0), CR2(2), CR3(3);

  public static final SymbolSet<ControlRegister> SYMBOLS = SymbolSet.fromEnum(ControlRegister.class);

  private final int _number;

  private ControlRegister(int number) {
    _number = number;
  }

  public int value() {
    return _number;
  }

  public long asLong() {
    return value();
  }

  public String externalValue() {
    return "%" + name().toLowerCase();
  }

  public String disassembledValue() {
    return name().toLowerCase();
  }
}

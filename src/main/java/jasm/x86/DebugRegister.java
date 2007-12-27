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

public enum DebugRegister
    implements EnumerableArgument {
  DR0(0), DR1(1), DR2(2), DR3(3), DR6(6), DR7(7);

  public static final SymbolSet<DebugRegister> SYMBOLS = SymbolSet.fromEnum(DebugRegister.class);

  private final int _number;

  private DebugRegister(int number) {
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

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

public enum Scale implements EnumerableArgument {

  SCALE_1, SCALE_2, SCALE_4, SCALE_8;

  public int value() {
    return ordinal();
  }

  public long asLong() {
    return value();
  }

  public String externalValue() {
    return name().substring(name().length() - 1);
  }

  public String disassembledValue() {
    return name().substring(name().length() - 1);
  }

  public static final SymbolSet<Scale> SYMBOLS = SymbolSet.fromEnum(Scale.class);
}

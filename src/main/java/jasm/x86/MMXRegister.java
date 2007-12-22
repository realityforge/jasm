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
import jasm.util.SymbolSet;

/**
 * @author Bernd Mathiske
 */
public enum MMXRegister implements EnumerableArgument {

  MM0, MM1, MM2, MM3, MM4, MM5, MM6, MM7;

  public int value() {
    return ordinal();
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

  public static final SymbolSet<MMXRegister> SYMBOLS = SymbolSet.fromEnum(MMXRegister.class);
}

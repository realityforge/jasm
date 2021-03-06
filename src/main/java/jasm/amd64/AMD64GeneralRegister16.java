/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64;

import jasm.SymbolSet;
import jasm.WordWidth;
import jasm.x86.GeneralRegister;

public enum AMD64GeneralRegister16
    implements GeneralRegister {
  // Note: keep the order such that 'value()' can rely on ordinals:
  AX, CX, DX, BX, SP, BP, SI, DI, R8W, R9W, R10W, R11W, R12W, R13W, R14W, R15W;

  public static final SymbolSet<AMD64GeneralRegister16> SYMBOLS = SymbolSet.fromEnum(AMD64GeneralRegister16.class);

  public static AMD64GeneralRegister16 from(GeneralRegister generalRegister) {
    return values()[generalRegister.id()];
  }

  public WordWidth width() {
    return WordWidth.BITS_16;
  }

  public int value() {
    return ordinal();
  }

  public int id() {
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
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.amd64;

import jasm.WordWidth;
import jasm.util.SymbolSet;
import jasm.x86.GeneralRegister;

/**
 * Aliases for 64-bit AMD64 general registers to be used as index registers.
 *
 * @author Bernd Mathiske
 */
public enum AMD64IndexRegister64 implements GeneralRegister {

  RAX_INDEX,
  RCX_INDEX,
  RDX_INDEX,
  RBX_INDEX,
  // no RSP_INDEX!
  RBP_INDEX,
  RSI_INDEX,
  RDI_INDEX,
  R8_INDEX,
  R9_INDEX,
  R10_INDEX,
  R11_INDEX,
  R12_INDEX,
  R13_INDEX,
  R14_INDEX,
  R15_INDEX;

  public static AMD64IndexRegister64 from(GeneralRegister generalRegister) {
    int ordinal = generalRegister.id();
    if (ordinal >= AMD64GeneralRegister64.RSP.id()) {
      ordinal--;
    }
    return values()[ordinal];
  }

  public int id() {
    int ordinal = ordinal();
    if (ordinal >= AMD64GeneralRegister64.RSP.id()) {
      ordinal++;
    }
    return ordinal;
  }

  public WordWidth width() {
    return WordWidth.BITS_64;
  }

  public int value() {
    return id();
  }

  public long asLong() {
    return value();
  }

  public String externalValue() {
    return AMD64GeneralRegister64.from(this).externalValue();
  }

  public String disassembledValue() {
    return AMD64GeneralRegister64.from(this).disassembledValue();
  }

  public static final SymbolSet<AMD64IndexRegister64> SYMBOLS = SymbolSet.fromEnum(AMD64IndexRegister64.class);
}

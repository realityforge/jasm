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
import jasm.SymbolSet;
import jasm.x86.GeneralRegister;
import jasm.x86.IndirectRegister;

/**
 * Aliases for 64-bit AMD64 general registers to be used for indirect addressing.
 */
public enum AMD64IndirectRegister64 implements GeneralRegister, IndirectRegister {

  RAX_INDIRECT,
  RCX_INDIRECT,
  RDX_INDIRECT,
  RBX_INDIRECT,
  RSP_INDIRECT,
  RBP_INDIRECT,
  RSI_INDIRECT,
  RDI_INDIRECT,
  R8_INDIRECT,
  R9_INDIRECT,
  R10_INDIRECT,
  R11_INDIRECT,
  R12_INDIRECT,
  R13_INDIRECT,
  R14_INDIRECT,
  R15_INDIRECT;

  public static AMD64IndirectRegister64 from(GeneralRegister generalRegister) {
    return values()[generalRegister.id()];
  }

  public int id() {
    return ordinal();
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

  public static final SymbolSet<AMD64IndirectRegister64> SYMBOLS = SymbolSet.fromEnum(AMD64IndirectRegister64.class);
}

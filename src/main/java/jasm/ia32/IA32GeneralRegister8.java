/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ia32;

import jasm.SymbolSet;
import jasm.WordWidth;
import jasm.x86.GeneralRegister;

public enum IA32GeneralRegister8 implements GeneralRegister {
  // Note: keep the order such that 'value()' can rely on ordinals:
  AL, CL, DL, BL, AH, CH, DH, BH;

  private static final IA32GeneralRegister8[] LOW_REGISTERS = {AL, CL, DL, BL};

  public static IA32GeneralRegister8 lowFrom(GeneralRegister generalRegister) {
    return LOW_REGISTERS[generalRegister.id()];
  }

  private static final IA32GeneralRegister8[] HIGH_REGISTERS = {AH, CH, DH, BH};

  public static IA32GeneralRegister8 highFrom(GeneralRegister generalRegister) {
    return HIGH_REGISTERS[generalRegister.id()];
  }

  public WordWidth width() {
    return WordWidth.BITS_8;
  }

  public int value() {
    return ordinal();
  }

  public int id() {
    return ordinal() % 4;
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

  public static final SymbolSet<IA32GeneralRegister8> SYMBOLS = SymbolSet.fromEnum(IA32GeneralRegister8.class);
}

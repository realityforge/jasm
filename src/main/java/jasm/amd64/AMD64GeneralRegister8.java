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

public enum AMD64GeneralRegister8 implements GeneralRegister {

  AL(0, false),
  CL(1, false),
  DL(2, false),
  BL(3, false),
  SPL(4, false),
  BPL(5, false),
  SIL(6, false),
  DIL(7, false),
  R8B(8, false),
  R9B(9, false),
  R10B(10, false),
  R11B(11, false),
  R12B(12, false),
  R13B(13, false),
  R14B(14, false),
  R15B(15, false),
  AH(4, true),
  CH(5, true),
  DH(6, true),
  BH(7, true);

  private final int _value;
  private final boolean _isHighByte;

  private AMD64GeneralRegister8(int value, boolean isHighByte) {
    _value = value;
    _isHighByte = isHighByte;
  }

  public static AMD64GeneralRegister8 lowFrom(GeneralRegister generalRegister) {
    return values()[generalRegister.id()];
  }

  public static AMD64GeneralRegister8 highFrom(GeneralRegister generalRegister) {
    return values()[generalRegister.id() + 16];
  }

  public static AMD64GeneralRegister8 fromValue(int value, boolean isRexBytePresent) {
    if (!isRexBytePresent && value >= AH._value) {
      return values()[(value - AH._value) + AH.ordinal()];
    }
    return SYMBOLS.fromValue(value);
  }

  public boolean isHighByte() {
    return _isHighByte;
  }

  public boolean requiresRexPrefix() {
    return _value >= 4 && !_isHighByte;
  }

  public WordWidth width() {
    return WordWidth.BITS_8;
  }

  public int id() {
    return ordinal() % 16;
  }

  public int value() {
    return _value;
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

  public static final SymbolSet<AMD64GeneralRegister8> SYMBOLS = SymbolSet.fromEnum(AMD64GeneralRegister8.class);
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc;

import jasm.AbstractSymbolicArgument;
import jasm.SymbolSet;

/**
 * The class defining the symbolic identifiers for the privileged registers
 * accessed by the Read Privileged Register and Write Privileged Register
 * instructions.
 */
public class PrivilegedRegister extends AbstractSymbolicArgument {

  PrivilegedRegister(int value) {
    super(value);
  }

  public static class Writable extends PrivilegedRegister {
    Writable(int value) {
      super(value);
    }
  }

  public static final Writable TPC = new Writable(0);
  public static final Writable TNPC = new Writable(1);
  public static final Writable TSTATE = new Writable(2);
  public static final Writable TT = new Writable(3);
  public static final Writable TTICK = new Writable(4) {
    @Override
    public String externalValue() {
      return "%tick";
    }
  };
  public static final Writable TBA = new Writable(5);
  public static final Writable PSTATE = new Writable(6);
  public static final Writable TL = new Writable(7);
  public static final Writable PIL = new Writable(8);
  public static final Writable CWP = new Writable(9);
  public static final Writable CANSAVE = new Writable(10);
  public static final Writable CANRESTORE = new Writable(11);
  public static final Writable CLEANWIN = new Writable(12);
  public static final Writable OTHERWIN = new Writable(13);
  public static final Writable WSTATE = new Writable(14);
  public static final PrivilegedRegister FQ = new PrivilegedRegister(15);
  public static final PrivilegedRegister VER = new PrivilegedRegister(31);

  public static final SymbolSet<PrivilegedRegister> SYMBOLS = SymbolSet.fromStaticFields(PrivilegedRegister.class);
  public static final SymbolSet<Writable> WRITE_ONLY_SYMBOLS = SymbolSet.fromStaticFields(PrivilegedRegister.class, Writable.class);
}

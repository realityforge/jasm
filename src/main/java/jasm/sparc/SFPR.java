/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc;

import jasm.SymbolSet;
import jasm.SymbolicArgument;
import jasm.util.Nameable;

/** The single-precision (32-bit) floating-point registers. */
public interface SFPR extends Nameable, SymbolicArgument {
  SFPR F0 = FPR.F0;
  SFPR F1 = FPR.F1;
  SFPR F2 = FPR.F2;
  SFPR F3 = FPR.F3;
  SFPR F4 = FPR.F4;
  SFPR F5 = FPR.F5;
  SFPR F6 = FPR.F6;
  SFPR F7 = FPR.F7;
  SFPR F8 = FPR.F8;
  SFPR F9 = FPR.F9;
  SFPR F10 = FPR.F10;
  SFPR F11 = FPR.F11;
  SFPR F12 = FPR.F12;
  SFPR F13 = FPR.F13;
  SFPR F14 = FPR.F14;
  SFPR F15 = FPR.F15;
  SFPR F16 = FPR.F16;
  SFPR F17 = FPR.F17;
  SFPR F18 = FPR.F18;
  SFPR F19 = FPR.F19;
  SFPR F20 = FPR.F20;
  SFPR F21 = FPR.F21;
  SFPR F22 = FPR.F22;
  SFPR F23 = FPR.F23;
  SFPR F24 = FPR.F24;
  SFPR F25 = FPR.F25;
  SFPR F26 = FPR.F26;
  SFPR F27 = FPR.F27;
  SFPR F28 = FPR.F28;
  SFPR F29 = FPR.F29;
  SFPR F30 = FPR.F30;
  SFPR F31 = FPR.F31;

  SymbolSet<SFPR> SYMBOLS = SymbolSet.fromStaticFields(SFPR.class);
}

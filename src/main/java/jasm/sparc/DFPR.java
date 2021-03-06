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

/** The double-precision (64-bit) floating-point registers. */
public interface DFPR extends Nameable, SymbolicArgument {

  DFPR F0 = FPR.F0;
  DFPR F2 = FPR.F2;
  DFPR F4 = FPR.F4;
  DFPR F6 = FPR.F6;
  DFPR F8 = FPR.F8;
  DFPR F10 = FPR.F10;
  DFPR F12 = FPR.F12;
  DFPR F14 = FPR.F14;
  DFPR F16 = FPR.F16;
  DFPR F18 = FPR.F18;
  DFPR F20 = FPR.F20;
  DFPR F22 = FPR.F22;
  DFPR F24 = FPR.F24;
  DFPR F26 = FPR.F26;
  DFPR F28 = FPR.F28;
  DFPR F30 = FPR.F30;
  DFPR F32 = FPR.F32;
  DFPR F34 = FPR.F34;
  DFPR F36 = FPR.F36;
  DFPR F38 = FPR.F38;
  DFPR F40 = FPR.F40;
  DFPR F42 = FPR.F42;
  DFPR F44 = FPR.F44;
  DFPR F46 = FPR.F46;
  DFPR F48 = FPR.F48;
  DFPR F50 = FPR.F50;
  DFPR F52 = FPR.F52;
  DFPR F54 = FPR.F54;
  DFPR F56 = FPR.F56;
  DFPR F58 = FPR.F58;
  DFPR F60 = FPR.F60;
  DFPR F62 = FPR.F62;

  SymbolSet<DFPR> SYMBOLS = SymbolSet.fromStaticFields(DFPR.class);
}

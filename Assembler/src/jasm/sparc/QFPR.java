/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc;

import jasm.util.StaticFieldName;
import jasm.util.Symbolizer;

/**
 * The quad-precision (128-bit) floating-point registers.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public interface QFPR extends DFPR, StaticFieldName {
    QFPR F0 = FPR.F0;
    QFPR F4 = FPR.F4;
    QFPR F8 = FPR.F8;
    QFPR F12 = FPR.F12;
    QFPR F16 = FPR.F16;
    QFPR F20 = FPR.F20;
    QFPR F24 = FPR.F24;
    QFPR F28 = FPR.F28;
    QFPR F32 = FPR.F32;
    QFPR F36 = FPR.F36;
    QFPR F40 = FPR.F40;
    QFPR F44 = FPR.F44;
    QFPR F48 = FPR.F48;
    QFPR F52 = FPR.F52;
    QFPR F56 = FPR.F56;
    QFPR F60 = FPR.F60;

    Symbolizer<QFPR> SYMBOLIZER = Symbolizer.Static.initialize(QFPR.class);
}

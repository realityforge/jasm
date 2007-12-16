/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8a5759a4-1aa6-4ecd-ab31-db69dda6baa4*/
package com.sun.max.asm.sparc;

import com.sun.max.lang.*;
import com.sun.max.util.*;

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

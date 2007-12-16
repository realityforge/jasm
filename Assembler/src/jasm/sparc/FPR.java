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

/**
 * The class defining the symbolic identifiers for the floating-point registers.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
class FPR extends AbstractSymbolicArgument {

    FPR(int value) {
        super(value);
    }

    public static final class Single extends FPR implements SFPR {
        private Single(int value) {
            super(value);
        }
    }

    public static final class Double extends FPR implements DFPR {
        private Double(int value) {
            super(value);
        }
    }

    public static final class SingleDouble extends FPR implements SFPR, DFPR {
        private SingleDouble(int value) {
            super(value);
        }
    }

    public static final class DoubleQuadruple extends FPR implements DFPR, QFPR {
        private DoubleQuadruple(int value) {
            super(value);
        }
    }

    public static final class SingleDoubleQuadruple extends FPR implements SFPR, DFPR, QFPR {
        private SingleDoubleQuadruple(int value) {
            super(value);
        }
    }

    public static final SingleDoubleQuadruple  F0 = new SingleDoubleQuadruple(0);
    public static final Single                 F1 = new Single(1);
    public static final SingleDouble           F2 = new SingleDouble(2);
    public static final Single                 F3 = new Single(3);
    public static final SingleDoubleQuadruple  F4 = new SingleDoubleQuadruple(4);
    public static final Single                 F5 = new Single(5);
    public static final SingleDouble           F6 = new SingleDouble(6);
    public static final Single                 F7 = new Single(7);
    public static final SingleDoubleQuadruple  F8 = new SingleDoubleQuadruple(8);
    public static final Single                 F9 = new Single(9);
    public static final SingleDouble          F10 = new SingleDouble(10);
    public static final Single                F11 = new Single(11);
    public static final SingleDoubleQuadruple F12 = new SingleDoubleQuadruple(12);
    public static final Single                F13 = new Single(13);
    public static final SingleDouble          F14 = new SingleDouble(14);
    public static final Single                F15 = new Single(15);
    public static final SingleDoubleQuadruple F16 = new SingleDoubleQuadruple(16);
    public static final Single                F17 = new Single(17);
    public static final SingleDouble          F18 = new SingleDouble(18);
    public static final Single                F19 = new Single(19);
    public static final SingleDoubleQuadruple F20 = new SingleDoubleQuadruple(20);
    public static final Single                F21 = new Single(21);
    public static final SingleDouble          F22 = new SingleDouble(22);
    public static final Single                F23 = new Single(23);
    public static final SingleDoubleQuadruple F24 = new SingleDoubleQuadruple(24);
    public static final Single                F25 = new Single(25);
    public static final SingleDouble          F26 = new SingleDouble(26);
    public static final Single                F27 = new Single(27);
    public static final SingleDoubleQuadruple F28 = new SingleDoubleQuadruple(28);
    public static final Single                F29 = new Single(29);
    public static final SingleDouble          F30 = new SingleDouble(30);
    public static final Single                F31 = new Single(31);
    public static final       DoubleQuadruple F32 = new DoubleQuadruple(32);
    public static final       Double          F34 = new Double(34);
    public static final       DoubleQuadruple F36 = new DoubleQuadruple(36);
    public static final       Double          F38 = new Double(38);
    public static final       DoubleQuadruple F40 = new DoubleQuadruple(40);
    public static final       Double          F42 = new Double(42);
    public static final       DoubleQuadruple F44 = new DoubleQuadruple(44);
    public static final       Double          F46 = new Double(46);
    public static final       DoubleQuadruple F48 = new DoubleQuadruple(48);
    public static final       Double          F50 = new Double(50);
    public static final       DoubleQuadruple F52 = new DoubleQuadruple(52);
    public static final       Double          F54 = new Double(54);
    public static final       DoubleQuadruple F56 = new DoubleQuadruple(56);
    public static final       Double          F58 = new Double(58);
    public static final       DoubleQuadruple F60 = new DoubleQuadruple(60);
    public static final       Double          F62 = new Double(62);
}

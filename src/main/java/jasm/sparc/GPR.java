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
 * The class defining the symbolic identifiers for the general purpose registers.
 */
public class GPR extends AbstractSymbolicArgument {

    GPR(int value) {
        super(value);
    }

    public static final class Even extends GPR {
        private Even(int value) {
            super(value);
        }
    }

    public static final Even G0 = new Even(0);
    public static final  GPR G1 = new  GPR(1);
    public static final Even G2 = new Even(2);
    public static final  GPR G3 = new  GPR(3);
    public static final Even G4 = new Even(4);
    public static final  GPR G5 = new  GPR(5);
    public static final Even G6 = new Even(6);
    public static final  GPR G7 = new  GPR(7);
    public static final Even O0 = new Even(8);
    public static final  GPR O1 = new  GPR(9);
    public static final Even O2 = new Even(10);
    public static final  GPR O3 = new  GPR(11);
    public static final Even O4 = new Even(12);
    public static final  GPR O5 = new  GPR(13);
    public static final Even O6 = new Even(14);
    public static final  GPR O7 = new  GPR(15);
    public static final Even L0 = new Even(16);
    public static final  GPR L1 = new  GPR(17);
    public static final Even L2 = new Even(18);
    public static final  GPR L3 = new  GPR(19);
    public static final Even L4 = new Even(20);
    public static final  GPR L5 = new  GPR(21);
    public static final Even L6 = new Even(22);
    public static final  GPR L7 = new  GPR(23);
    public static final Even I0 = new Even(24);
    public static final  GPR I1 = new  GPR(25);
    public static final Even I2 = new Even(26);
    public static final  GPR I3 = new  GPR(27);
    public static final Even I4 = new Even(28);
    public static final  GPR I5 = new  GPR(29);
    public static final Even I6 = new Even(30);
    public static final  GPR I7 = new  GPR(31);

    public static final SymbolSet<GPR> SYMBOLS = SymbolSet.fromStaticFields(GPR.class);
    public static final SymbolSet<Even> EVEN_SYMBOLS = SymbolSet.fromStaticFields(GPR.class, Even.class);
}

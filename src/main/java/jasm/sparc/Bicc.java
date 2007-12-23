/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc;

import jasm.NameSuffixSymbolicArgument;
import jasm.util.SymbolSet;

/**
 * The argument to a Branch on Integer Condition Code instruction specifying
 * the conditional test to be performed.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class Bicc extends NameSuffixSymbolicArgument implements Predicate<ICCOperand, Bicc> {
    private Bicc _negation;

    private Bicc(int value) {
        super(value);
    }
    private Bicc(int value, Bicc negation) {
        this(value);
        _negation = negation;
        negation._negation = this;
    }

    public static final Bicc A = new Bicc(8);
    public static final Bicc N = new Bicc(0, A);
    public static final Bicc NE = new Bicc(9);
    public static final Bicc E = new Bicc(1, NE);
    public static final Bicc G = new Bicc(10);
    public static final Bicc LE = new Bicc(2, G);
    public static final Bicc GE = new Bicc(11);
    public static final Bicc L = new Bicc(3, GE);
    public static final Bicc GU = new Bicc(12);
    public static final Bicc LEU = new Bicc(4, GU);
    public static final Bicc CC = new Bicc(13);
    public static final Bicc CS = new Bicc(5, CC);
    public static final Bicc POS = new Bicc(14);
    public static final Bicc NEG = new Bicc(6, POS);
    public static final Bicc VC = new Bicc(15);
    public static final Bicc VS = new Bicc(7, VC);

    public static final SymbolSet<Bicc> SYMBOLS = SymbolSet.fromStaticFields(Bicc.class);

    public Bicc negate() {
        return _negation;
    }

}

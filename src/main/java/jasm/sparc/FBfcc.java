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
 * The argument to a Branch on Floating-Point Condition Code instruction specifying
 * the conditional test to be performed.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class FBfcc extends NameSuffixSymbolicArgument implements Predicate<FCCOperand, FBfcc> {
    private FBfcc _negation;

    private FBfcc(int value) {
        super(value);
    }
    private FBfcc(int value, FBfcc negation) {
        this(value);
        _negation = negation;
        negation._negation = this;
    }

    public static final FBfcc A = new FBfcc(8);
    public static final FBfcc N = new FBfcc(0, A);
    public static final FBfcc U = new FBfcc(7);
    public static final FBfcc G = new FBfcc(6);
    public static final FBfcc UG = new FBfcc(5);
    public static final FBfcc L = new FBfcc(4);
    public static final FBfcc UL = new FBfcc(3);
    public static final FBfcc LG = new FBfcc(2);
    public static final FBfcc NE = new FBfcc(1);
    public static final FBfcc E = new FBfcc(9, NE);
    public static final FBfcc UE = new FBfcc(10, LG);
    public static final FBfcc GE = new FBfcc(11, UL);
    public static final FBfcc UGE = new FBfcc(12, L);
    public static final FBfcc LE = new FBfcc(13, UG);
    public static final FBfcc ULE = new FBfcc(14, G);
    public static final FBfcc O = new FBfcc(15, U);

    public static final SymbolSet<FBfcc> SYMBOLS = SymbolSet.initialize(FBfcc.class);
    public FBfcc negate() { return _negation; }
}

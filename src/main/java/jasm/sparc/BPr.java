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
import jasm.SymbolSet;

/**
 * The argument to a Branch on Integer Register with Prediction instruction specifying
 * the conditional test to be performed.
 */
public final class BPr extends NameSuffixSymbolicArgument {

    private BPr(int value) {
        super(value);
    }

    public static final BPr Z = new BPr(1);
    public static final BPr LEZ = new BPr(2);
    public static final BPr LZ = new BPr(3);
    public static final BPr NZ = new BPr(5);
    public static final BPr GZ = new BPr(6);
    public static final BPr GEZ = new BPr(7);

    public static final SymbolSet<BPr> SYMBOLS = SymbolSet.fromStaticFields(BPr.class);

}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc;

import jasm.OptionSuffixSymbolicArgument;
import jasm.util.Symbolizer;

/**
 * An optional (suffix) argument to a branch with prediction assembler instruction
 * specifying if the prediction bit is to be set. For example:
 * <pre>bgu,pt <i>i_or_x_cc</i>, <i>label</i></pre>
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class BranchPredictionBit extends OptionSuffixSymbolicArgument {

    private BranchPredictionBit(int value, String externalMnemonicSuffix) {
        super(value, externalMnemonicSuffix);
    }

    /**
     * The prediction bit is not set, indicating that the branch is not likely to be taken.
     */
    public static final BranchPredictionBit PN = new BranchPredictionBit(0, ",pn");

    /**
     * The prediction bit is set, indicating that the branch is likely to be taken.
     */
    public static final BranchPredictionBit PT = new BranchPredictionBit(1, ",pt");

    public static final Symbolizer<BranchPredictionBit> SYMBOLIZER = Symbolizer.Static.initialize(BranchPredictionBit.class);
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=089c1d28-9bd1-4cac-9a14-237d42a4442a*/
package com.sun.max.asm.sparc;

import com.sun.max.asm.OptionSuffixSymbolicArgument;
import com.sun.max.util.Symbolizer;

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

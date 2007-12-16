/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=dc4d7f34-2a2a-45f5-9d72-59047c9780e2*/
package jasm.ppc;

import jasm.OptionSuffixSymbolicArgument;
import jasm.util.Symbolizer;

/**
 * The branch prediction values for the conditional branches whose encoding includes
 * a hint about whether the branch is likely to be taken or is likely not to be taken.
 *
 * @author Doug Simon
 */
public final class BranchPredictionBits extends OptionSuffixSymbolicArgument {

    private BranchPredictionBits(int value, String externalMnemonicSuffix) {
        super(value, externalMnemonicSuffix);
    }

    /**
     * No hint is given.
     */
    public static final BranchPredictionBits NONE = new BranchPredictionBits(0, "");

    /**
     * The branch is very likely to be taken.
     */
    public static final BranchPredictionBits PT = new BranchPredictionBits(3, "++");

    /**
     * The branch is very likely <b>not</b> to be taken.
     */
    public static final BranchPredictionBits PN = new BranchPredictionBits(2, "--");

    public static final Symbolizer<BranchPredictionBits> SYMBOLIZER = Symbolizer.Static.initialize(BranchPredictionBits.class);
}

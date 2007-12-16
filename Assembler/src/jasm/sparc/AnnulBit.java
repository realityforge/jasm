/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6306ad80-1588-479f-86a8-731a35bb91c5*/
package jasm.sparc;

import jasm.OptionSuffixSymbolicArgument;
import jasm.util.Symbolizer;

/**
 * An optional (suffix) argument to a branch assembler instruction specifying
 * if the instruction in the delay slot of the branch will be executed. For example:
 * <pre>bne,a <i>label</i></pre>
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class AnnulBit extends OptionSuffixSymbolicArgument {

    private AnnulBit(int value, String externalMnemonicSuffix) {
        super(value, externalMnemonicSuffix);
    }

    /**
     * The annul bit is not set.
     */
    public static final AnnulBit NO_A = new AnnulBit(0, "");

    /**
     * The annul bit is set.
     */
    public static final AnnulBit A = new AnnulBit(1, ",a");

    public static final Symbolizer<AnnulBit> SYMBOLIZER = Symbolizer.Static.initialize(AnnulBit.class);

}

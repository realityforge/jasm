/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e98abb6a-8c56-413e-8974-7aa3969f220c*/
package jasm.sparc;

import jasm.AbstractSymbolicArgument;
import jasm.util.Symbolizer;

/**
 * The argument to a Branch on Floating-Point Condition Code with Prediction instruction specifying
 * the conditional test to be performed.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class FCCOperand extends AbstractSymbolicArgument implements ConditionCodeRegister {

    private FCCOperand(int value) {
        super(value);
    }

    public static final FCCOperand FCC0 = new FCCOperand(0);
    public static final FCCOperand FCC1 = new FCCOperand(1);
    public static final FCCOperand FCC2 = new FCCOperand(2);
    public static final FCCOperand FCC3 = new FCCOperand(3);

    public static final Symbolizer<FCCOperand> SYMBOLIZER = Symbolizer.Static.initialize(FCCOperand.class);
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.sparc;

import jasm.AbstractSymbolicArgument;
import jasm.util.Symbolizer;

/**
 * The argument to a Branch on Integer Condition Code with Prediction instruction specifying
 * the conditional test to be performed.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class ICCOperand extends AbstractSymbolicArgument implements ConditionCodeRegister {

    private ICCOperand(int value) {
        super(value);
    }

    public static final ICCOperand ICC = new ICCOperand(0);
    public static final ICCOperand XCC = new ICCOperand(2);

    public static final Symbolizer<ICCOperand> SYMBOLIZER = Symbolizer.Static.initialize(ICCOperand.class);
}

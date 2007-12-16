/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
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

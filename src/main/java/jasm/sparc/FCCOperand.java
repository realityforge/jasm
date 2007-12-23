/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.sparc;

import jasm.AbstractSymbolicArgument;
import jasm.util.SymbolSet;

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

    public static final SymbolSet<FCCOperand> SYMBOLS = SymbolSet.fromStaticFields(FCCOperand.class);
}

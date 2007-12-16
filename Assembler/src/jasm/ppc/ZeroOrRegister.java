/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc;

import jasm.AbstractSymbolicArgument;
import jasm.util.Symbolizer;

/**
 * The super type of all the {@link GPR General Purpose Registers} and the constant {@link Zero#ZERO}.
 *
 * @author Doug Simon
 */
public abstract class ZeroOrRegister extends AbstractSymbolicArgument {

    ZeroOrRegister(String name, int value) {
        super(name, value);
    }

    /**
     * Determines if this register specifier is outside the range of registers
     * {@code [target .. target+n]} where the range
     * wraps at 32.
     */
    public boolean isOutsideRegisterRange(GPR target, int n) {
        final int rt = target.value();
        final int ra = value();
        final int numRegs = (n + 3) / 4;
        final int lastReg = (rt + numRegs - 1) % 32;
        final boolean wrapsAround = lastReg < rt;
        if (wrapsAround) {
            return lastReg < ra && ra < rt;
        }
        return ra < rt || lastReg < ra;
    }

    public static Symbolizer<ZeroOrRegister> symbolizer() {
        if (_symbolizer == null) {
            _symbolizer = Symbolizer.Static.fromSequence(ZeroOrRegister.class, GPR.GPR_SYMBOLIZER, Zero.ZERO);
        }
        return _symbolizer;
    }

    // This must be lazily constructed to avoid dependency on the GPR class initializer
    private static Symbolizer<ZeroOrRegister> _symbolizer;

}

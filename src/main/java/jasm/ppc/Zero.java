/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.ppc;

/**
 * The type of the constant {@link #ZERO} that can be used as a GPR in certain instructions.
 */
public final class Zero extends ZeroOrRegister {

    public static final Zero ZERO = new Zero();

    private Zero() {
        super("0", 0);
    }

    @Override
    public String externalValue() {
        return "0";
    }
}

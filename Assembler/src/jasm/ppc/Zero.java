/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.ppc;

/**
 * The type of the constant {@link #ZERO} that can be used as a GPR in certain instructions.
 *
 * @author Doug Simon
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

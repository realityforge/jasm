/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen.cisc.x86;

/**
 * @author Bernd Mathiske
 */
public enum AddressingMethodCode  {

    A,
    C,
    D,
    E,
    F,
    G,
    I,
    IC, // we made this one up, it's like I, but with parameter type AMD64XMMComparison
    J,
    M,
    N, // we made this one up, it's like G, but with ParameterPlace.OPCODE1/2{_REXB} instead of a ModRM field
    O,
    P,
    PR,
    Q,
    R,
    S,
    T,
    V,
    VR,
    W,
    X,
    Y;
}

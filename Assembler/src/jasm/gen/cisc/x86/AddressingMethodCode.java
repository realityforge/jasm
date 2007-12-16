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

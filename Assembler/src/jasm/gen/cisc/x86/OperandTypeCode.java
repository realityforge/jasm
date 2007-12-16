/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

/**
 * @author Bernd Mathiske
 */
public enum OperandTypeCode {

    a,
    b,
    d,
    dq,
    d_q,
    p,
    pd,
    ps,
    q,
    s,
    sd,
    ss,
    v,
    w,
    y, // we made this one up: a double word if operand size 32, a quad word if 64, undefined if 16
    z;

}

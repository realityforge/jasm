/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=9fcd0ec0-6123-4865-9241-6dc8115b3cd9*/
package com.sun.max.asm.gen.cisc.x86;

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

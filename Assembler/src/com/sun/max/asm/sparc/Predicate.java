/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0bd52d9d-7b84-4fc1-bf02-bd59dfe7f1b9*/
package com.sun.max.asm.sparc;


public interface Predicate<CCRT extends ConditionCodeRegister, T extends Predicate<CCRT, T>> {
    T negate();
}

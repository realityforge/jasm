/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.sparc;


public interface Predicate<CCRT extends ConditionCodeRegister, T extends Predicate<CCRT, T>> {
    T negate();
}

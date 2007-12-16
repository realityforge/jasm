/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ca8992f5-5d01-4bad-93a6-e436b2710c46*/
package com.sun.max.util;

/**
 * Java enums are insufficient in that their ordinals have to be successive.
 * An Enumerable has an additional arbitrary int "value",
 * which may incur gaps between ordinal-successive Enumerables.
 * 
 * An Enumerator can be called upon to provide the respective Enumerable matching a given value.
 * 
 * @see Enumerator
 * 
 * @author Bernd Mathiske
 */
public interface Enumerable<Enumerable_Type extends Enum<Enumerable_Type> & Enumerable<Enumerable_Type>> extends Symbol {

    // We are merely declaring this method to lock in the same parameter type for the corresponding enumerator,
    // not for any actual use
    Enumerator<Enumerable_Type> enumerator();
    
}

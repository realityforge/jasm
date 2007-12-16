/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=96595548-f19a-4136-bf28-6906587ab202*/
package com.sun.max.collect;

/**
 * @author Bernd Mathiske
 */
public interface LinearCollection<Element_Type> extends Iterable<Element_Type> {

    /**
     * @return the number of elements in this collection
     */
    int length();

}

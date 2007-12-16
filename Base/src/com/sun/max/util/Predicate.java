/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5b11149d-2909-4f02-a694-e5c6954e0efb*/
package com.sun.max.util;

/**
 * @author Bernd Mathiske
 */
public interface Predicate<Type> {

    boolean evaluate(Type object);
    
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5fd4a5e1-1e01-4d44-a2fd-3b276d714b12*/
package com.sun.max.collect;

/**
 * An object that can be present in a {@linkplain Pool pool}.
 *
 * @author Doug Simon
 */
public interface PoolObject {
    
    /**
     * Gets the serial number that uniquely identifies this object within a {@linkplain Pool pool}.
     * 
     * @return -1 if the object is not within a pool
     */
    int serial();
}

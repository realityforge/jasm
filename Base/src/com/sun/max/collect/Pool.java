/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6901c5fe-f9a4-43fc-a657-ca49c77a02fc*/
package com.sun.max.collect;

/**
 * A sequence of {@linkplain PoolObject objects} that are uniquely identified <i>within the sequence</i> by a
 * {@linkplain PoolObject#serial() serial number} (i.e. an index into the sequence). A subset of the objects
 * within a pool can be efficiently represented by a {@link PoolBitSet}.
 * 
 * @author Doug Simon
 */
public interface Pool<PoolObject_Type extends PoolObject> extends Iterable<PoolObject_Type> {
    
    /**
     * Gets the object in the pool identified by a given serial number.
     */
    PoolObject_Type get(int serial);

    /**
     * Adds a new object to this pool.
     * 
     * Precondition: {@code object.serial() == size()}
     */
    void append(PoolObject_Type object);
    
    /**
     * The number of objects in this pool. All objects in the pool must have a serial number in the range
     * {@code [0 .. size() - 1]}.
     */
    int size();

}

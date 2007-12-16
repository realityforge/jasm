/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1cdead7d-64b2-403f-b71f-1f4075881cd3*/
package com.sun.max.collect;

import com.sun.max.lang.StaticLoophole;

/**
 * A set representation for {@linkplain PoolObject pool-allocated objects}.
 *
 * @author Doug Simon
 */
public interface PoolSet<PoolObject_Type extends PoolObject> extends Iterable<PoolObject_Type> {

    /**
     * Adds a value to this set. The value must have been allocated from
     * the {@linkplain #pool() pool} this set is associated with.
     */
    void add(PoolObject_Type value);

    /**
     * Determines if a given value is in this set. The value must have been allocated from
     * the {@linkplain #pool() pool} this set is associated with.
     */
    boolean contains(PoolObject_Type value);

    /**
     * Removes a given value from this set. The value must have been allocated from
     * the {@linkplain #pool() pool} this set is associated with.
     */
    void remove(PoolObject_Type value);

    /**
     * Gets the pool containing the values that are in or may be added to this set.
     */
    Pool<PoolObject_Type> pool();

    /**
     * Clears all entries from this set.
     */
    void clear();

    /**
     * @return true if there are no values in this set
     */
    boolean isEmpty();

    public static final class Static {

        private Static() {
        }

        private static final PoolSet _emptyPoolSet = new PoolBitSet<PoolObject>(new ArrayListPool<PoolObject>());

        public static <PoolObject_Type extends PoolObject> PoolSet<PoolObject_Type> empty(Class<PoolObject_Type> poolObjectType) {
            final Class<PoolSet<PoolObject_Type>> type = null;
            return StaticLoophole.cast(type, _emptyPoolSet);
        }
    }
}

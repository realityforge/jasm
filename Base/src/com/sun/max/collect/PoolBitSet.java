/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=73fc199f-84ce-41f7-a693-bc2cea2b237e*/
package com.sun.max.collect;

import java.util.*;

import com.sun.max.annotate.*;

/**
 * A compact and efficient implementation of a {@link PoolSet} based on bit sets.
 * 
 * @author Doug Simon
 */
public class PoolBitSet<PoolObject_Type extends PoolObject> extends BitSet implements PoolSet<PoolObject_Type> {
    
    private final Pool<PoolObject_Type> _pool;
    
    public PoolBitSet(Pool<PoolObject_Type> pool, PoolObject_Type... elements) {
        _pool = pool;
        for (PoolObject_Type element : elements) {
            add(element);
        }
    }

    @Implement(PoolSet.class)
    public Pool<PoolObject_Type> pool() {
        return _pool;
    }
    
    @Implement(PoolSet.class)
    public void add(PoolObject_Type value) {
        assert _pool.get(value.serial()) == value;
        set(value.serial());
    }

    public void addAll() {
        for (PoolObject_Type element : _pool) {
            add(element);
        }
    }
    
    @Implement(PoolSet.class)
    public boolean contains(PoolObject_Type value) {
        assert _pool.get(value.serial()) == value;
        return get(value.serial());
    }

    @Implement(PoolSet.class)
    public void remove(PoolObject_Type value) {
        assert _pool.get(value.serial()) == value;
        clear(value.serial());
    }

    @Override
    public String toString() {
        String s = "{";
        String delimiter = "";
        for (PoolObject_Type value : this) {
            s += delimiter + value;
            delimiter = ", ";
        }
        s += "}";
        return s;
    }
    
    /**
     * Gets an iterator over all the values in this set.
     */
    @Implement(Iterable.class)
    public Iterator<PoolObject_Type> iterator() {
        return new Iterator<PoolObject_Type>() {

            private int _currentBit = -1;
            private int _nextSetBit = nextSetBit(0);
            
            @Implement(Iterator.class)
            public boolean hasNext() {
                return _nextSetBit != -1;
            }

            @Implement(Iterator.class)
            public PoolObject_Type next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                
                _currentBit = _nextSetBit;
                _nextSetBit = nextSetBit(_nextSetBit + 1);
                return _pool.get(_currentBit);
            }

            @Implement(Iterator.class)
            public void remove() {
                if (_currentBit == -1) {
                    throw new IllegalStateException();
                }
                clear(_currentBit);
            }
        };
    }
}

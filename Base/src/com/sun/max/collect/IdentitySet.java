/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ee5d4a0b-a1ac-482a-a3bc-bdd4d9485e20*/
package com.sun.max.collect;

import java.util.*;

import com.sun.max.annotate.*;

/**
 * Similar to IdentityHashSet, but not recording 'null' as a set member 
 * and not providing any element removal operations.
 * 
 * (IdentityHashSet's iterator seems to return 'null' as a member even if it has never been entered.)
 *
 * @author Bernd Mathiske
 */
public class IdentitySet<Element_Type> implements Iterable<Element_Type> {

    private int _numberOfElements;

    public int numberOfElements() {
        return _numberOfElements;
    }
    
    private final Class<Element_Type> _elementType;
    private Element_Type[] _table;
    private int _threshold;
    
    private void setThreshold() {
        _threshold = (_table.length / 4) * 3;
    }
    
    public IdentitySet(Class<Element_Type> elementType) {
        _elementType = elementType;
        _table = com.sun.max.lang.Arrays.create(elementType, 16);
        setThreshold();
    }

    public IdentitySet(Class<Element_Type> elementType, int initialCapacity) {
        _elementType = elementType;
        _table = com.sun.max.lang.Arrays.create(elementType, initialCapacity);
        setThreshold();
    }
    
    private void grow() {
        final Element_Type[] oldTable = _table;
        _table = com.sun.max.lang.Arrays.create(_elementType, _table.length * 2);
        setThreshold();
        _numberOfElements = 0;
        for (int i = 0; i < oldTable.length; i++) {
            add(oldTable[i]);
        }
    }
    
    public void add(Element_Type element) {
        if (element == null) {
            return;
        }
        if (_numberOfElements > _threshold) {
            grow();
        }
        final int start = System.identityHashCode(element) % _table.length;
        int i = start;
        do {
            final Element_Type entry = _table[i];            
            if (entry == null) {
                _table[i] = element;
                _numberOfElements++;
                return;
            }
            if (entry == element) {
                return;
            }
            if (++i == _table.length) {
                i = 0;
            }
        } while (i != start);
    }

    public boolean contains(Element_Type element) {
        final int start = System.identityHashCode(element) % _table.length;
        int i = start;
        while (true) {
            final Element_Type entry = _table[i];            
            if (entry == element) {
                return true;
            }
            if (entry == null) {
                return false;
            }
            if (++i == _table.length) {
                i = 0;
            }
            assert i != start;
        }        
    }
    
    @Implement(Iterable.class)
    public Iterator<Element_Type> iterator() {
        final Element_Type[] array = com.sun.max.lang.Arrays.create(_elementType, numberOfElements());
        int j = 0;
        for (int i = 0; i < _table.length; i++) {
            final Element_Type element = _table[i];
            if (element != null) {
                array[j++] = element;
            }
        }
        return com.sun.max.lang.Arrays.iterator(array);
    }
}

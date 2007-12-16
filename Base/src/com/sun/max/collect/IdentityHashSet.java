/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1282c4f5-c2fe-4a44-9833-97ab5d449cdc*/
package com.sun.max.collect;

import java.util.IdentityHashMap;
import java.util.Iterator;

/**
 * An identity hash set backed by java.util.IdentityHashMap.
 *
 * @author Hiroshi Yamauchi
 */
public class IdentityHashSet<Element_Type> implements Iterable<Element_Type> {

    private final IdentityHashMap<Element_Type, Element_Type> _internalMap;

    public IdentityHashSet() {
        _internalMap = new IdentityHashMap<Element_Type, Element_Type>();
    }

    /**
     * Adds a specified element to this set.
     *
     * @param element
     *                the element to add
     * @return true if {@code element} was already in this set
     */
    public boolean add(Element_Type element) {
        return _internalMap.put(element, element) != null;
    }

    public Iterator<Element_Type> iterator() {
        return _internalMap.keySet().iterator();
    }

    @Override
    public String toString() {
        String string = "[ ";
        for (Element_Type element : _internalMap.keySet()) {
            string += element.toString() + " ";
        }
        string += "]";
        return string;
    }
}

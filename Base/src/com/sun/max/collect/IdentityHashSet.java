/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
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

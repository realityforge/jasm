/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1282c4f5-c2fe-4a44-9833-97ab5d449cdc*/
package com.sun.max.collect;

import com.sun.max.annotate.Implement;
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

    /**
     * Adds all the elements in a given iterable to this set. The addition is always done by calling
     * {@link #add(Object)}.
     *
     * @param iterable
     *                the collection of elements to add
     */
    public final void addAll(Iterable<Element_Type> iterable) {
        for (Element_Type element : iterable) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return _internalMap.isEmpty();
    }

    public void clear() {
        _internalMap.clear();
    }

    public void remove(Element_Type element) {
        _internalMap.remove(element);
    }

    public Element_Type getOne() {
        final Iterator<Element_Type> iterator = _internalMap.keySet().iterator();
        return iterator.next();
    }

    @Implement(Iterable.class)
    public Iterator<Element_Type> iterator() {
        return _internalMap.keySet().iterator();
    }

    public boolean contains(Element_Type element) {
        return _internalMap.containsKey(element);
    }

    public IdentityHashSet<Element_Type> copy() {
        final IdentityHashSet<Element_Type> copy = new IdentityHashSet<Element_Type>();
        copy.addAll(this);
        return copy;
    }

    public int size() {
        return _internalMap.size();
    }

    public final IdentityHashSet<Element_Type> union(IdentityHashSet<Element_Type> other) {
        for (Element_Type element : other) {
            add(element);
        }
        return this;
    }

    public boolean isSuperSetOf(IdentityHashSet<Element_Type> other) {
        if (size() < other.size()) {
            return false;
        }
        for (Element_Type element : other) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrictSuperSetOf(IdentityHashSet<Element_Type> other) {
        if (size() <= other.size()) {
            return false;
        }
        for (Element_Type element : other) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubSetOf(IdentityHashSet<Element_Type> other) {
        if (size() > other.size()) {
            return false;
        }
        for (Element_Type element : this) {
            if (!other.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrictSubSetOf(IdentityHashSet<Element_Type> other) {
        if (size() >= other.size()) {
            return false;
        }
        for (Element_Type element : this) {
            if (!other.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public Element_Type[] toArray(Element_Type[] a) {
        return _internalMap.keySet().toArray(a);
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

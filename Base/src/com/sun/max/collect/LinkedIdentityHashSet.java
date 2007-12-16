/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6b91e61c-4bed-4e7e-9f5a-14fc8d20898f*/
package com.sun.max.collect;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is an {@link IdentityHashSet} with a predictable iteration order based on the order in which elements are
 * {@linkplain #add(Object) inserted} (<i>a la</i>{@link LinkedHashMap}). In particular, insertion order is not
 * affected if a key is <i>re-inserted</i> into the map.
 * <p>
 * Note that {@linkplain #add(Object) insertion} and {@linkplain #iterator() iteration} should have the same performance
 * as for a standard {@code IdentityHashSet}. However, {@linkplain #remove(Object) deletion} is a linear operation due
 * to the linked list use to record insertion order.
 *
 * @author Doug Simon
 */
public class LinkedIdentityHashSet<Element_Type> extends IdentityHashSet<Element_Type> {

    private final LinkedList<Element_Type> _order = new LinkedList<Element_Type>();

    @Override
    public boolean add(Element_Type element) {
        if (!super.add(element)) {
            _order.add(element);
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        _order.clear();
        super.clear();
    }

    /**
     * Gets an iterator over the elements in the order they were (originally) inserted.
     */
    @Override
    public Iterator<Element_Type> iterator() {
        assert _order.size() == size() : _order.size() + " != " + size();
        return _order.iterator();
    }

    @Override
    public void remove(Element_Type element) {
        _order.remove(element);
        super.remove(element);
    }
}

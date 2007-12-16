/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is an {@link IdentityHashSet} with a predictable iteration order based on the order in which elements are
 * {@linkplain #add(Object) inserted} (<i>a la</i>{@link java.util.LinkedHashMap}). In particular, insertion order is not
 * affected if a key is <i>re-inserted</i> into the map.
 * <p>
 * Note that {@linkplain #add(Object) insertion} and {@linkplain #iterator() iteration} should have the same performance
 * as for a standard {@code IdentityHashSet}.
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

    /**
     * Gets an iterator over the elements in the order they were (originally) inserted.
     */
    @Override
    public Iterator<Element_Type> iterator() {
        return _order.iterator();
    }
}

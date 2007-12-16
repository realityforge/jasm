/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8cd511f0-7ff0-4f22-aeff-a62f321fcb33*/
package com.sun.max.collect;

import com.sun.max.annotate.Implement;
import com.sun.max.util.Predicate;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Filters the elements returned by a given iterator with a given predicate.
 *
 * @author Doug Simon
 */
public class FilterIterator<Element_Type> implements Iterator<Element_Type> {

    private final Iterator<? extends Element_Type> _iterator;
    private final Predicate<Element_Type> _predicate;
    private Element_Type _next;
    private boolean _advanced;

    public FilterIterator(Iterator<? extends Element_Type> iterator, Predicate<Element_Type> predicate) {
        _iterator = iterator;
        _predicate = predicate;
    }

    @Implement(Iterator.class)
    public boolean hasNext() {
        if (_advanced) {
            return true;
        }
        return advance();
    }

    @Implement(Iterator.class)
    public Element_Type next() {
        if (!_advanced) {
            if (!advance()) {
                throw new NoSuchElementException();
            }
        }
        _advanced = false;
        return _next;
    }

    @Implement(Iterator.class)
    public void remove() {
        if (_advanced) {
            throw new IllegalStateException("remove() cannot be called");
        }
        _iterator.remove();
    }

    private boolean advance() {
        while (_iterator.hasNext()) {
            final Element_Type next = _iterator.next();
            if (_predicate.evaluate(next)) {
                _next = next;
                _advanced = true;
                return true;
            }
        }
        return false;
    }
}

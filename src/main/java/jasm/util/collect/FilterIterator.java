/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Filters the elements returned by a given iterator with a given predicate.
 *
 * @author Doug Simon
 */
public final class FilterIterator<Element_Type> implements Iterator<Element_Type> {

  public interface Predicate<Element_Type> {
    boolean evaluate(Element_Type object);
}
    private final Iterator<? extends Element_Type> _iterator;
    private final Predicate<Element_Type> _predicate;
    private Element_Type _next;
    private boolean _advanced;

    public FilterIterator(Iterator<? extends Element_Type> iterator, Predicate<Element_Type> predicate) {
        _iterator = iterator;
        _predicate = predicate;
    }

    public final boolean hasNext() {
      return _advanced || advance();
    }

    public final Element_Type next() {
        if (!_advanced) {
            if (!advance()) {
                throw new NoSuchElementException();
            }
        }
        _advanced = false;
        return _next;
    }

    public final void remove() {
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

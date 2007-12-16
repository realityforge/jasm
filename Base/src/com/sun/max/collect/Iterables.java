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

/**
 * @author Bernd Mathiske
 */
public final class Iterables {

    public static int countIterations(Iterator iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            ++count;
            iterator.next();
        }
        return count;
    }

    public static <Element_Type> Iterable<Element_Type> empty() {
      return new Iterable<Element_Type>() {
        public Iterator<Element_Type> iterator() {
          return Iterators.empty();
        }
      };
    }

    private static final class Flatten1Iterator<Element_Type> implements Iterator<Element_Type> {

        private Iterator<Iterable<Element_Type>> _outerIterator;
        private Iterator<Element_Type> _innerIterator;

        private Flatten1Iterator(Iterable<Iterable<Element_Type>> iterable) {
            _outerIterator = iterable.iterator();
        }

        public boolean hasNext() {
            while (_innerIterator == null || !_innerIterator.hasNext()) {
                if (!_outerIterator.hasNext()) {
                    return false;
                }
                _innerIterator = _outerIterator.next().iterator();
            }
            return true;
        }

        public Element_Type next() {
            if (!hasNext()) {
                return null;
            }
            return _innerIterator.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static <Element_Type> Iterable<Element_Type> flatten1(Iterable<Iterable<Element_Type>> iterable) {
        final Iterator<Element_Type> iterator = new Flatten1Iterator<Element_Type>(iterable);
        return new Iterable<Element_Type>() {
            public Iterator<Element_Type> iterator() {
                return iterator;
            }
        };
    }

}

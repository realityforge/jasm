/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4094e727-0d7b-4709-8858-e5a7a856cc7e*/
package com.sun.max.collect;

import com.sun.max.lang.Arrays;
import com.sun.max.lang.StaticLoophole;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author Bernd Mathiske
 */
public final class Iterables {

    private Iterables() {

    }

    public static <Element_Type> Iterable<Element_Type> from(Element_Type... elements) {
        return Arrays.iterable(elements);
    }

    public static int countIterations(Iterator iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            ++count;
            iterator.next();
        }
        return count;
    }

    private static final class EnumerationIterable<Element_Type> implements Iterable<Element_Type> {

        private final Enumeration<Element_Type> _enumeration;

        private class EnumerationIterator implements Iterator<Element_Type> {

            EnumerationIterator() {
            }

            public boolean hasNext() {
                return _enumeration.hasMoreElements();
            }

            public Element_Type next() {
                return _enumeration.nextElement();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        }

        EnumerationIterable(Enumeration<Element_Type> enumeration) {
            _enumeration = enumeration;
        }

        public Iterator<Element_Type> iterator() {
            return new EnumerationIterator();
        }

    }

    public static <Element_Type> Iterable<Element_Type> fromEnumeration(Enumeration<Element_Type> enumeration) {
        return new EnumerationIterable<Element_Type>(enumeration);
    }

    private static final Iterable<Object> EMPTY_ITERABLE = new Iterable<Object>() {
        public Iterator<Object> iterator() {
            return Iterators.empty();
        }
    };

    public static <Element_Type> Iterable<Element_Type> empty() {
        final Class<Iterable<Element_Type>> type = null;
        return StaticLoophole.cast(type, EMPTY_ITERABLE);
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

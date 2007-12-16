/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1bec5c79-a2e9-4bb3-907c-3cad97f03d80*/
package com.sun.max.collect;

import com.sun.max.lang.StaticLoophole;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Lisp-like lists made of "cons" cells.
 *
 * @author Bernd Mathiske
 */
public class Cons<Element_Type> implements LinearCollection<Element_Type> {

    private final Element_Type _head;
    private final Cons<Element_Type> _tail;

    public Cons(Element_Type head, Cons<Element_Type> tail) {
        _head = head;
        _tail = tail;
    }

    public Element_Type head() {
        return _head;
    }

    public Cons<Element_Type> tail() {
        return _tail;
    }

    public int length() {
        final Cons<Element_Type> start = this;
        Cons<Element_Type> list = this;
        int n = 0;
        do {
            n++;
            list = list.tail();
        } while (list != null && list != start);
        return n;
    }

    public Iterator<Element_Type> iterator() {
        final Class<Cons<Element_Type>> type = null;
        return new Iterator<Element_Type>() {
            private final Cons<Element_Type> _start = StaticLoophole.cast(type, Cons.this);
            private Cons<Element_Type> _list = _start;

            public boolean hasNext() {
                return _list != null;
            }
            public Element_Type next() {
                if (_list == null) {
                    throw new NoSuchElementException();
                }
                final Element_Type result = _list.head();
                _list = _list.tail();
                if (_list == _start) {
                    _list = null;
                }
                return result;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static <Element_Type> Cons<Element_Type> create(Iterable<Element_Type> elements) {
        return createReverse(createReverse(elements));
    }

    public static <Element_Type> Cons<Element_Type> createReverse(Iterable<Element_Type> elements) {
        if (elements == null) {
            return null;
        }
        Cons<Element_Type> list = null;
        for (Element_Type element : elements) {
            list = new Cons<Element_Type>(element, list);
        }
        return list;
    }

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=60a3c717-bbb4-480f-a692-e7cb8d85fb95*/
package com.sun.max.collect;

import com.sun.max.lang.StaticLoophole;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators {

    private Iterators() {
    }

    private static final Iterator<Object> EMPTY_ITERATOR = new Iterator<Object>() {
        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    };

    public static <Element_Type> Iterator<Element_Type> empty() {
        final Class<Iterator<Element_Type>> type = null;
        return StaticLoophole.cast(type, EMPTY_ITERATOR);
    }

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=60a3c717-bbb4-480f-a692-e7cb8d85fb95*/
package com.sun.max.collect;

import java.util.*;

import com.sun.max.annotate.*;
import com.sun.max.lang.*;


public final class Iterators {

    private Iterators() {
    }
    
    private static final Iterator<Object> EMPTY_ITERATOR = new Iterator<Object>() {
        @Implement(Iterator.class)
        public boolean hasNext() {
            return false;
        }

        @Implement(Iterator.class)
        public Object next() {
            throw new NoSuchElementException();
        }
        @Implement(Iterator.class)
        public void remove() {
            throw new UnsupportedOperationException();
        }
    };

    public static <Element_Type> Iterator<Element_Type> empty() {
        final Class<Iterator<Element_Type>> type = null;
        return StaticLoophole.cast(type, EMPTY_ITERATOR);
    }
    
}

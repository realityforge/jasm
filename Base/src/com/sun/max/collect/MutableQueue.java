/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.collect;

import java.util.LinkedList;

/**
 * @author Bernd Mathiske
 */
public class MutableQueue<Element_Type> extends LinkedList<Element_Type> {

    public MutableQueue(Iterable<Element_Type> elements) {
        super();
        for (Element_Type element : elements) {
            add(element);
        }
    }

}

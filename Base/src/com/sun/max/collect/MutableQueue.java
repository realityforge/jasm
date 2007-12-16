/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
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

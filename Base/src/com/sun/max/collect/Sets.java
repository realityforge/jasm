/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import java.util.HashSet;
import java.util.Set;

/**
 * Set operations that one could expect in java.util.
 *
 * @author Bernd Mathiske
 */
public final class Sets {

    public static <Element_Type> Set<Element_Type> from(Element_Type... elements) {
        return new HashSet<Element_Type>(java.util.Arrays.asList(elements));
    }

}

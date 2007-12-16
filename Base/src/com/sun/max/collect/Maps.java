/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import java.util.Map;

/**
 * Miscellaneous operations on {@link Map}s.
 *
 * @author Doug Simon
 */
public final class Maps {

    private Maps() {

    }

    /**
     * Gets the first key in a given map that is mapped to a given value. Given that many
     * keys can map to the same value, the key returned is the first encountered when
     * iterating over the map's {@linkplain Map#entrySet() entry set}.
     */
    public static <Key_Type, Value_Type> Key_Type key(Map<Key_Type, Value_Type> map, Value_Type value) {
        for (Map.Entry<Key_Type, Value_Type> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

}

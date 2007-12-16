/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=acf76553-19d2-42b9-aa09-54e4a2afc68d*/
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

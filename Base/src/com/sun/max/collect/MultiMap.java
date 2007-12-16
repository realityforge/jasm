/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d63cc5e2-ffa7-4979-ac54-ec57057d648d*/
package com.sun.max.collect;

import java.util.*;

/**
 * A mapping of keys to one or more values.
 * 
 * @param <Key_Type>        the type of keys maintained by this bag
 * @param <Value_Type>      the type of mapped values
 * @param <Collection_Type> the type of collection used to store the values mapped to a given key. Whether or not
 *                          multiple <i>identical</i> values can be associated with a given key depends on what identical
 *                          means for this collection type and whether or not this collection type supports containing
 *                          identical values.
 * 
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public interface MultiMap<Key_Type, Value_Type, Collection_Type extends Iterable<Value_Type>> extends Iterable<Value_Type> {

    /**
     * Gets the values in this map associated with the given key. This will return a zero length collection if
     * there are no values associated with {@code key}.
     */
    Collection_Type get(Key_Type key);

    /**
     * Adds a specified value under a specified key in this bag.
     * Whether or not the number of values in this map associated with {@code key} changes
     * depends on the {@linkplain Collection_Type collection type} used to store the values. 
     */
    void add(Key_Type key, Value_Type value);

    void addAll(Key_Type key, Collection_Type values);
    
    boolean containsKey(Key_Type key);
    
    Set<Key_Type> keys();
}

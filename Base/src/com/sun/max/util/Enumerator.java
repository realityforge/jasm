/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c7dc824c-e917-4658-8b28-6781fc05846f*/
package com.sun.max.util;

import java.util.*;

import com.sun.max.annotate.*;

/**
 * @see Enumerable
 *
 * @author Bernd Mathiske
 */
public class Enumerator<Enumerable_Type extends Enum<Enumerable_Type> & Enumerable<Enumerable_Type>> 
    implements Symbolizer<Enumerable_Type> {

    private final Class<Enumerable_Type> _type;
    private final EnumSet<Enumerable_Type> _enumSet;
    
    public Enumerator(Class<Enumerable_Type> type) {
        _type = type;
        _enumSet = EnumSet.allOf(type);
    }

    public Enumerator(Class<Enumerable_Type> type, EnumSet<Enumerable_Type> enumSet) {
        _type = type;
        _enumSet = enumSet;
    }

    @Implement(Symbolizer.class)
    public Class<Enumerable_Type> type() {
        return _type;
    }
    
    public Set<Enumerable_Type> asSet() {
        return _enumSet;
    }
    
    @Implement(Iterable.class)
    public Iterator<Enumerable_Type> iterator() {
        return _enumSet.iterator();
    }
    
    @Implement(Symbolizer.class)
    public Enumerable_Type fromValue(int value) {
        for (Enumerable_Type enumerable : this) {
            if (enumerable.value() == value && _enumSet.contains(enumerable)) {
                return enumerable;
            }
        }
        return null;
    }
    
}

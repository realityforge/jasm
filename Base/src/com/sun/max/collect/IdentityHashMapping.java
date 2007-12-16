/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=0efe92cd-8c05-40b0-a799-cba3754c3e10*/
package com.sun.max.collect;

import java.util.*;

import com.sun.max.annotate.*;

/**
 * @author Bernd Mathiske
 */
public class IdentityHashMapping<Key_Type, Value_Type> implements Mapping<Key_Type, Value_Type> {

    private final IdentityHashMap<Key_Type, Value_Type> _delegate;
    
    public IdentityHashMapping() {
        _delegate = new IdentityHashMap<Key_Type, Value_Type>();
    }

    public IdentityHashMapping(int expectedMaxSize) {
        _delegate = new IdentityHashMap<Key_Type, Value_Type>(expectedMaxSize);
    }

    @Implement(Mapping.class)
    public synchronized Value_Type put(Key_Type key, Value_Type value) {
        return _delegate.put(key, value);
    }
    
    @Implement(Mapping.class)
    public synchronized Value_Type get(Key_Type key) {
        final Value_Type value = _delegate.get(key);
        return value;
    }
    
    @Implement(Mapping.class)
    public synchronized boolean containsKey(Key_Type key) {
        return _delegate.containsKey(key);
    }
    
}

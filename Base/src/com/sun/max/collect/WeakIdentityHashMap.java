/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=49a6da43-2915-4347-8fc1-817b639795aa*/
package com.sun.max.collect;

import java.util.*;

import com.sun.max.annotate.*;
import com.sun.max.program.*;

/**
 * A hash map that uses identity for key comparisons and does not prevent its
 * key from being collected.
 *
 * @author Hiroshi Yamauchi
 */
public class WeakIdentityHashMap<K, V> implements Map<K, V> {
    protected final WeakHashMap<ReferenceWrapper<K>, V> _map;

    public WeakIdentityHashMap() {
        _map = new WeakHashMap<ReferenceWrapper<K>, V>();
    }

    protected ReferenceWrapper<K> wrapK(K key) {
        return new ReferenceWrapper<K>(key);
    }
    
    protected ReferenceWrapper<Object> wrap(Object key) {
        return new ReferenceWrapper<Object>(key);
    }
    
    @Implement(Map.class)
    public void clear() {
        _map.clear();
    }

    @Implement(Map.class)
    public boolean containsKey(Object key) {
        return _map.containsKey(wrap(key));
    }
    
    @Implement(Map.class)
    public boolean containsValue(Object value) {
        return _map.containsValue(value);
    }
    
    @Implement(Map.class)
    public Set<Map.Entry<K, V>> entrySet() {
        Problem.unimplemented();
        return null;
    }
    
    @Implement(Map.class)
    public V get(Object key) {
        return _map.get(wrap(key));
    }
    
    @Implement(Map.class)
    public boolean isEmpty() {
        return _map.isEmpty();
    }
    
    @Implement(Map.class)
    public Set<K> keySet() {
        Problem.unimplemented();
        return null;
    }
    
    @Implement(Map.class)
    public V put(K key, V value) {
        _map.put(wrapK(key), value);
        return value;
    }
    
    @Implement(Map.class)
    public void putAll(Map<? extends K, ? extends V> m) {
        putAll2(m);
    }
    
    protected <L extends K, W extends V> void putAll2(Map<L, W> m) {
        final Set<Map.Entry<L, W>> entries = m.entrySet();
        for (Map.Entry<L, W> e : entries) {
            put(e.getKey(), e.getValue());
        }
    }
    
    @Implement(Map.class)
    public V remove(Object key) {
        return _map.remove(wrap(key));
    }
    
    @Implement(Map.class)
    public int size() {
        return _map.size();
    }
    
    @Implement(Map.class)
    public Collection<V> values() {
        return _map.values();
    }
    
    protected static class ReferenceWrapper<L> {
        protected final L _ref;
        
        protected ReferenceWrapper(L ref) {
            _ref = ref;
        }

        @Override
        public boolean equals(Object x) {
            return _ref == x;
        }

        @Override
        public int hashCode() {
            return _ref.hashCode();
        }
    }
}

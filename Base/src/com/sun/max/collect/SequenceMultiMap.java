/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=3754ac6e-d5bf-42d7-8881-be201fe91b41*/
package com.sun.max.collect;

import com.sun.max.annotate.Implement;
import com.sun.max.annotate.JdtSyntax;
import com.sun.max.lang.StaticLoophole;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Implementation of the {@link MultiMap} interface where the multi-values are stored and
 * retrieved in sequences and the underlying map is either a {@link HashMap} or a {@link SortedMap}
 * depending on the boolean value provided to the {@link #SequenceMultiMap(boolean) constructor}.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class SequenceMultiMap<Key_Type, Value_Type> implements MultiMap<Key_Type, Value_Type, Sequence<Value_Type>> {

    private final Map<Key_Type, AppendableSequence<Value_Type>> _map;

    public SequenceMultiMap(boolean sorted) {

        @JdtSyntax("jikes compiler bug (https://bugs.eclipse.org/bugs/show_bug.cgi?id=151153): invalid stackmap generated if this code is replaced by a ternary operator")
        final Map<Key_Type, AppendableSequence<Value_Type>> map;
        if (sorted) {
            map = new TreeMap<Key_Type, AppendableSequence<Value_Type>>();
        } else {
            map = new HashMap<Key_Type, AppendableSequence<Value_Type>>();
        }
        _map = map;
    }

    @Implement(MultiMap.class)
    public Sequence<Value_Type> get(Key_Type key) {
        final Sequence<Value_Type> result = _map.get(key);
        if (result == null) {
            final Class<Value_Type> type = null;
            return Sequence.Static.empty(type);
        }
        return _map.get(key);
    }

    @Implement(MultiMap.class)
    public boolean containsKey(Key_Type key) {
        return _map.containsKey(key);
    }

    private AppendableSequence<Value_Type> makeSequence(Key_Type key) {
        AppendableSequence<Value_Type> sequence = _map.get(key);
        if (sequence == null) {
            sequence = new ArrayListSequence<Value_Type>();
            _map.put(key, sequence);
        }
        return sequence;
    }

    @Implement(MultiMap.class)
    public void add(Key_Type key, Value_Type value) {
        makeSequence(key).append(value);
    }

    @Implement(MultiMap.class)
    public void addAll(Key_Type key, Sequence<Value_Type> values) {
        AppendableSequence.Static.appendAll(makeSequence(key), values);
    }

    @Implement(MultiMap.class)
    public Set<Key_Type> keys() {
        return _map.keySet();
    }

    @Implement(Iterable.class)
    public Iterator<Value_Type> iterator() {
        final Collection<AppendableSequence<Value_Type>> sequences = _map.values();
        assert Iterable.class.isAssignableFrom(Collection.class);
        assert Iterable.class.isAssignableFrom(ArrayListSequence.class);
        final Class<Iterable<Iterable<Value_Type>>> type = null;
        final Iterable<Iterable<Value_Type>> iterable = StaticLoophole.cast(type, sequences);
        return Iterables.flatten1(iterable).iterator();
    }

}

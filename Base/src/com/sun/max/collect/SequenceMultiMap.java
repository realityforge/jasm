/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import com.sun.max.lang.StaticLoophole;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
        _map =
            (sorted) ?
            new TreeMap<Key_Type, AppendableSequence<Value_Type>>() :
            new HashMap<Key_Type, AppendableSequence<Value_Type>>();
    }

    public Sequence<Value_Type> get(Key_Type key) {
        final Sequence<Value_Type> result = _map.get(key);
        if (result == null) {
            final Class<Value_Type> type = null;
            return Sequence.Static.empty();
        }
        return _map.get(key);
    }

  private AppendableSequence<Value_Type> makeSequence(Key_Type key) {
        AppendableSequence<Value_Type> sequence = _map.get(key);
        if (sequence == null) {
            sequence = new ArrayListSequence<Value_Type>();
            _map.put(key, sequence);
        }
        return sequence;
    }

    public void add(Key_Type key, Value_Type value) {
        makeSequence(key).append(value);
    }

  public Iterator<Value_Type> iterator() {
      final Iterable<Iterable<Value_Type>> iterable = StaticLoophole.cast(_map.values());
        return Iterables.flatten1(iterable).iterator();
    }

}

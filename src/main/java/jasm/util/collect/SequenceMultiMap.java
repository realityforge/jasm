/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.collect;

import jasm.util.lang.StaticLoophole;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * MultiMap implementation where the multi-values are stored and retrieved in sequences.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class SequenceMultiMap<Key_Type, Value_Type> {

  private final HashMap<Key_Type, ArrayList<Value_Type>> _map;

  public SequenceMultiMap() {
    _map = new HashMap<Key_Type, ArrayList<Value_Type>>();
  }

  public List<Value_Type> get(Key_Type key) {
    final ArrayList<Value_Type> result = _map.get(key);
    if (result == null) {
      return StaticLoophole.cast(Collections.EMPTY_LIST);
    }
    return _map.get(key);
  }

  private ArrayList<Value_Type> makeSequence(Key_Type key) {
    ArrayList<Value_Type> sequence = _map.get(key);
    if (sequence == null) {
      sequence = new ArrayList<Value_Type>();
      _map.put(key, sequence);
    }
    return sequence;
  }

  public void add(Key_Type key, Value_Type value) {
    makeSequence(key).add(value);
  }

  public Iterator<Value_Type> iterator() {
    final Iterable<Iterable<Value_Type>> iterable = StaticLoophole.cast(_map.values());
    return Iterables.flatten1(iterable);
  }

}

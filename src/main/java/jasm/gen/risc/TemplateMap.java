/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.risc;

import jasm.util.lang.StaticLoophole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class TemplateMap<Value_Type extends RiscTemplate> {

  private final HashMap<String, ArrayList<Value_Type>> _map;

  TemplateMap() {
    _map = new HashMap<String, ArrayList<Value_Type>>();
  }

  List<Value_Type> get(String key) {
    final ArrayList<Value_Type> result = _map.get(key);
    if (result == null) {
      return Collections.emptyList();
    }
    return _map.get(key);
  }

  private ArrayList<Value_Type> makeSequence(String key) {
    ArrayList<Value_Type> sequence = _map.get(key);
    if (sequence == null) {
      sequence = new ArrayList<Value_Type>();
      _map.put(key, sequence);
    }
    return sequence;
  }

  void add(String key, Value_Type value) {
    makeSequence(key).add(value);
  }

  Iterator<Value_Type> iterator() {
    final Iterable<Iterable<Value_Type>> iterable = StaticLoophole.cast(_map.values());
    return new Flatten1Iterator<Value_Type>(iterable);
  }

  private static final class Flatten1Iterator<Element_Type> implements Iterator<Element_Type> {

    private Iterator<Iterable<Element_Type>> _outerIterator;
    private Iterator<Element_Type> _innerIterator;

    private Flatten1Iterator(Iterable<Iterable<Element_Type>> iterable) {
      _outerIterator = iterable.iterator();
    }

    public boolean hasNext() {
      while (_innerIterator == null || !_innerIterator.hasNext()) {
        if (!_outerIterator.hasNext()) {
          return false;
        }
        _innerIterator = _outerIterator.next().iterator();
      }
      return true;
    }

    public Element_Type next() {
      if (!hasNext()) {
        return null;
      }
      return _innerIterator.next();
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

import java.util.IdentityHashMap;
import java.util.Iterator;

final class LabelSet implements Iterable<Label> {

  private final IdentityHashMap<Label, Label> _internalMap;

  LabelSet() {
    _internalMap = new IdentityHashMap<Label, Label>();
  }

  void add(Label element) {
    _internalMap.put(element, element);
  }

  public Iterator<Label> iterator() {
    return _internalMap.keySet().iterator();
  }

  public String toString() {
    return _internalMap.keySet().toString();
  }
}

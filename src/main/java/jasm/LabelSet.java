package jasm;

import java.util.IdentityHashMap;
import java.util.Iterator;

/**
 * @author Hiroshi Yamauchi
 */
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

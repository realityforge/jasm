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

  boolean add(Label element) {
    return _internalMap.put(element, element) != null;
  }

  public Iterator<Label> iterator() {
    return _internalMap.keySet().iterator();
  }

  public String toString() {
    return _internalMap.keySet().toString();
  }
}

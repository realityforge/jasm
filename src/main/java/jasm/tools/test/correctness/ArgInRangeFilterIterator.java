/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.test.correctness;

import jasm.Argument;
import jasm.tools.ArgumentRange;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class ArgInRangeFilterIterator implements Iterator<Argument> {

  private final Iterator<? extends Argument> _iterator;
  private final ArgumentRange _argumentRange;
  private Argument _next;

  private boolean _advanced;

  public ArgInRangeFilterIterator(Iterator<? extends Argument> iterator,
                                  ArgumentRange argumentRange) {
    _iterator = iterator;
    _argumentRange = argumentRange;
  }

  public final boolean hasNext() {
    return _advanced || advance();
  }

  public final Argument next() {
    if (!_advanced) {
      if (!advance()) {
        throw new NoSuchElementException();
      }
    }
    _advanced = false;
    return _next;
  }

  public final void remove() {
    throw new UnsupportedOperationException();
  }

  private boolean advance() {
    while (_iterator.hasNext()) {
      final Argument next = _iterator.next();
      if (_argumentRange.includes(next)) {
        _next = next;
        _advanced = true;
        return true;
      }
    }
    return false;
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators {
  public static <Element_Type> Iterator<Element_Type> empty() {
    return new Iterator<Element_Type>() {
      public boolean hasNext() {
        return false;
      }

      public Element_Type next() {
        throw new NoSuchElementException();
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
}

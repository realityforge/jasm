/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.collect;

/**
 * A {@link Sequence} whose existing elements can be modified.
 *
 * @author Bernd Mathiske
 */
public interface MutableSequence<Element_Type> extends Sequence<Element_Type> {
  /**
   * Sets the value of the element at a given index.
   *
   * @return the previous value at {@code index}
   */
  Element_Type set(int index, Element_Type value);
}

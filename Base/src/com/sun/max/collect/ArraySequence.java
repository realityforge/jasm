/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import com.sun.max.lang.Arrays;
import com.sun.max.lang.StaticLoophole;
import java.util.Iterator;

/**
 * A sequence that wraps a generic array.
 * Thus instantiation does not require any type cast quirks.
 *
 * @author Bernd Mathiske
 */
public class ArraySequence<Element_Type> implements MutableSequence<Element_Type> {

    private final Element_Type[] _array;

    public ArraySequence(Element_Type... array) {
        super();
        _array = array;
    }

  public ArraySequence(int length) {
        super();
        _array = StaticLoophole.cast(new Object[length]);
    }

  public boolean isEmpty() {
        return _array.length == 0;
    }

    public int length() {
        return _array.length;
    }

    public Element_Type first() {
        return _array[0];
    }

    public Element_Type last() {
        return _array[_array.length - 1];
    }

    public Element_Type get(int index) {
        return _array[index];
    }

    public Element_Type set(int index, Element_Type value) {
        final Element_Type previousValue = _array[index];
        _array[index] = value;
        return previousValue;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Sequence)) {
            return false;
        }
        final Sequence sequence = (Sequence) other;
        if (length() != sequence.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (!get(i).equals(sequence.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        final int delta = (_array.length / 4) + 1;
        for (int i = 0; i < _array.length; i += delta) {
            result += _array[i].hashCode();
        }
        return result;
    }

    public Iterator<Element_Type> iterator() {
      return java.util.Arrays.asList(_array).iterator();
    }

    @Override
    public Sequence<Element_Type> clone() {
        return new ArraySequence<Element_Type>(_array.clone());
    }

    @Override
    public String toString() {
        return Arrays.toString(_array);
    }
}

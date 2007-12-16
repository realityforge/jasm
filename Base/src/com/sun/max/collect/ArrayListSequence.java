/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An expandable and mutable sequence,
 * often used to represent ExpandableSequence or MutableSequence,
 * which then act as narrowing interfaces.
 *
 * @author Bernd Mathiske
 */
public final class ArrayListSequence<Element_Type> extends ArrayList<Element_Type> implements AppendableSequence<Element_Type> {

    public ArrayListSequence() {
        super();
    }

    public ArrayListSequence(int initialCapacity) {
        super(initialCapacity);
    }

    public ArrayListSequence(Collection<? extends Element_Type> collection) {
        super(collection);
    }

    public ArrayListSequence(Iterable<? extends Element_Type> elements) {
        for (Element_Type element : elements) {
            add(element);
        }
    }

    public ArrayListSequence(Element_Type element) {
        super();
        add(element);
    }

    public ArrayListSequence(Element_Type[] array) {
        super(java.util.Arrays.asList(array));
    }

    public int length() {
        return size();
    }

    public Element_Type first() {
        return get(0);
    }

    public Element_Type last() {
        return get(length() - 1);
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
            final Object element = get(i);
            if (element == null) {
                if (sequence.get(i) != null) {
                    return false;
                }
            } else if (!element.equals(sequence.get(i))) {
                return false;
            }
        }
        return true;
    }

  public void append(Element_Type element) {
        add(element);
    }

    @Override
    public Sequence<Element_Type> clone() {
        return new ArrayListSequence<Element_Type>((Sequence<? extends Element_Type>) this);
    }

  public <To_Type> AppendableSequence<To_Type> map(Class<To_Type> toType,
                                                   MapFunction<Element_Type, To_Type> mapFunction) {
    final AppendableSequence<To_Type> to = new ArrayListSequence<To_Type>();
    for (Element_Type element : this) {
      to.append(mapFunction.map(element));
    }
    return to;
  }

  @Override
    public String toString() {
        return "<" + Sequence.Static.toString(this, null, ", ") + ">";
    }
}

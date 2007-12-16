/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package com.sun.max.collect;

import com.sun.max.lang.StaticLoophole;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * An expandable and mutable sequence,
 * often used to represent ExpandableSequence or MutableSequence,
 * which then act as narrowing interfaces.
 *
 * @author Bernd Mathiske
 */
public class ArrayListSequence<Element_Type> extends ArrayList<Element_Type> implements AppendableSequence<Element_Type> {

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

    public Element_Type removeFirst() {
        return remove(0);
    }

    public Element_Type removeLast() {
        return remove(length() - 1);
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void append(Element_Type element) {
        add(element);
    }

    public void prepend(Element_Type element) {
        add(0, element);
    }

    public void prependAll(Element_Type... elements) {
        addAll(0, Arrays.asList(elements));
    }

    public void prependAll(Sequence<? extends Element_Type> elements) {
        if (elements instanceof ArrayListSequence) {
            final Class<ArrayListSequence<Element_Type>> type = null;
            addAll(0, StaticLoophole.cast(type, elements));
        } else {
            ensureCapacity(length() + elements.length());
            int index = 0;
            for (Element_Type element : elements) {
                add(index, element);
                ++index;
            }
        }
    }

    @Override
    public Sequence<Element_Type> clone() {
        return new ArrayListSequence<Element_Type>((Sequence<? extends Element_Type>) this);
    }

    public static <From_Type, To_Type> AppendableSequence<To_Type> map(Sequence<From_Type> from, Class<To_Type> toType, MapFunction<From_Type, To_Type> mapFunction) {
        final AppendableSequence<To_Type> to = new ArrayListSequence<To_Type>();
        for (From_Type element : from) {
            to.append(mapFunction.map(element));
        }
        return to;
    }

    public <To_Type> AppendableSequence<To_Type> map(Class<To_Type> toType, MapFunction<Element_Type, To_Type> mapFunction) {
        return map(this, toType, mapFunction);
    }

    @Override
    public String toString() {
        return "<" + Sequence.Static.toString(this, null, ", ") + ">";
    }
}

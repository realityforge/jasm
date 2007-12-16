/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c3242493-7af3-4149-be74-2cae04039d72*/
package com.sun.max.collect;

import com.sun.max.annotate.Implement;
import com.sun.max.lang.Arrays;
import com.sun.max.lang.StaticLoophole;
import java.util.Collection;
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

    public static <T> Sequence<T> of(T... elements) {
        return new ArraySequence<T>(elements.clone());
    }

    public ArraySequence(int length) {
        super();
        final Class<Element_Type[]> arrayType = null;
        _array = StaticLoophole.cast(arrayType, new Object[length]);
    }

    public ArraySequence(Collection<Element_Type> collection) {
        super();
        final Class<Element_Type[]> arrayType = null;
        _array = StaticLoophole.cast(arrayType, collection.toArray());
    }

    @Implement(Sequence.class)
    public boolean isEmpty() {
        return _array.length == 0;
    }

    @Implement(Sequence.class)
    public int length() {
        return _array.length;
    }

    @Implement(Sequence.class)
    public Element_Type first() {
        return _array[0];
    }

    @Implement(Sequence.class)
    public Element_Type last() {
        return _array[_array.length - 1];
    }

    @Implement(Sequence.class)
    public Element_Type get(int index) {
        return _array[index];
    }

    @Implement(MutableSequence.class)
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

    @Implement(Sequence.class)
    public Iterator<Element_Type> iterator() {
        return Arrays.iterable(_array).iterator();
    }

    @Implement(Sequence.class)
    @Override
    public Sequence<Element_Type> clone() {
        return new ArraySequence<Element_Type>(_array.clone());
    }

    public static <From_Type, To_Type> Sequence<To_Type> map(Sequence<From_Type> from, Class<To_Type> toType, MapFunction<From_Type, To_Type> mapFunction) {
        final MutableSequence<To_Type> to = new ArraySequence<To_Type>(from.length());
        for (int i = 0; i < from.length(); i++) {
            to.set(i, mapFunction.map(from.get(i)));
        }
        return to;
    }

    @Implement(Sequence.class)
    public <To_Type> Sequence<To_Type> map(Class<To_Type> toType, MapFunction<Element_Type, To_Type> mapFunction) {
        return map(this, toType, mapFunction);
    }

    @Override
    public String toString() {
        return Arrays.toString(_array, ", ");
    }
}

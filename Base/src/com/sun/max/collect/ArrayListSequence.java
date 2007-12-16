/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4c911956-0936-4667-8f83-00e6793f0634*/
package com.sun.max.collect;

import java.util.*;
import java.util.Arrays;

import com.sun.max.annotate.*;
import com.sun.max.lang.*;

/**
 * An expandable and mutable sequence, 
 * often used to represent ExpandableSequence or MutableSequence,
 * which then act as narrowing interfaces.
 * 
 * @author Bernd Mathiske
 */
public class ArrayListSequence<Element_Type> extends ArrayList<Element_Type> implements VariableSequence<Element_Type> {

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

    @Implement(Sequence.class)
    public int length() {
        return size();
    }
    
    @Implement(Sequence.class)
    public Element_Type first() {
        return get(0);
    }
    
    @Implement(Sequence.class)
    public Element_Type last() {
        return get(length() - 1);
    }
    
    @Implement(ShrinkableSequence.class)
    public Element_Type removeFirst() {
        return remove(0);
    }
    
    @Implement(ShrinkableSequence.class)
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
    
    @Implement(AppendableSequence.class)
    public void append(Element_Type element) {
        add(element);
    }
    
    @Implement(PrependableSequence.class)
    public void prepend(Element_Type element) {
        add(0, element);
    }

    @Implement(PrependableSequence.class)
    public void prependAll(Element_Type... elements) {
        addAll(0, Arrays.asList(elements));
    }

    @Implement(PrependableSequence.class)
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

    @Implement(Sequence.class)
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

    @Implement(Sequence.class)
    public <To_Type> AppendableSequence<To_Type> map(Class<To_Type> toType, MapFunction<Element_Type, To_Type> mapFunction) {
        return map(this, toType, mapFunction);
    }
        
    @Override
    public String toString() {
        return "<" + Sequence.Static.toString(this, null, ", ") + ">";
    }
}

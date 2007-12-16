/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.collect;


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

    public static final class Static {
        private Static() {
        }

        public static <Element_Type> void copy(Sequence<Element_Type> fromSequence, int fromStartIndex, MutableSequence<Element_Type> toSequence, int toStartIndex, int numberOfElements) {
            for (int i = 0; i < numberOfElements; i++) {
                toSequence.set(toStartIndex + i, fromSequence.get(fromStartIndex + i));
            }
        }

        public static <Element_Type> void copy(Sequence<Element_Type> fromSequence, MutableSequence<Element_Type> toSequence, int toStartIndex) {
            copy(fromSequence, 0, toSequence, toStartIndex, fromSequence.length());
        }

        public static <Element_Type> void copy(Sequence<Element_Type> fromSequence, MutableSequence<Element_Type> toSequence) {
            copy(fromSequence, toSequence, 0);
        }

    }
}

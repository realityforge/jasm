/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
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

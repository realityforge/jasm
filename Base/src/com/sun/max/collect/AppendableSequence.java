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
 * A {@link Sequence} to which one can append elements.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public interface AppendableSequence<Element_Type> extends MutableSequence<Element_Type> {

    /**
     * Appends a given element to the end of this sequence.
     */
    void append(Element_Type element);

    public static final class Static {
        private Static() {
        }

        public static <Element_Type> void appendAll(AppendableSequence<Element_Type> head, Element_Type... tail) {
            for (Element_Type element : tail) {
                head.append(element);
            }
        }

        public static <Element_Type> void appendAll(AppendableSequence<Element_Type> head, Sequence<Element_Type> tail) {
            for (Element_Type element : tail) {
                head.append(element);
            }
        }

    }
}

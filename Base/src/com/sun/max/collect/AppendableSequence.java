/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b0a4f160-cf18-42a1-ae2f-e114c6bf5bd1*/
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

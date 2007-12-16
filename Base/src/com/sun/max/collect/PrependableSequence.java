/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5bc875a2-6dcd-4404-8cf0-42b7ec7f91f8*/
package com.sun.max.collect;


/**
 * A {@link Sequence} to which one can prepend elements.
 * 
 * @author Doug Simon
 */
public interface PrependableSequence<Element_Type> extends Sequence<Element_Type> {

    /**
     * Prepends a given element to the head of this sequence.
     */
    void prepend(Element_Type element);
    
    /**
     * Prepends a given list of elements to the head of this sequence.
     */
    void prependAll(Element_Type... elements);

    /**
     * Prepends a given list of elements to the head of this sequence.
     */
    void prependAll(Sequence<? extends Element_Type> elements);
}

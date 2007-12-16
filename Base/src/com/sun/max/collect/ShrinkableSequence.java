/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b753c312-5353-4766-99d4-5738fc0de0a4*/
package com.sun.max.collect;

/**
 * A {@link Sequence} from which elements can be removed.
 * 
 * @author Doug Simon
 */
public interface ShrinkableSequence<Element_Type> extends Sequence<Element_Type> {

    /**
     * Removes the element at a given index from this sequence and returns it.
     * 
     * @throws IndexOutOfBoundsException if {@code 0 < index || index >= length()}
     */
    Element_Type remove(int index);

    /**
     * Removes the first element from this sequence and returns it.
     * 
     * @throws IndexOutOfBoundsException if this sequence is {@linkplain Sequence#isEmpty() empty}
     */
    Element_Type removeFirst();

    /**
     * Removes the last element from this sequence and returns it.
     * 
     * @throws IndexOutOfBoundsException if this sequence is {@linkplain Sequence#isEmpty() empty}
     */
    Element_Type removeLast();
    
    public static final class Static {
        private Static() {            
        }
        
        /**
         * Removes a single instance of a specified element from this sequence, if it is present.
         *
         * @return the removed element or null
         */
        public static <Element_Type> Element_Type removeEquals(ShrinkableSequence<Element_Type> sequence, Element_Type element) {
            if (element == null) {
                for (int i = 0; i < sequence.length(); i++) {
                    if (sequence.get(i) == null) {
                        return sequence.remove(i);
                    }
                }
            } else {
                for (int i = 0; i < sequence.length(); i++) {
                    if (sequence.get(i) == element) {
                        return sequence.remove(i);
                    }
                }                
            }
            return null;
        }
    }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=de27f6d4-1826-4a60-93f9-26b2bfe01798*/
package com.sun.max.collect;

/**
 * A @link {@link Sequence} that can be mutated in any way.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public interface VariableSequence<Element_Type> extends AppendableSequence<Element_Type>, MutableSequence<Element_Type>, PrependableSequence<Element_Type>, ShrinkableSequence<Element_Type> {
}

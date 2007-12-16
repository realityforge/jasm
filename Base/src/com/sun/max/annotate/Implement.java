/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=63a68506-e63c-417e-9d7a-556585f7deac*/
package com.sun.max.annotate;

import java.lang.annotation.*;

@Target(ElementType.METHOD)

/**
 * Indicates that a method declaration implements a method declared by the interface specified by 'value()'.
 * This can be seen as a companion to the '@Override' marker, which is supported at least by some IDEs.
 * <p> 
 * The Maxwell specific annotation processor that plugs into the Sun apt tool checks that:
 *
 * - the Class value specified for this annotation is an interface
 * - a method annotated with this annotation actually implements a method in the specified interface
 * - this annotation is not applied to a method in an interface
 * - the first method in a class hierachy that implements an interface method is annotated with this annotation
 * 
 * @see MethodAnnotationsTest
 * @see MaxwellBaseAnnotationProcessor
 *
 * @author Bernd Mathiske
 */
public @interface Implement {
    Class value();    
}

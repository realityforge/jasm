/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f32324f4-70e9-44d3-a097-e79895a3e012*/
package com.sun.max.lang;

/**
 * Creates a function wrapper for a method that has a non-void return type and declares 1 checked exception.
 * 
 * @author Bernd Mathiske
 */
public interface Function1<Result_Type, Exception_Type extends Exception> extends Function2<Result_Type, Exception_Type, Exception_Type> {

    Result_Type run() throws Exception_Type;
    
}

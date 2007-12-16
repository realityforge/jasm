/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d9037e9c-0806-4804-b0ae-0e988f1019ba*/
package com.sun.max.lang;

/**
 * Creates a function wrapper for a method that has a non-void return type and declares no checked exceptions.
 * 
 * @author Bernd Mathiske
 */
public interface Function<Result_Type> {

    Result_Type run();
    
}

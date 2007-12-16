/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a00402a6-ca13-4fc8-8aa9-a2b0fcda996e*/
package com.sun.max.lang;

/**
 * Creates a function wrapper for a method that has a non-void return type and declares 3 checked exceptions.
 * 
 * @author Bernd Mathiske
 */
public interface Function3<Result_Type, Exception_Type1 extends Exception, Exception_Type2 extends Exception, Exception_Type3 extends Exception> {

    Result_Type run() throws Exception_Type1, Exception_Type2, Exception_Type3;
    
}

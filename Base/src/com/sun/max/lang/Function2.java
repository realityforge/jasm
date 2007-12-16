/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=b0d13bf5-6b2c-4ef6-bc05-05841adee074*/
package com.sun.max.lang;

/**
 * Creates a function wrapper for a method that has a non-void return type and declares 2 checked exceptions.
 * 
 * @author Bernd Mathiske
 */
public interface Function2<Result_Type, Exception_Type1 extends Exception, Exception_Type2 extends Exception> extends Function3<Result_Type, Exception_Type1, Exception_Type2, Exception_Type2> {

    Result_Type run() throws Exception_Type1, Exception_Type2;
    
}

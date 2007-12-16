/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a4c83862-3e4f-49d0-94f1-3a17049fb501*/
package com.sun.max.lang;

/**
 * Creates a function wrapper for a method that has a non-void return type and declares 5 checked exceptions.
 * 
 * @author Doug Simon
 */
public interface Function5<Result_Type, Exception_Type1 extends Exception,
                                        Exception_Type2 extends Exception,
                                        Exception_Type3 extends Exception,
                                        Exception_Type4 extends Exception,
                                        Exception_Type5 extends Exception> {
    Result_Type run() throws Exception_Type1, Exception_Type2, Exception_Type3, Exception_Type4, Exception_Type5;
    
}

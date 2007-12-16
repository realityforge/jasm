/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d67aad50-a344-4cc9-85aa-7dfd20b65f58*/
package com.sun.max.lang;

/**
 * Creates a function wrapper for a method that has a non-void return type and declares 4 checked exceptions.
 * 
 * @author Doug Simon
 */
public interface Function4<Result_Type, Exception_Type1 extends Exception, Exception_Type2 extends Exception, Exception_Type3 extends Exception, Exception_Type4 extends Exception> {

    Result_Type run() throws Exception_Type1, Exception_Type2, Exception_Type3, Exception_Type4;
    
}

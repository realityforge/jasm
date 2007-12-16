/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ca15b065-3a3e-43a6-883e-33032b2d9e77*/
package com.sun.max.lang;



public interface Runnable1<Exception_Type extends Exception> extends Runnable2<Exception_Type, Exception_Type> {

    void run() throws Exception_Type;
        
}

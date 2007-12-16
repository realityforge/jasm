/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=ce65f644-71bf-4b55-b851-32492d4042c3*/
package com.sun.max.collect;

/**
 * @author Bernd Mathiske
 */
public interface MapFunction<From_Type, To_Type> {

    To_Type map(From_Type from);
    
}

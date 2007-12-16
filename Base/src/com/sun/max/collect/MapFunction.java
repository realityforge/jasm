/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.collect;

/**
 * @author Bernd Mathiske
 */
public interface MapFunction<From_Type, To_Type> {

    To_Type map(From_Type from);

}

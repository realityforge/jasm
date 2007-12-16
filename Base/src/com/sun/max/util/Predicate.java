/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.util;

/**
 * @author Bernd Mathiske
 */
public interface Predicate<Type> {

    boolean evaluate(Type object);

}

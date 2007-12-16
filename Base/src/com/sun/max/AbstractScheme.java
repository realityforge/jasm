/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max;

/**
 * @author Bernd Mathiske
 */
public abstract class AbstractScheme implements Scheme {

    protected AbstractScheme() {
    }

    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return name();
    }

}

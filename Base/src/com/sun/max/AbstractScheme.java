/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4633e851-6b8e-4cfa-a588-1ef09b0d22aa*/
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

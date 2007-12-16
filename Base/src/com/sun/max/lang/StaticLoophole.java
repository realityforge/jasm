/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.lang;


/**
 * Static type loophole that prevents "unchecked" compiler warnings but that does not circumvent dynamic type checks.
 *
 * @author Bernd Mathiske
 * @author Doug Simon (modified to use @SuppressWarnings instead of reflection)
 */
public final class StaticLoophole {

    private StaticLoophole() {
    }

    /**
     * Statically cast an object to an arbitrary Object type WITHOUT eliminating dynamic erasure checks.
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Class<T> type, Object object) {
        return (T) object;
    }

}

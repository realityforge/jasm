/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
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

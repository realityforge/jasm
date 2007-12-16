/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.program;


/**
 * Attention markers for programmers.
 *
 * @author Bernd Mathiske
 */
public final class Problem {

    private Problem() {

    }

    public static void todo(String task) {
    }

    public static void unimplemented(String message) {
        throw new ProgramError("unimplemented: " + message);
    }

    public static void unimplemented() {
        throw new ProgramError("unimplemented");
    }

    public static void error(String message) {
        System.err.println("<Problem.error>: " + message);
    }
}

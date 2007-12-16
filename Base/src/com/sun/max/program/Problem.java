/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
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

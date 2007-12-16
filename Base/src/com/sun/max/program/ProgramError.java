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
 * @author Bernd Mathiske
 */
public class ProgramError extends Error {

    private static final long serialVersionUID = 0;

    public ProgramError(String message) {
        this(message, null);
    }

    public ProgramError(String message, Throwable cause) {
        super(message, cause);
    }


    public static void check(boolean condition) {
        if (!condition) {
            throw new ProgramError("Program Error");
        }
    }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new ProgramError(message);
        }
    }

    public static void unexpected(String message, Throwable throwable) {
        throw new ProgramError("Unexpected Program Error: " + message, throwable);
    }

    public static void unexpected(String message) {
        unexpected(message, null);
    }

    public static void unexpected(Throwable throwable) {
        unexpected("", throwable);
    }

    public static void unexpected() {
        unexpected("");
    }

    public static void unknownCase() {
        unexpected("unknown switch case");
    }

    public static void fatal(String message) {
        System.err.println("FATAL PROGRAM ERROR: " + message);
        System.exit(1);
    }
}

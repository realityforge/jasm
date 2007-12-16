/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8ecbf6c7-01ac-4525-9424-37d7780b1989*/
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

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.program;

/**
 * @author Bernd Mathiske
 */
public final class ProgramWarning {

    private ProgramWarning() {

    }

    public static void message(String warning) {
        System.err.println("WARNING: " + warning);
    }

    public static void check(boolean condition, String warning) {
        if (!condition) {
            message(warning);
        }
    }

}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
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

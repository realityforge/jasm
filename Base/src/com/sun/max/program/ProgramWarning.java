/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8c9d1c43-dbf0-4e80-b5a8-4a7e0d0347ec*/
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

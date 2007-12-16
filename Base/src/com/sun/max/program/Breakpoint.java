/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=8d6722f4-549f-4396-a999-9e25b763e146*/
package com.sun.max.program;

/**
 * General idea: place Breakpoint.when() somwhere to cause a breakpoint.
 * Not yet implemented
 *
 * @author Bernd Mathiske
 */
public final class Breakpoint {

    private Breakpoint() {
    }
    
    public static void stop() {
        // Place a breakpoint on this statement:
        System.out.print("");
    }
    
    public static boolean when(boolean condition) {
        if (condition) {
            stop();
            return true;
        }
        return false;
    }

}

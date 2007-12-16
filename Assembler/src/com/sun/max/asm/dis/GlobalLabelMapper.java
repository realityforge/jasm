/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=17a9b7b6-7471-4f15-9ba1-3424caac0153*/
package com.sun.max.asm.dis;

/**
 * Allows readable names to be given to branch displacements
 * (including calls) which point outside the function being disassembled.
 *
 * @author Greg Wright
 */
public interface GlobalLabelMapper {
    /**
     * 
     * @param offsetFromCurrentMethodEntryPoint The displacement to be named, measured from the method entry.
     * 
     * @return The String naming the destination, or null if none.
     */
    String map(int offsetFromCurrentMethodEntryPoint);
}

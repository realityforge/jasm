/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=eabb757b-e778-4fe5-ae6a-547872858f69*/
package com.sun.max.asm;

/**
 * A runtime argument to an assembler method.
 *
 * @author Bernd Mathiske
 */
public interface Argument {

    /**
     * @return the external assembler syntax for this argument
     */
    String externalValue();

    /**
     * @return the disassembler syntax for this argument
     */
    String disassembledValue();
    
    /**
     * Different argument types may have different value ranges,
     * but they are all less or equally wide as a long.
     * 
     * @return the value of this argument sign-extended to a long
     */
    long asLong();
    
}

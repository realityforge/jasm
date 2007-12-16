/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm;

/**
 * Assemblers for 32-bit address spaces.
 *
 * @author Bernd Mathiske
 */
public interface Assembler32 {

    /**
     * Gets the base address for relative labels.
     *
     * @return the address at which the assembled object code will reside
     */
    int startAddress();

    /**
     * Assigns a fixed, absolute 32-bit address to a given label.
     *
     * @param label    the label to update
     * @param address  an absolute 32-bit address
     */
    void fixLabel(Label label, int address);

    /**
     * Gets the address to which a label has been bound.
     *
     * @param label  the label to decode
     * @return the address to which {@code label} has been bound
     * @throws AssemblyException if {@code label} has not been bound to an address
     */
    int address(Label label) throws AssemblyException;
}

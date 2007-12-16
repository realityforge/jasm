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
package jasm;

/**
 * Assemblers for 64-bit address spaces.
 *
 * @author Bernd Mathiske
 */
public interface Assembler64 {

    /**
     * Gets the base address for relative labels.
     *
     * @return the address at which the assembled object code will reside
     */
    long startAddress();

    void setStartAddress(long address);

    /**
     * Assigns a fixed, absolute 64-bit address to a given label.
     *
     * @param label    the label to update
     * @param address  an absolute 64-bit address
     */
    void fixLabel(Label label, long address);

    /**
     * Gets the address to which a label has been bound.
     *
     * @param label  the label to decode
     * @return the address to which {@code label} has been bound
     * @throws AssemblyException if {@code label} has not been bound to an address
     */
    long address(Label label) throws AssemblyException;

}

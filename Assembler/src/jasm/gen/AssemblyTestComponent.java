/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.gen;

/**
 * The set of tests that can be performed against a generated assembler.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public enum AssemblyTestComponent {

    /**
     * Tests that the output of the assembler can be disassembled.
     */
    DISASSEMBLER,

    /**
     * Tests that the output of the assembler matches that of the platform specific
     * external assembler (e.g. the GNU 'gas' assembler).
     */
    EXTERNAL_ASSEMBLER;
}

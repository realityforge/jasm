/*
 * Copyright (c) 2005 Sun Microsystems, Inc.  All rights reserved.  U.S. Government Rights - Commercial software.
 * Government users are subject to the Sun Microsystems, Inc. standard license agreement and applicable provisions
 * of the FAR and its supplements. Use is subject to license terms. Sun, Sun Microsystems, the Sun logo and
 * Java are trademarks or registered trademarks of Sun Microsystems, Inc. in the U.S. and other countries. All SPARC
 * trademarks are used under license and are trademarks or registered trademarks of SPARC International, Inc. in the
 * U.S. and other countries.
 */
/*VCSID=fb98ca65-8055-410c-a353-a6eb16a21b66*/
/**
 * An assembly system for (almost all of) the IA32 instruction set.
 * Our own restriction here: the default address and operand size is ALWAYS 32 bits.
 *
 * We have the capability to include instructions with 16-bit addressing,
 * but by default we don't.
 *
 * Once IA32RawAssembler and IA32LabelAssembler have been generated,
 * this package can be used separate from the framework
 * by importing the following assembler packages only:
 *
 *     jasm
 *     jasm.x86
 *     jasm.ia32
 *
 * @author Bernd Mathiske
 */
package jasm.ia32;

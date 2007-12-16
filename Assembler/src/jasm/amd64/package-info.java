/*
 * Copyright (c) 2005 Sun Microsystems, Inc.  All rights reserved.  U.S. Government Rights - Commercial software.
 * Government users are subject to the Sun Microsystems, Inc. standard license agreement and applicable provisions
 * of the FAR and its supplements. Use is subject to license terms. Sun, Sun Microsystems, the Sun logo and
 * Java are trademarks or registered trademarks of Sun Microsystems, Inc. in the U.S. and other countries. All SPARC
 * trademarks are used under license and are trademarks or registered trademarks of SPARC International, Inc. in the
 * U.S. and other countries.
 */
/*VCSID=8f414883-0ff7-4a0c-b2e9-1a3a0614f490*/
/**
 * An assembly system for AMD 64 processors in "64-bit mode".
 *
 * We have the capability to include instructions with 32-bit or 16-bit addressing,
 * but by default we don't.

 * Once the AMD4RawAssembler and AM64LabelAssembler have been generated,
 * this package can be used separate from the framework
 * by importing the following assembler packages only:
 *
 *     jasm
 *     jasm.x86
 *     jasm.amd64
 *
 * @author Bernd Mathiske
 */
package jasm.amd64;

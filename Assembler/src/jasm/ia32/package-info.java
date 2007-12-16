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

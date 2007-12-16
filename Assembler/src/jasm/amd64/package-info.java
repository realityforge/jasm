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

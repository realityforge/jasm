/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools;

/** The set of tests that can be performed against a generated assembler. */
public enum AssemblyTestComponent {

  /** Tests that the output of the assembler can be disassembled. */
  DISASSEMBLER,

  /**
   * Tests that the output of the assembler matches that of the platform specific
   * external assembler (e.g. the GNU 'gas' assembler).
   */
  EXTERNAL_ASSEMBLER
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm;

/** A runtime argument to an assembler method. */
public interface Argument {

  /** @return the external assembler syntax for this argument */
  String externalValue();

  /** @return the disassembler syntax for this argument */
  String disassembledValue();

  /**
   * Different argument types may have different value ranges,
   * but they are all less or equally wide as a long.
   *
   * @return the value of this argument sign-extended to a long
   */
  long asLong();
}

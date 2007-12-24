/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis;

/**
 * Allows readable names to be given to branch displacements
 * (including calls) which point outside the function being disassembled.
 */
public interface GlobalLabelMapper {
  /**
   * @param offsetFromCurrentMethodEntryPoint
   *         The displacement to be named, measured from the method entry.
   * @return The String naming the destination, or null if none.
   */
  String map(int offsetFromCurrentMethodEntryPoint);
}

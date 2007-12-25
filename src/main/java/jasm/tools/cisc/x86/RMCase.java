/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

public enum RMCase {
  NORMAL(0), SIB(4), SWORD(6), SDWORD(5);

  private final int _rmFieldValue;

  private RMCase(int rmFieldValue) {
    _rmFieldValue = rmFieldValue;
  }

  public int value() {
    return _rmFieldValue;
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.tools.Operand;

/**
 * Description of an assembly instruction operand.
 */
public abstract class X86Operand implements Operand {
  private Designation _designation;

  protected X86Operand(Designation designation) {
    _designation = designation;
  }

  public final Designation designation() {
    return _designation;
  }
}

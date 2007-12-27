/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.dis;

import jasm.tools.ImmediateArgument;

/** Delegation interface (for lack of multiple class inheritance in the Java(TM) Programming Language). */
public interface AddressInstruction {

  int startOffset();

  String addressString();

  int addressToOffset(ImmediateArgument argument);
}

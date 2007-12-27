/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.WordWidth;
import jasm.tools.AddressParameter;

public final class X86AddressParameter
    extends X86NumericalParameter
    implements AddressParameter {

  public X86AddressParameter(Designation designation, WordWidth width) {
    super(designation, width, ParameterPlace.DISPLACEMENT);
    setVariableName("m" + width().numberOfBits());
  }
}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.cisc.x86;

import jasm.Argument;
import jasm.tools.AssemblyTestComponent;
import jasm.tools.TestArgumentExclusion;
import jasm.tools.util.CollectionUtil;

public enum FloatingPointOperandCode {
  bytes_2(""),
  bytes_14_28(""),
  bytes_98_108(""),
  word_integer("s"),
  short_integer("l"),
  long_integer("q"),
  single_real("s"),
  double_real("l"),
  extended_real("t"),
  packed_bcd(""),
  ST_i("");

  private final String _operandTypeSuffix;

  private FloatingPointOperandCode(String operandTypeSuffix) {
    _operandTypeSuffix = operandTypeSuffix;
  }

  public String operandTypeSuffix() {
    return _operandTypeSuffix;
  }

  public TestArgumentExclusion excludeExternalTestArguments(Argument... arguments) {
    return new TestArgumentExclusion(AssemblyTestComponent.EXTERNAL_ASSEMBLER, this, CollectionUtil.hashSetFrom(arguments));
  }
}

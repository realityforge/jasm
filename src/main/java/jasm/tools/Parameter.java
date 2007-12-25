/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools;

import jasm.Argument;
import java.util.Set;

/**
 * An operand that represents a formal parameter of an assembler method.
 */
public interface Parameter extends Operand, Comparable<Parameter> {

  /**
   * @return source code variable name
   */
  String variableName();

  /**
   * @return source code for raw int value access
   */
  String valueString();

  Iterable<? extends Argument> getLegalTestArguments();

  Iterable<? extends Argument> getIllegalTestArguments();

  ArgumentRange argumentRange();

  Set<Argument> excludedDisassemblerTestArguments();

  Set<Argument> excludedExternalTestArguments();
}

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
import jasm.WordWidth;
import jasm.tools.Immediate16Argument;
import jasm.tools.Immediate32Argument;
import jasm.tools.Immediate64Argument;
import jasm.tools.Immediate8Argument;
import jasm.tools.ImmediateArgument;
import jasm.tools.ImmediateParameter;
import jasm.tools.Parameter;
import jasm.tools.util.ProgramError;
import java.util.Arrays;
import java.util.Collections;

public abstract class X86NumericalParameter extends X86Parameter implements Parameter, ImmediateParameter {

  private final WordWidth _width;

  public X86NumericalParameter(X86Operand.Designation designation, WordWidth width) {
    super(designation, ParameterPlace.APPEND);
    _width = width;
  }

  public final WordWidth width() {
    return _width;
  }

  public final String valueString() {
    return variableName();
  }

  public final Class type() {
    return width().canonicalPrimitiveType();
  }

  public final Iterable<? extends ImmediateArgument> getLegalTestArguments() {
    try {
      switch (_width) {
        case BITS_8:
          return Arrays.asList(new Immediate8Argument(Byte.MIN_VALUE),
                               new Immediate8Argument((byte) -1),
                               new Immediate8Argument((byte) 2),
                               new Immediate8Argument(Byte.MAX_VALUE));
        case BITS_16:
          return Arrays.asList(new Immediate16Argument(Short.MIN_VALUE),
                               new Immediate16Argument((short) (Byte.MIN_VALUE - 1)),
                               new Immediate16Argument((short) (Byte.MAX_VALUE + 1)),
                               new Immediate16Argument(Short.MAX_VALUE));
        case BITS_32:
          return Arrays.asList(new Immediate32Argument(Integer.MIN_VALUE),
                               new Immediate32Argument(Short.MIN_VALUE - 1),
                               new Immediate32Argument(Short.MAX_VALUE + 1),
                               new Immediate32Argument(Integer.MAX_VALUE));
        case BITS_64:
          return Arrays.asList(new Immediate64Argument(Long.MIN_VALUE),
                               new Immediate64Argument(Integer.MIN_VALUE - 1L),
                               new Immediate64Argument(Integer.MAX_VALUE + 1L),
                               new Immediate64Argument(Long.MAX_VALUE));
        default:
          ProgramError.unexpected();
          return null;
      }
    } catch (Throwable throwable) {
      ProgramError.unexpected("could not generate test argument for: " + this, throwable);
    }
    return null;
  }

  public final Iterable<? extends Argument> getIllegalTestArguments() {
    return Collections.emptySet();
  }

  @Override
  public final String toString() {
    return getClass().getSimpleName();
  }
}

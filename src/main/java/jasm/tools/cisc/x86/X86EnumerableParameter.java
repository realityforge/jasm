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
import jasm.EnumerableArgument;
import jasm.SymbolSet;
import jasm.tools.EnumerableParameter;
import java.util.Collections;

public final class X86EnumerableParameter<EnumerableArgument_Type extends Enum<EnumerableArgument_Type> & EnumerableArgument>
    extends X86Parameter
    implements EnumerableParameter {
  private final SymbolSet<EnumerableArgument_Type> _symbolSet;

  public X86EnumerableParameter(Designation designation, ParameterPlace place, SymbolSet<EnumerableArgument_Type> symbolSet) {
    super(designation, place);
    _symbolSet = symbolSet;
    switch (place) {
      case MOD_REG:
      case MOD_REG_REXR:
      case MOD_RM:
      case MOD_RM_REXB:
        setVariableName(designation.name().toLowerCase());
        break;
      case SIB_SCALE:
        setVariableName("scale");
        break;
      case SIB_INDEX:
      case SIB_INDEX_REXX:
        setVariableName("index");
        break;
      case SIB_BASE:
      case SIB_BASE_REXB:
        setVariableName("base");
        break;
      case APPEND:
        setVariableName(symbolSet.type().getSimpleName().toLowerCase());
        break;
      case OPCODE1:
      case OPCODE1_REXB:
      case OPCODE2_REXB:
        setVariableName("register");
        break;
      case OPCODE2:
        setVariableName("st_i");
        break;
      default:
        throw new IllegalStateException("Unexpected place: " + place);
    }
  }

  public final SymbolSet<EnumerableArgument_Type> getSymbolSet() {
    return _symbolSet;
  }

  public final Class type() {
    return _symbolSet.type();
  }

  public final String valueString() {
    return variableName() + ".value()";
  }

  public final Iterable<EnumerableArgument_Type> getLegalTestArguments() {
    return _symbolSet;
  }

  public final Iterable<? extends Argument> getIllegalTestArguments() {
    return Collections.emptySet();
  }

  @Override
  public final String toString() {
    return type().getSimpleName();
  }
}

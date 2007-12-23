/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.Argument;
import jasm.EnumerableArgument;
import jasm.SymbolSet;
import jasm.gen.EnumerableParameter;
import jasm.util.program.ProgramError;
import java.util.Collections;

public final class X86EnumerableParameter<EnumerableArgument_Type extends Enum<EnumerableArgument_Type> & EnumerableArgument> extends X86Parameter implements EnumerableParameter {

    private final SymbolSet<EnumerableArgument_Type> _enumerator;

    public X86EnumerableParameter(X86Operand.Designation designation, ParameterPlace place, SymbolSet<EnumerableArgument_Type> enumerator) {
        super(designation, place);
        _enumerator = enumerator;
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
                setVariableName(enumerator.type().getSimpleName().toLowerCase());
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
                ProgramError.unexpected();
        }
    }

    public final SymbolSet<EnumerableArgument_Type> enumerator() {
        return _enumerator;
    }

    public final Class type() {
        return _enumerator.type();
    }

    public final String valueString() {
        return variableName() + ".value()";
    }

    public final Iterable<EnumerableArgument_Type> getLegalTestArguments() {
        return _enumerator;
    }

    public final Iterable<? extends Argument> getIllegalTestArguments() {
      return Collections.emptySet();
    }

    @Override
    public final String toString() {
        return type().getSimpleName();
    }

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=9c40620d-d9ad-477a-ac5c-f1e34a750de2*/
package jasm.gen.cisc.x86;

import com.sun.max.collect.Iterables;
import com.sun.max.program.ProgramError;
import jasm.Argument;
import jasm.EnumerableArgument;
import jasm.gen.EnumerableParameter;
import jasm.util.Enumerator;

/**
 * @author Bernd Mathiske
 */
public class X86EnumerableParameter<EnumerableArgument_Type extends Enum<EnumerableArgument_Type> & EnumerableArgument<EnumerableArgument_Type>> extends X86Parameter implements EnumerableParameter {

    private final Enumerator<EnumerableArgument_Type> _enumerator;

    public X86EnumerableParameter(X86Operand.Designation designation, ParameterPlace place, Enumerator<EnumerableArgument_Type> enumerator) {
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

    public Enumerator<EnumerableArgument_Type> enumerator() {
        return _enumerator;
    }

    public Class type() {
        return _enumerator.type();
    }

    public String valueString() {
        return variableName() + ".value()";
    }

    public Iterable<EnumerableArgument_Type> getLegalTestArguments() {
        return _enumerator;
    }

    public Iterable<? extends Argument> getIllegalTestArguments() {
        return Iterables.empty();
    }

    @Override
    public String toString() {
        return type().getSimpleName();
    }

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=02328611-f711-4b03-b3b4-2ed882d6a2ae*/
package com.sun.max.asm.gen.cisc.x86;

import com.sun.max.annotate.*;
import com.sun.max.asm.*;
import com.sun.max.asm.gen.*;

/**
 * An operand that is already implicit in the machine instruction,
 * without requiring an assembler method parameter.
 *
 * @author Bernd Mathiske
 */
public class X86ImplicitOperand extends X86Operand implements ImplicitOperand {

    private final ImplicitOperand.ExternalPresence _externalPresence;
    private final Argument _argument;

    public X86ImplicitOperand(X86Operand.Designation designation, ImplicitOperand.ExternalPresence externalPresence, Argument argument) {
        super(designation);
        _externalPresence = externalPresence;
        _argument = argument;
    }

    public ImplicitOperand.ExternalPresence externalPresence() {
        return _externalPresence;
    }

    public Class type() {
        return _argument.getClass();
    }

    public Argument argument() {
        return _argument;
    }

    public String name() {
        if (_argument instanceof Enum) {
            final Enum enumerable = (Enum) _argument;
            return enumerable.name();
        }
        final Immediate8Argument immediate8Argument = (Immediate8Argument) _argument;
        assert immediate8Argument.value() > 0;
        return immediate8Argument.signedExternalValue();
    }

    @Override
    public String toString() {
        return "<ImplicitOperand: " + _argument.externalValue() + ">";
    }
}

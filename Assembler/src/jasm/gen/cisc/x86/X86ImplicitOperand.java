/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.Argument;
import jasm.gen.Immediate8Argument;
import jasm.gen.ImplicitOperand;

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

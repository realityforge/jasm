/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen.cisc.x86;

import jasm.util.program.ProgramError;
import jasm.Argument;
import jasm.gen.ArgumentRange;
import jasm.gen.Parameter;
import jasm.gen.TestArgumentExclusion;
import java.util.HashSet;
import java.util.Set;

/**
 * An explicit operand, specifying an assembler method parameter.
 *
 * @author Bernd Mathiske
 */
public abstract class X86Parameter extends X86Operand implements Parameter {

    private final ParameterPlace _place;

    protected X86Parameter(X86Operand.Designation designation, ParameterPlace place) {
        super(designation);
        _place = place;
    }

    public ParameterPlace place() {
        return _place;
    }

    private String _variableName = "p";

    public void setVariableName(String variableName) {
        _variableName = variableName;
    }

    public String variableName() {
        return _variableName;
    }

    private ArgumentRange _argumentRange;

    public ArgumentRange argumentRange() {
        return _argumentRange;
    }

    public void setArgumentRange(ArgumentRange argumentRange) {
        _argumentRange = argumentRange;
    }

    private Set<Argument> _excludedDisassemblerTestArguments = new HashSet<Argument>();
    private Set<Argument> _excludedExternalTestArguments = new HashSet<Argument>();

    public void excludeTestArguments(TestArgumentExclusion testArgumentExclusion) {
        switch (testArgumentExclusion.component()) {
            case DISASSEMBLER:
                _excludedDisassemblerTestArguments = testArgumentExclusion.arguments();
                break;
            case EXTERNAL_ASSEMBLER:
                _excludedExternalTestArguments = testArgumentExclusion.arguments();
                break;
            default:
                ProgramError.unexpected();
        }
    }

    public Set<Argument> excludedDisassemblerTestArguments() {
        return _excludedDisassemblerTestArguments;
    }

    public Set<Argument> excludedExternalTestArguments() {
        return _excludedExternalTestArguments;
    }

    public int compareTo(Parameter other) {
        return type().getName().compareTo(other.type().getName());
    }
}

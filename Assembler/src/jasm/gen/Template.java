/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=a1ecb77c-63cf-4fba-a8ef-5f7bde5c0357*/
package jasm.gen;

import com.sun.max.collect.Sequence;
import com.sun.max.program.ProgramError;
import jasm.Argument;
import java.lang.reflect.Method;

/**
 * An internal representation of an assembler method.
 *
 * @author Bernd Mathiske
 */
public abstract class Template implements Cloneable, Comparable<Template> {

    private int _serial = -1;
    private InstructionDescription _instructionDescription;
    private int _labelParameterIndex = -1;

    protected Template(InstructionDescription instructionDescription) {
        _instructionDescription = instructionDescription;
    }

    protected Template(InstructionDescription instructionDescription, int serial) {
        _instructionDescription = instructionDescription;
        _serial = serial;
    }

    public int serial() {
        return _serial;
    }

    public void setSerial(int serial) {
        _serial = serial;
    }

    public InstructionDescription instructionDescription() {
        return _instructionDescription;
    }

    public int labelParameterIndex() {
        return _labelParameterIndex;
    }

    /**
     * Call this right before adding a parameter that may be represented by a label.
     */
    protected void setLabelParameterIndex() {
        if (_labelParameterIndex != -1) {
            ProgramError.unexpected("a template can have at most one label parameter");
        }
        _labelParameterIndex = parameters().length();
    }

    public abstract String assemblerMethodName();

    protected Method _assemblerMethod;

    /**
     * The name of the Java method that will be created from this template.
     */
    private String _internalName;

    public String internalName() {
        return _internalName;
    }

    protected void setInternalName(String internalName) {
        _internalName = internalName;
    }

    public String externalName() {
        if (_instructionDescription.externalName() != null) {
            return _instructionDescription.externalName();
        }
        return internalName();
    }

    public boolean isDisassemblable() {
        return _instructionDescription.isDisassemblable();
    }

    public boolean isExternallyTestable() {
        return _instructionDescription.isExternallyTestable();
    }

    public abstract Sequence<? extends Operand> operands();

    public abstract Sequence<? extends Parameter> parameters();

    /**
     * Gets the argument from a given list of arguments corresponding to a parameter of this template.
     *
     * @return the argument at index {@code i} in {@code arguments} where {@code parameter == parameters().get(i)}
     */
    public Argument bindingFor(Parameter parameter, Sequence<Argument> arguments) {
        final Sequence< ? extends Parameter> parameters = parameters();
        assert arguments.length() == parameters.length();
        final int index = Sequence.Static.indexOfIdentical(parameters, parameter);
        ProgramError.check(index != -1, parameter + " is not a parameter of " + externalName());
        return arguments.get(index);
    }

    public Class[] parameterTypes() {
        final Class[] parameterTypes = new Class[parameters().length()];
        for (int i = 0; i < parameters().length(); i++) {
            parameterTypes[i] = parameters().get(i).type();
        }
        return parameterTypes;
    }

    @Override
    public Template clone() {
        try {
            final Template result = (Template) super.clone();
            result._instructionDescription = _instructionDescription.clone();
            return result;
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            ProgramError.unexpected(cloneNotSupportedException);
        }
        return null;
    }

    public int compareTo(Template other) {
        int result = _internalName.compareTo(other._internalName);
        if (result != 0) {
            return result;
        }
        final Sequence<? extends Parameter> myParameters = parameters();
        final Sequence<? extends Parameter> otherParameters = other.parameters();
        final int n = Math.min(myParameters.length(), otherParameters.length());
        for (int i = 0; i < n; i++) {
            result = myParameters.get(i).compareTo(otherParameters.get(i));
            if (result != 0) {
                return result;
            }
        }
        return new Integer(myParameters.length()).compareTo(otherParameters.length());
    }

    public boolean isEquivalentTo(Template other) {
        return this == other;
    }
}

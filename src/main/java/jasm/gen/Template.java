/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import jasm.Argument;
import jasm.util.collect.CollectionUtil;
import jasm.util.program.ProgramError;
import java.lang.reflect.Method;
import java.util.List;

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
        _labelParameterIndex = parameters().size();
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

    public abstract List<? extends Operand> operands();

    public abstract List<? extends Parameter> parameters();

    /**
     * Gets the argument from a given list of arguments corresponding to a parameter of this template.
     *
     * @return the argument at index {@code i} in {@code arguments} where {@code parameter == parameters().get(i)}
     */
    public Argument bindingFor(Parameter parameter, List<Argument> arguments) {
        final List< ? extends Parameter> parameters = parameters();
        assert arguments.size() == parameters.size();
        final int index = CollectionUtil.indexOfIdentical(parameters, parameter);
        ProgramError.check(index != -1, parameter + " is not a parameter of " + externalName());
        return arguments.get(index);
    }

    public Class[] parameterTypes() {
      final List<? extends Parameter> parameters = parameters();
      final Class[] parameterTypes = new Class[parameters.size()];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypes[i] = parameters.get(i).type();
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
        final List<? extends Parameter> myParameters = parameters();
        final List<? extends Parameter> otherParameters = other.parameters();
        final int n = Math.min(myParameters.size(), otherParameters.size());
        for (int i = 0; i < n; i++) {
            result = myParameters.get(i).compareTo(otherParameters.get(i));
            if (result != 0) {
                return result;
            }
        }
        return new Integer(myParameters.size()).compareTo(otherParameters.size());
    }

    public boolean isEquivalentTo(Template other) {
        return this == other;
    }
}

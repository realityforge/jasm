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
import jasm.Assembler;
import jasm.AssemblyException;
import jasm.InstructionSet;
import jasm.Label;
import jasm.gen.risc.bitRange.BitRangeOrder;
import jasm.util.collect.AppendableSequence;
import jasm.util.collect.ArrayListSequence;
import jasm.util.collect.Sequence;
import jasm.util.program.ProgramError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * An assembly framework, instantiated once per instruction set.
 *
 * @author Bernd Mathiske
 * @author Dave Ungar
 * @author Adam Spitz
 */
public abstract class Assembly<Template_Type extends Template> {

    private final InstructionSet _instructionSet;
    private final Class<Template_Type> _templateType;

    protected Assembly(InstructionSet instructionSet, Class<Template_Type> templateType) {
        _instructionSet = instructionSet;
        _templateType = templateType;
    }

    public InstructionSet instructionSet() {
        return _instructionSet;
    }

    public Class<Template_Type> templateType() {
        return _templateType;
    }

    protected abstract Sequence<Template_Type> createTemplates();

    private Sequence<Template_Type> _templates;

    public Sequence<Template_Type> templates() {
        if (_templates == null) {
            _templates = createTemplates();
        }
        return _templates;
    }

    public Sequence<Template_Type> getLabelTemplates() {
        final AppendableSequence<Template_Type> result = new ArrayListSequence<Template_Type>();
        for (Template_Type template : templates()) {
            if (template.labelParameterIndex() >= 0) {
                result.append(template);
            }
        }
        return result;
    }

    public abstract BitRangeOrder bitRangeEndianness();

    private Object getBoxedJavaValue(Argument argument) {
        if (argument instanceof ImmediateArgument) {
            final ImmediateArgument immediateArgument = (ImmediateArgument) argument;
            return immediateArgument.boxedJavaValue();
        }
        return argument;
    }

    public final String createMethodCallString(Template_Type template, Sequence<Argument> argumentList) {
        assert argumentList.length() == template.parameters().length();
        String call = template.assemblerMethodName() + "(";
        for (int i = 0; i < argumentList.length(); i++) {
            call += ((i == 0) ? "" : ", ") + getBoxedJavaValue(argumentList.get(i));
        }
        return call + ")";
    }

    private Method getAssemblerMethod(Assembler assembler, Template_Type template, Class[] parameterTypes) {
        try {
            return assembler.getClass().getMethod(template.assemblerMethodName(), parameterTypes);
        } catch (Throwable throwable) {
            ProgramError.unexpected("could not find assembler method for template: " + this);
        }
        return null;
    }

    private Method getAssemblerMethod(Assembler assembler, Template_Type template, Sequence<Argument> arguments) {
        final Class[] parameterTypes = template.parameterTypes();
        final int index = template.labelParameterIndex();
        if (index >= 0 && arguments.get(index) instanceof Label) {
            parameterTypes[index] = Label.class;
            return getAssemblerMethod(assembler, template, parameterTypes);
        }
        if (template._assemblerMethod == null) {
            template._assemblerMethod = getAssemblerMethod(assembler, template, parameterTypes);
        }
        return template._assemblerMethod;
    }

    public void assemble(Assembler assembler, Template_Type template, Sequence<Argument> arguments) throws AssemblyException {
        assert arguments.length() == template.parameters().length();
        final Method assemblerMethod = getAssemblerMethod(assembler, template, arguments);
        final Object[] objects = new Object[arguments.length()];
        for (int i = 0; i < arguments.length(); i++) {
            objects[i] = getBoxedJavaValue(arguments.get(i));
        }
        try {
            assemblerMethod.invoke(assembler, objects);
        } catch (IllegalArgumentException illegalArgumentException) {
            ProgramError.unexpected("argument type mismatch", illegalArgumentException);
        } catch (IllegalAccessException illegalAccessException) {
            ProgramError.unexpected("illegal access to assembler method unexpected", illegalAccessException);
        } catch (InvocationTargetException invocationTargetException) {
            final Throwable target = invocationTargetException.getTargetException();
            if (target instanceof AssemblyException) {
                throw (AssemblyException) target;
            }
            if (target instanceof IllegalArgumentException) {
                throw (IllegalArgumentException) target;
            }
            ProgramError.unexpected(invocationTargetException);
        }
    }

}
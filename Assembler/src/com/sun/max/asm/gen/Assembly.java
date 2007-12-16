/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=af5aeb5a-2d60-4842-8124-09b832cc1da9*/
package com.sun.max.asm.gen;

import com.sun.max.MaxPackage;
import com.sun.max.asm.Argument;
import com.sun.max.asm.Assembler;
import com.sun.max.asm.AssemblyException;
import com.sun.max.asm.InstructionSet;
import com.sun.max.asm.Label;
import com.sun.max.asm.gen.risc.bitRange.BitRangeOrder;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.program.ProgramError;
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

    private static MaxPackage instructionSetPackage(InstructionSet instructionSet) {
        final MaxPackage thisPackage = MaxPackage.fromClass(Assembly.class);
        return thisPackage.subPackage(instructionSet.category().name().toLowerCase(), instructionSet.name().toLowerCase());
    }

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

    public MaxPackage getPackage() {
        return instructionSetPackage(_instructionSet);
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

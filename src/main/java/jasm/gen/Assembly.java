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
import jasm.util.ProgramError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * An assembly framework, instantiated once per instruction set.
 */
public abstract class Assembly<Template_Type extends Template> {

  private final InstructionSet _instructionSet;
  private final Class<Template_Type> _templateType;
  private List<Template_Type> _templates;

  protected Assembly(InstructionSet instructionSet, Class<Template_Type> templateType) {
    _instructionSet = instructionSet;
    _templateType = templateType;
  }

  public final InstructionSet instructionSet() {
    return _instructionSet;
  }

  public final Class<Template_Type> templateType() {
    return _templateType;
  }

  protected abstract List<Template_Type> createTemplates();

  public final List<Template_Type> templates() {
    if (_templates == null) {
      _templates = createTemplates();
    }
    return _templates;
  }

  public final List<Template_Type> getLabelTemplates() {
    final ArrayList<Template_Type> result = new ArrayList<Template_Type>();
    for (Template_Type template : templates()) {
      if (template.labelParameterIndex() >= 0) {
        result.add(template);
      }
    }
    return result;
  }

  private Object getBoxedJavaValue(Argument argument) {
    if (argument instanceof ImmediateArgument) {
      final ImmediateArgument immediateArgument = (ImmediateArgument) argument;
      return immediateArgument.boxedJavaValue();
    }
    return argument;
  }

  private Method getAssemblerMethod(Assembler assembler, Template_Type template, Class[] parameterTypes) {
    try {
      return assembler.getClass().getMethod(template.assemblerMethodName(), parameterTypes);
    } catch (Throwable throwable) {
      ProgramError.unexpected("could not find assembler method for template: " + this);
    }
    return null;
  }

  private Method getAssemblerMethod(Assembler assembler, Template_Type template, List<Argument> arguments) {
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

  public final void assemble(Assembler assembler, Template_Type template, List<Argument> arguments) throws AssemblyException {
    assert arguments.size() == template.parameters().size();
    final Method assemblerMethod = getAssemblerMethod(assembler, template, arguments);
    final Object[] objects = new Object[arguments.size()];
    for (int i = 0; i < arguments.size(); i++) {
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

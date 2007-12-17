/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import jasm.util.collect.AppendableSequence;
import jasm.util.collect.ArrayListSequence;
import jasm.util.collect.Sequence;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Bernd Mathiske
 */
public interface ImmediateParameter extends Parameter {

    public static final class Static {

        private Static() {
        }

        public static <Element_Type extends ImmediateArgument, Argument_Type> Sequence<Element_Type> createSequence(Class<Element_Type> elementType,
                        final Class<Argument_Type> argumentType, Argument_Type... values) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
            final AppendableSequence<Element_Type> result = new ArrayListSequence<Element_Type>();
            final Constructor<Element_Type> elementConstructor = elementType.getConstructor(new Class[] {argumentType});
            for (Argument_Type value : values) {
                result.append(elementConstructor.newInstance(value));
            }
            return result;
        }
    }

}

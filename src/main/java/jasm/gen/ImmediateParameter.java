/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.gen;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernd Mathiske
 */
public interface ImmediateParameter extends Parameter {

    public static final class Static {

        private Static() {
        }

        public static <Element_Type extends ImmediateArgument, Argument_Type> List<Element_Type> createSequence(Class<Element_Type> elementType,
                        final Class<Argument_Type> argumentType, Argument_Type... values) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
            final ArrayList<Element_Type> result = new ArrayList<Element_Type>();
            final Constructor<Element_Type> elementConstructor = elementType.getConstructor(argumentType);
            for (Argument_Type value : values) {
                result.add(elementConstructor.newInstance(value));
            }
            return result;
        }
    }

}

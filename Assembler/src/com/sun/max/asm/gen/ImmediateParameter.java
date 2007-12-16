/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=09e5bfba-866f-49ca-8398-c4e017d22478*/
package com.sun.max.asm.gen;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
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

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util;

import jasm.util.collect.AppendableSequence;
import jasm.util.collect.ArrayListSequence;
import jasm.util.collect.Sequence;
import jasm.util.program.ProgramError;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface StaticFieldName {

    String name();

    void setName(String name);

    public interface StringFunction {
        String function(String string);
    }

    public static final class Static {

        public static Sequence<StaticFieldName> initialize(Class staticNameFieldClass, StringFunction stringFunction) {
            final AppendableSequence<StaticFieldName> sequence = new ArrayListSequence<StaticFieldName>();
            for (Field field : staticNameFieldClass.getDeclaredFields()) {
                if ((field.getModifiers() & Modifier.STATIC) != 0 && StaticFieldName.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    try {
                        final StaticFieldName value = (StaticFieldName) field.get(null);
                        if (value.name() == null) {
                            String name = field.getName();
                            if (stringFunction != null) {
                                name = stringFunction.function(name);
                            }
                            value.setName(name);
                        }
                        sequence.append(value);
                    } catch (IllegalAccessException illegalAccessException) {
                        ProgramError.unexpected("could not name value of field: " + field);
                    }
                }
            }
            return sequence;
        }
    }

}

/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package jasm.util;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.program.ProgramError;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface StaticFieldName {

    String name();

    void setName(String name);

    public interface StringFunction {
        String function(String string);
    }

    public interface Procedure {
        void procedure(StaticFieldName staticFieldName);
    }

    public static final class Static {

        private Static() {
        }

        public static Sequence<StaticFieldName> initialize(Class staticNameFieldClass, StringFunction stringFunction, Procedure procedure) {
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
                        if (procedure != null) {
                            procedure.procedure(value);
                        }
                        sequence.append(value);
                    } catch (IllegalAccessException illegalAccessException) {
                        ProgramError.unexpected("could not name value of field: " + field);
                    }
                }
            }
            return sequence;
        }

        public static Sequence<StaticFieldName> initialize(Class staticNameFieldClass, StringFunction stringFunction) {
            return initialize(staticNameFieldClass, stringFunction, null);
        }

        public static Sequence<StaticFieldName> initialize(Class staticNameFieldClass, Procedure procedure) {
            return initialize(staticNameFieldClass, null, procedure);
        }

        public static Sequence<StaticFieldName> initialize(Class staticNameFieldClass) {
            return initialize(staticNameFieldClass, null, null);
        }
    }

}

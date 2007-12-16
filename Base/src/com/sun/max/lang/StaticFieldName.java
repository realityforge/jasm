/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c92e02c5-d313-4d0e-92d3-280c74196848*/
package com.sun.max.lang;

import java.lang.reflect.*;

import com.sun.max.collect.*;
import com.sun.max.program.*;

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

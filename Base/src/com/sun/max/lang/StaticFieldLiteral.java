/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.lang;

import com.sun.max.program.ProgramError;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface StaticFieldLiteral {

    String literal();

    void setLiteral(String literal);

    Class literalClass();

    void setLiteralClass(Class literalClass);

    public static final class Static {

        private Static() {
        }

        public static void initialize(Class staticFieldLiteralClass) {
            for (Field field : staticFieldLiteralClass.getDeclaredFields()) {
                if ((field.getModifiers() & Modifier.STATIC) != 0 && StaticFieldLiteral.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    try {
                        final StaticFieldLiteral staticFieldLiteral = (StaticFieldLiteral) field.get(staticFieldLiteralClass);
                        staticFieldLiteral.setLiteral(field.getName());
                        staticFieldLiteral.setLiteralClass(staticFieldLiteralClass);
                    } catch (IllegalAccessException illegalAccessException) {
                        ProgramError.unexpected("could not name literal of field: " + field);
                    }
                }
            }
        }
    }

}

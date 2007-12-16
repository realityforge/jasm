/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=420ad3c6-93ab-402e-b7f8-6135a685fb47*/
package com.sun.max.lang;

import java.lang.reflect.*;

import com.sun.max.program.*;


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

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=37c5e8ff-bcf3-4882-88c8-1a33c7c061f9*/
package com.sun.max.lang;

import com.sun.max.program.ProgramError;
import java.lang.reflect.Method;

/**
 * @author Bernd Mathiske
 */
public final class Methods {

    private Methods() {
    }

    public static Method getDeclared(Class<?> clazz, String name, Class... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException noSuchMethodException) {
            ProgramError.unexpected("could not find required method: " + name, noSuchMethodException);
            return null;
        }
    }

}

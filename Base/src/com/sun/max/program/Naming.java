/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=72833628-82c3-4b92-ade0-6ba388c256ea*/
package com.sun.max.program;

import com.sun.max.lang.*;

/**
 * Utilities to deal with Maxwell naming conventions.
 *
 * @author Bernd Mathiske
 */
public final class Naming {
    
    private Naming() {        
    }
    
    public static String toTypeName(String name) {
        return Strings.firstCharToUpperCase(name.startsWith("_") ? name.substring(1) : name);
    }
    
    public static String toFieldName(String name) {
        if (!name.startsWith("_")) {
            return "_" + Strings.firstCharToLowerCase(name);
        }
        return name;
    }

    public static String toMethodName(String name) {
        return Strings.firstCharToLowerCase(name.startsWith("_") ? name.substring(1) : name);
    }
    
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6c26c74e-f44a-4a10-b201-ad3a6cd6f3b2*/
package com.sun.max.util;



/**
 * @author Bernd Mathiske
 */
public final class JavaIdentifier {

    // Utility classes should not be instantiated.
    private JavaIdentifier() {      
    }
    
    public static boolean isValid(String string) {
        if (!Character.isJavaIdentifierStart(string.charAt(0))) {
            return false;
        }
        for (int i = 1; i < string.length(); i++) {
            if (!Character.isJavaIdentifierPart(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isValidQualified(String string) {
        for (String identifier : string.split("\\.")) {
            if (!isValid(identifier)) {
                return false;
            }
        }
        return true;
    }
 
    public static String unqualifiedSuffix(String qualifiedIdentifier) {
        final int dotIndex = qualifiedIdentifier.lastIndexOf('.');
        if (dotIndex > 0) {
            return qualifiedIdentifier.substring(dotIndex + 1);
        }
        return qualifiedIdentifier;
    }
    
    public static String linkQualifiedIdentifier(char[]... identifiers) {
        String qualifiedIdentifier = "";
        if (identifiers != null) {
            String separator = "";
            for (int i = 0; i < identifiers.length; i++) {
                qualifiedIdentifier += separator;
                qualifiedIdentifier += new String(identifiers[i]);
                separator = ".";
            }
        }
        return qualifiedIdentifier;
    }

}

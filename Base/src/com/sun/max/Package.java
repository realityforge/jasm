/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=6992dfe6-4aa7-44f2-a5e5-dc5475b0c824*/
package com.sun.max;

/**
 * @see MaxPackage
 * 
 * @author Bernd Mathiske
 */
public class Package extends BasePackage {
    public Package() {
        super();
    }
    
    private static final String PACKAGE_NAME = new Package().name();
    
    /**
     * Determines if a given class is part of the Maxwell code base.
     */
    public static boolean contains(Class javaClass) {
        return javaClass.getName().startsWith(PACKAGE_NAME);
    }
}

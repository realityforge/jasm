/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=199ed3c5-f4f3-4485-9173-dc3634ec5085*/
package com.sun.max.ide.eclipse;

import java.io.*;

import org.eclipse.jdt.internal.compiler.env.*;

import com.sun.max.annotate.*;
import com.sun.max.ide.*;
import com.sun.max.lang.*;
import com.sun.max.util.*;

/**
 * @author Bernd Mathiske
 */
class EclipseJavaCompilationUnit implements ICompilationUnit {

    private final String _className;
    private final char[] _contents;

    EclipseJavaCompilationUnit(String className) throws IOException {
        _className = className;
        _contents = Strings.fromInputStream(JavaProject.findJavaSourceFile(_className)).toCharArray();
    }

    public String className() {
        return _className;
    }
    
    @Implement(IDependent.class)
    public char[] getFileName() {
        return _className.toCharArray();
    }

    @Implement(ICompilationUnit.class)
    public char[] getContents() {
        return _contents;
    }

    @Implement(ICompilationUnit.class)
    public char[] getMainTypeName() {
        return JavaIdentifier.unqualifiedSuffix(_className).toCharArray();
    }

    /**
     * @return the package name for the class defined by this compilation unit. For example, if this compilation unit defines
     *         java.lang.String, ["java".toCharArray(), "lang".toCharArray()] is returned.
     */
    @Implement(ICompilationUnit.class)
    public char[][] getPackageName() {
        final String[] fragments = _className.split("\\.");
        final char[][] result = new char[fragments.length - 1][];
        for (int i = 0; i < result.length; i++) {
            result[i] = fragments[i].toCharArray();
        }
        return result;
    }
}

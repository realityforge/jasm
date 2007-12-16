/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.ide;

import com.sun.max.MaxPackage;
import java.lang.reflect.InvocationTargetException;
import junit.framework.TestCase;

public class MaxTestCase extends TestCase {

    public MaxTestCase() {
        this(null);
        setName(getClass().getName());
    }

    public MaxTestCase(String name) {
        super(name);
    }

    private static TestProgramArgumentScheme _access;

    private static TestProgramArgumentScheme programArgumentAccess() {
        if (_access == null) {
            final MaxPackage p = MaxPackage.fromName(IDE.current().idePackageName());
            _access = p.loadAndInstantiateScheme(TestProgramArgumentScheme.class);
        }
        return _access;
    }

    public static String[] getProgramArguments() {
        return programArgumentAccess().getProgramArguments();
    }

    public Throwable getCause(InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause == null) {
            cause = invocationTargetException.getTargetException();
        }
        return cause;
    }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=301fea75-ad97-4567-8e71-c7963a2dfcdd*/
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

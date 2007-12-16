/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=301fea75-ad97-4567-8e71-c7963a2dfcdd*/
package com.sun.max.ide;

import java.io.*;
import java.lang.reflect.*;

import junit.framework.*;

import com.sun.max.*;
import com.sun.max.lang.*;
import com.sun.max.program.*;


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
    
    /**
     * Creates a JUnit test suite for a given package and populates it with all the classes
     * in that package that subclass {@link TestCase} if {@code addClasses == true}.
     */
    public static TestSuite createSuite(MaxPackage maxPackage, boolean addClasses) {
        final TestSuite suite = new TestSuite(maxPackage.name());
        if (addClasses) {
            addTests(maxPackage, suite);
        }
        return suite;
    }
    
    /**
     * Adds all the classes in {@code javaPackage} that subclass {@link TestCase} to {@code suite}.
     */
    public static void addTests(MaxPackage maxPackage, TestSuite suite) {
        try {
            final PackageLoader packageLoader = new PackageLoader(maxPackage.getClass().getClassLoader(), Classpath.fromSystem());
            for (Class javaClass : packageLoader.load(maxPackage)) {
                if (!Modifier.isAbstract(javaClass.getModifiers()) &&  TestCase.class.isAssignableFrom(javaClass)) {
                    final Class<Class<? extends TestCase>> type = null;
                    suite.addTestSuite(StaticLoophole.cast(type, javaClass));
                }
            }
        } catch (ClassNotFoundException e) {
            ProgramError.unexpected(e);
        } catch (IOException e) {
            ProgramError.unexpected(e);
        }
    }
}

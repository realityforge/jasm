/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=df8aa0bf-e10d-4040-bec6-9d0d09806ba3*/
package com.sun.max.ide.eclipse;

import java.io.*;

import com.sun.max.*;
import com.sun.max.annotate.*;
import com.sun.max.ide.*;

/**
 * @author Bernd Mathiske
 */
public class EclipseToolChainScheme extends AbstractScheme implements ToolChainScheme {

    @Implement(com.sun.max.ide.ToolChainScheme.class)
    public boolean compile(String className) throws IOException {
        final EclipseJavaCompiler compiler = new EclipseJavaCompiler(className);
        return compiler.run();        
    }

}

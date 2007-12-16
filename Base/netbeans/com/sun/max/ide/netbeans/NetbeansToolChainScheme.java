/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f908c80e-a106-42bf-8936-a6304c608191*/
package com.sun.max.ide.netbeans;

import java.io.*;
import com.sun.max.*;
import com.sun.max.annotate.*;
import com.sun.max.ide.*;
import com.sun.max.program.Classpath;

/**
 * @author Bernd Mathiske
 */
public class NetbeansToolChainScheme extends AbstractScheme implements ToolChainScheme {

    @Implement(ToolChain.class)
    public boolean compile(String className) throws IOException {
        final Classpath classPath = JavaProject.getClassPath(true);
        final Classpath sourcePath = JavaProject.getSourcePath(true);
        final String outputDirectory = classPath.paths().first();
        final String fileName = sourcePath + File.separator + className.replace('.', File.separatorChar) + JavaProject.SOURCE_FILE_EXTENSION;
        final int result = com.sun.tools.javac.Main.compile(new String[]{"-classpath", classPath.toString(), "-d", outputDirectory, "-sourcepath", sourcePath.toString(), fileName});
        return result == 0;
    }

}

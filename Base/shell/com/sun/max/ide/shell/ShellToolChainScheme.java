/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=41b049b6-b17e-4825-aabf-c84a6285eed7*/
package com.sun.max.ide.shell;

import java.io.*;

import com.sun.max.*;
import com.sun.max.annotate.*;
import com.sun.max.ide.*;
import com.sun.max.program.*;

/**
 * @author Bernd Mathiske
 */
public class ShellToolChainScheme extends AbstractScheme implements ToolChainScheme {

    @Implement(ToolChainScheme.class)
    public boolean compile(String className) throws IOException {
        final Classpath classPath = JavaProject.getClassPath(true);
        final Classpath sourcePath = JavaProject.getSourcePath(true);
        final String outputDirectory = classPath.paths().first();
        final String fileName = sourcePath + File.separator + className.replace('.', File.separatorChar) + JavaProject.SOURCE_FILE_EXTENSION;
        final int result = com.sun.tools.javac.Main.compile(new String[]{"-classpath", classPath.toString(), "-d", outputDirectory, "-sourcepath", sourcePath.toString(), fileName});
        return result == 0;
    }

}

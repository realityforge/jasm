/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use 
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License.
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package com.sun.max.ide;

import com.sun.max.MaxPackage;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.program.Classpath;
import com.sun.max.program.ProgramError;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Software project-dependent configuration. This is all derived from the
 * {@link Classpath#fromSystem() system class path} and assumption that
 * each project has the following directory structure:
 *
 * <project-dir>/src            # Source files
 * <project-dir>/test           # Test source files
 * <project-dir>/bin            # Eclipse output
 * <project-dir>/build/classes  # Netbeans output
 *
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public final class JavaProject {

    private JavaProject() {

    }

    public static final String SOURCE_FILE_EXTENSION = ".java";

    public static final String SOURCE_DIRECTORY_NAME = "src";

    public static final String TEST_SOURCE_DIRECTORY_NAME = "test";

    /**
     * Gets the paths on which all the class files produced by the current Java project can be found.
     *
     * @param includeDependencies  if true, the returned path includes the location of the
     *                             class files produced by each of the projects that the current
     *                             project depends upon
     */
    public static Classpath getClassPath(boolean includeDependencies) {
        final AppendableSequence<String> classDirectories = new ArrayListSequence<String>();
        for (String path : Classpath.fromSystem().paths()) {
            final File pathFile = new File(path);
            if (pathFile.isDirectory()) {
                final String packageName = MaxPackage.class.getPackage().getName();
                final File file = new File(path, packageName.replace('.', File.separatorChar));
                if (file.exists() && file.isDirectory() && !Sequence.Static.containsEqual(classDirectories, path)) {
                    classDirectories.append(path);
                    if (!includeDependencies) {
                        break;
                    }
                }
            }
        }
        ProgramError.check(!classDirectories.isEmpty(), "could not find path to Java project classes");
        return new Classpath(classDirectories);
    }

    /**
     * @return the first directory in the {@link Classpath#fromSystem system classpath} that contains
     *         a {@code com/sun/max} subdirectory
     */
    public static File findClassesDirectory() {
        return new File(getClassPath(false).paths().first());
    }

    /**
     * Gets the paths on which all the Java source files for the current Java project can be found.
     *
     * @param includeDependencies  if true, the returned path includes the location of the
     *                             Java source files for each of the projects that the current
     *                             project depends upon
     */
    public static Classpath getSourcePath(boolean includeDependencies) {
        final Classpath classPath = getClassPath(includeDependencies);
        final AppendableSequence<String> sourceDirectories = new ArrayListSequence<String>(classPath.paths().length());
        for (String path : classPath.paths()) {
            final File classesDirectory = new File(path);
            final File projectDirectory = IDE.current().findProjectDirectoryFromClasses(classesDirectory);

            if (projectDirectory != null) {
                final File srcDirectory = new File(projectDirectory, SOURCE_DIRECTORY_NAME);
                if (srcDirectory.exists() && srcDirectory.isDirectory()) {
                    sourceDirectories.append(srcDirectory.getPath());
                    if (!includeDependencies) {
                        break;
                    }
                }

                final File testDirectory = new File(projectDirectory, TEST_SOURCE_DIRECTORY_NAME);
                if (testDirectory.exists() && testDirectory.isDirectory()) {
                    sourceDirectories.append(testDirectory.getPath());
                }
            }
        }
        ProgramError.check(!sourceDirectories.isEmpty(), "could not find path to Java project sources");
        return new Classpath(sourceDirectories);
    }

    public static File findSourceDirectory() {
        return new File(getSourcePath(false).paths().first());
    }

    public static File findProjectDirectory() {
        final File path = findSourceDirectory().getParentFile();
        if (path == null) {
            ProgramError.unexpected("could not find Java project path");
        }
        return path;
    }

    public static InputStream findJavaSourceFile(String className) throws FileNotFoundException {
        return new FileInputStream(findSourceDirectory() + File.separator + className.replace('.', File.separatorChar) + SOURCE_FILE_EXTENSION);
    }
}

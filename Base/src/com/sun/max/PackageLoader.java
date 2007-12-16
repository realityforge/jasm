/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=1eead606-423f-4424-ba9b-6c022def0d08*/
package com.sun.max;

import com.sun.max.annotate.Implement;
import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.Strings;
import com.sun.max.program.Classpath;
import com.sun.max.program.ProgramError;
import com.sun.max.program.ProgramWarning;
import com.sun.max.program.Trace;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * Loads all the classes in a given package.
 *
 * @author Bernd Mathiske
 */
public class PackageLoader {

    private final Classpath _classpath;
    private final ClassLoader _classLoader;

    public PackageLoader(ClassLoader classLoader, Classpath classpath) {
        _classpath = classpath;
        _classLoader = classLoader;
    }

    private static final FilenameFilter CLASSFILE_FILTER = new FilenameFilter() {

        @Implement(FilenameFilter.class)
        public boolean accept(File directory, String name) {
            return name.endsWith(Classpath.CLASS_FILE_EXTENSION) && !name.equals("package-info.class");
        }
    };

    private boolean loadFromDirectory(String packageName, String path, Set<String> classNames, AppendableSequence<Class> classes) throws ClassNotFoundException {
        boolean foundAnyClass = false;
        final String subDirectory = packageName.replace('.', File.separatorChar);
        final File directory = new File(path + File.separator + subDirectory);
        final File[] files = directory.listFiles(CLASSFILE_FILTER);
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(Classpath.CLASS_FILE_EXTENSION)) {
                    final String suffix = Strings.chopSuffix(file.getName(), Classpath.CLASS_FILE_EXTENSION);
                    final String nameWithDots = packageName + "." + suffix;
                    if (nameWithDots.startsWith(packageName) && !classNames.contains(nameWithDots)) {
                        final Class javaClass = _classLoader.loadClass(nameWithDots);
                        if (javaClass != null) {
                            foundAnyClass = true;
                            classNames.add(nameWithDots);
                            classes.append(javaClass);
                        }
                    }
                }
            }
        }
        return foundAnyClass;
    }

    private boolean loadFromZipFile(String packageName, ZipFile zipFile, Set<String> classNames, AppendableSequence<Class> classes) throws ClassNotFoundException {
        boolean foundAnyClass = false;
        for (final Enumeration< ? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
            final ZipEntry zipEntry = e.nextElement();
            final String nameWithSlashes = zipEntry.getName();
            if (nameWithSlashes.endsWith(Classpath.CLASS_FILE_EXTENSION)) {
                final String nameWithDots = Strings.chopSuffix(nameWithSlashes, Classpath.CLASS_FILE_EXTENSION.length()).replace('/', '.');
                if (nameWithDots.startsWith(packageName) && nameWithDots.substring(0, nameWithDots.lastIndexOf('.')).equals(packageName)) {
                    if (!classNames.contains(nameWithDots)) {
                        final Class javaClass = _classLoader.loadClass(nameWithDots);
                        if (javaClass != null) {
                            foundAnyClass = true;
                            classNames.add(nameWithDots);
                            classes.append(javaClass);
                        }
                    }
                }
            }
        }
        return foundAnyClass;
    }

    public Sequence<Class> load(String packageName) throws ClassNotFoundException, IOException {
        Trace.line(1, "PackageLoader.load: " + packageName);
        final AppendableSequence<Class> classes = new ArrayListSequence<Class>();
        final Set<String> classNames = new HashSet<String>();
        boolean foundAnyClass = false;
        for (String path : _classpath.paths()) {
            final File file = new File(path);
            if (file.exists()) {
                if (file.isDirectory()) {
                    if (loadFromDirectory(packageName, path, classNames, classes)) {
                        foundAnyClass = true;
                    }
                } else if (path.endsWith(".jar") || path.endsWith(".zip")) {
                    try {
                        if (loadFromZipFile(packageName, new ZipFile(file), classNames, classes)) {
                            foundAnyClass = true;
                        }
                    } catch (ZipException zipException) {
                        // we interprete this simply as loading failed
                    }
                } else {
                    ProgramWarning.message("path is neither directory nor jar/zip file: " + path);
                }
            }
        }
        ProgramError.check(foundAnyClass, "no class found in package: " + packageName);
        return classes;
    }

    public Sequence<Class> load(MaxPackage maxPackage) throws ClassNotFoundException, IOException {
        return load(maxPackage.name());
    }
}

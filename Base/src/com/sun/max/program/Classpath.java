/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=2bb80cb5-a008-4a2a-8664-dbe2ae1d312f*/
package com.sun.max.program;

import com.sun.max.collect.ArraySequence;
import com.sun.max.collect.Sequence;
import com.sun.max.ide.JavaProject;
import com.sun.max.util.Predicate;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author Bernd Mathiske
 */
public class Classpath {

    public static final String CLASS_FILE_EXTENSION = ".class";

    private final Sequence<String> _paths;

    public Sequence<String> paths() {
        return _paths;
    }

    public Classpath(Sequence<String> paths) {
        _paths = paths;
    }

    public static Classpath fromSystem() {
        final String value = System.getProperty("sun.boot.class.path") + File.pathSeparator + System.getProperty("java.class.path");
        return new Classpath(new ArraySequence<String>(value.split(File.pathSeparator)));
    }

    public Classpath prepend(String path) {
        return new Classpath(Sequence.Static.prepended(path, _paths));
    }

    public Classpath filter(Predicate<String> predicate) {
        return new Classpath(Sequence.Static.filter(_paths, predicate));
    }

    public InputStream findClassFile(String className) {
        return findFile(className, CLASS_FILE_EXTENSION);
    }

    public InputStream findSourceFile(String className) {
        return findFile(className, JavaProject.SOURCE_FILE_EXTENSION);
    }

    public InputStream findFile(String className, String extension) {
        final String entryName = className.replace('.', '/') + extension;
        final String suffix = className.replace('.', File.separatorChar) + extension;
        for (String path : paths()) {
            final File pathFile = new File(path);
            if (pathFile.isDirectory()) {
                final File file = new File(path, suffix);
                if (file.exists()) {
                    try {
                        return new FileInputStream(file);
                    } catch (FileNotFoundException fileNotFoundException) {
                        return null;
                    }
                }
            } else if (path.endsWith(".jar") || path.endsWith(".zip")) {
                final File file = new File(path);
                if (file.exists()) {
                    try {
                        final ZipFile zipFile = new ZipFile(path);
                        final ZipEntry zipEntry = zipFile.getEntry(entryName);
                        if (zipEntry != null) {
                            final InputStream zipStream = zipFile.getInputStream(zipEntry);
                            final byte[] bytes = new byte[(int) zipEntry.getSize()];
                            int offset = 0;
                            while (offset < bytes.length) {
                                final int n = zipStream.read(bytes, offset, bytes.length - offset);
                                if (n <= 0) {
                                    //ProgramWarning.message("truncated zip file: " + zipFile);
                                }
                                offset += n;
                            }
                            zipStream.close();
                            return new ByteArrayInputStream(bytes);
                        }
                    } catch (IOException ioException) {
                        //ProgramWarning.message("could not read zip file: " + file);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Sequence.Static.toString(_paths, null, File.pathSeparator);
    }
}

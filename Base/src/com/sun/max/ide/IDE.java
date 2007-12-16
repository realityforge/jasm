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
import java.io.File;

/**
 * @author Bernd Mathiske
 * @author Greg Wright
 */
public enum IDE {

    NETBEANS {
        @Override
        public File findProjectDirectoryFromClasses(File classesDirectory) {
            if (classesDirectory.getName().equals("classes")) {
                final File buildDirectory = classesDirectory.getParentFile();
                if (buildDirectory.getName().equals("build")) {
                    return buildDirectory.getParentFile();
                }
            }
            return null;
        }
    },
    ECLIPSE {
        @Override
        public File findProjectDirectoryFromClasses(File classesDirectory) {
            if (classesDirectory.getName().equals("bin")) {
                return classesDirectory.getParentFile();
            }
            return null;
        }
    },
    SHELL {
        @Override
        public File findProjectDirectoryFromClasses(File classesDirectory) {
            if (classesDirectory.getName().equals("bin")) {
                return classesDirectory.getParentFile();
            }
            return null;
        }
    };

    private IDE() {
    }

    public String idePackageName() {
        final MaxPackage thisPackage = MaxPackage.fromClass(IDE.class);
        return thisPackage.name() + "." + name().toLowerCase();
    }

    public abstract File findProjectDirectoryFromClasses(File classesDirectory);

    private boolean isInUse() {
        return MaxPackage.fromName(idePackageName()) != null;
    }

    public static IDE current() {
        for (IDE ide : IDE.values()) {
            if (ide.isInUse()) {
                return ide;
            }
        }
        return null;
    }
}

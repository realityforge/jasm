/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=2a35e90c-b5fc-4d7f-8c76-6a9054c13a92*/
package com.sun.max.io;

import com.sun.max.annotate.Implement;
import com.sun.max.program.ProgramWarning;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public final class TemporaryFiles {
    private TemporaryFiles() {
    }

    public static void cleanup(final String prefix, final String suffix) {
        if ((prefix == null || prefix.length() == 0) && (suffix == null || suffix.length() == 0)) {
            return;
        }
        try {
            final File tempFile = File.createTempFile(prefix, suffix);
            final File directory = tempFile.getParentFile();
            final FilenameFilter filter = new FilenameFilter() {
                @Implement(FilenameFilter.class)
                public boolean accept(File dir, String name) {
                    if (prefix != null && prefix.length() > 0 && !name.startsWith(prefix)) {
                        return false;
                    }
                    if (suffix != null && suffix.length() > 0 && !name.endsWith(suffix)) {
                        return false;
                    }
                    return true;
                }
            };
            for (File file : directory.listFiles(filter)) {
                if (!file.delete()) {
                    ProgramWarning.message("could not delete temporary file: " + file.getAbsolutePath());
                }
            }
        } catch (IOException ioException) {
            ProgramWarning.message("could not delete temporary files");
        }
    }

    public static void cleanup(String prefix) {
        cleanup(prefix, null);
    }
}

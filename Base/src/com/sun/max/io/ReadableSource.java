/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * A readable source is a character data source that provides a Reader to read the data.
 *
 * @author Doug Simon
 */
public interface ReadableSource {

    /**
     * @param buffered if true, the returned reader is guaranteed to be a BufferedReader
     *
     * @return a reader to read the character data represented by this source
     */
    Reader reader(boolean buffered) throws IOException;

    public static final class Static {

        private Static() {

        }

        /**
         * Creates a ReadableSource to provides readers for the characters in a string.
         */
        public static ReadableSource fromString(final String s) {
            return new ReadableSource() {
                public Reader reader(boolean buffered) throws IOException {
                    return buffered ? new BufferedReader(new StringReader(s)) : new StringReader(s);
                }
            };
        }

        /**
         * Creates a ReadableSource to provides readers for the characters in a file.
         */
        public static ReadableSource fromFile(final File file) {
            return new ReadableSource() {
                public Reader reader(boolean buffered) throws IOException {
                    return buffered ? new BufferedReader(new FileReader(file)) : new FileReader(file);
                }
            };

        }
    }
}

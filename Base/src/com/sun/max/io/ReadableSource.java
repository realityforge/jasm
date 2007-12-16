/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=5070ed91-5e42-46c1-a73e-35a3d5f05f01*/
package com.sun.max.io;

import java.io.*;

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

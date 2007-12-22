/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.io;

import java.io.Reader;

/**
 * A readable source is a character data source that provides a Reader to read the data.
 *
 * @author Doug Simon
 */
public interface ReadableSource {

    /**
     * @return a reader to read the character data represented by this source
     */
    Reader reader();
}

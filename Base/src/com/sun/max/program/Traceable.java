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
package com.sun.max.program;

import java.io.PrintStream;

/**
 * @author Bernd Mathiske
 */
public interface Traceable {

    void printTrace(PrintStream stream, Object... arguments);

}

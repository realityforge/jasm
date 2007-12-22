/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.x86;

import jasm.EnumerableArgument;
import jasm.WordWidth;

/**
 * @author Bernd Mathiske
 */
public interface GeneralRegister
    extends EnumerableArgument {

    WordWidth width();

    int INVALID_ID = Integer.MIN_VALUE;

    int id();

}

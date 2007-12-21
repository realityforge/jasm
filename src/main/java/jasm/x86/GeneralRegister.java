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
import jasm.util.WordWidth;

/**
 * @author Bernd Mathiske
 */
public interface GeneralRegister<GeneralRegister_Type extends Enum<GeneralRegister_Type> & GeneralRegister<GeneralRegister_Type>>
    extends EnumerableArgument<GeneralRegister_Type> {

    WordWidth width();

    int INVALID_ID = Integer.MIN_VALUE;

    int id();

}

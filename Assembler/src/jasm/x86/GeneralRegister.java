/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
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

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm;

import jasm.util.Enumerable;

/**
 *
 *
 * @author Bernd Mathiske
 */
public interface EnumerableArgument<Argument_Type extends Enum<Argument_Type> & EnumerableArgument<Argument_Type>> extends
                                                                                                                   Enumerable<Argument_Type>, SymbolicArgument {

}

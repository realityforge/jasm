/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package jasm.util;

/**
 * A symbol is an immutable binding of a name to a value.
 *
 * @author Bernd Mathiske
 *
 * @see Symbolizer
 */
public interface Symbol {

    /**
     * @return the name of the symbol
     */
    String name();

    /**
     * @return the value of the symbol
     */
    int value();

}

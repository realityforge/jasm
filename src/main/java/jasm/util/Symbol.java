/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
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
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
package com.sun.max.program.option;

/**
 * Program options that take a positive integer number argument. Example: -trace=15
 *
 * @author Bernd Mathiske
 */
public class PositiveIntegerProgramOption extends IntegerProgramOption {

    public PositiveIntegerProgramOption(String prefix, String description) {
        super(prefix, description);
    }

    @Override
    protected Integer scanValue(String string) {
        try {
            final int result = Integer.parseInt(string);
            if (result < 0) {
                return null;
            }
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }

}

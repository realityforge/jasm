/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
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

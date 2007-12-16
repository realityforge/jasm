/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package com.sun.max.program.option;


/**
 * An assignment option that expects an integer value.
 *
 * @author Bernd Mathiske
 */
public class IntegerProgramOption extends AssignmentProgramOption<Integer> {

    private final Object _arg;

    /**
     * Creates a program option that accepts an integer argument.
     *
     * @param prefix
     *            the prefix that uniquely identifies the option
     * @param description
     *            the message describing the option's meaning. This string will be
     *            {@link String#format(String, Object[]) formatted} along with {@code args} to create the final
     *            description
     * @param args
     *            the optional args for the description. The first arg will also be used as the part after the
     *            '=' in the usage message. If {@code args.length == 0}, then {@code "<n>"} will be used.
     */
    public IntegerProgramOption(String prefix, String description, Object... args) {
        super(prefix, String.format(description, args));
        if (args.length == 0) {
            _arg = "<n>";
        } else {
            _arg = args[0];
        }
    }

    @Override
    public String usage() {
        return prefix() + "=" + _arg;
    }

    @Override
    protected Integer scanValue(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=c0662793-9bd2-453e-af82-e63ca21b75d6*/
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

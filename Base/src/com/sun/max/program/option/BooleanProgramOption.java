/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
package com.sun.max.program.option;

/**
 * A command line option whose presence on a command line indicates {@code true} and whose absence indicates
 * {@code false}.
 *
 * @author Bernd Mathiske
 */
public class BooleanProgramOption extends ValueProgramOption<Boolean> {

    @Override
    public String usage() {
        return prefix();
    }

    public BooleanProgramOption(String prefix, String description) {
        super(prefix, description);
        setValue(false);
    }

    @Override
    protected void parse(ProgramArgumentsParser parser) {
        setValue(true);
    }

    @Override
    public String asCommandLineArgument() {
        if (value()) {
            return prefix();
        }
        return null;
    }


}

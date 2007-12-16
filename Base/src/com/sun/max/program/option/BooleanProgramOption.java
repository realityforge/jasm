/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=67d33df2-4111-4008-b5a6-1f2594701292*/
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

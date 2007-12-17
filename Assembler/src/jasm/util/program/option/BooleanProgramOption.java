/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.program.option;

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

}

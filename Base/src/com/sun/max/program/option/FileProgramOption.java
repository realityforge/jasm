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

import java.io.File;

/**
 * An assignment option that expects a file or directory path.
 *
 * @author Doug Simon
 */
public class FileProgramOption extends AssignmentProgramOption<File> {

    private final Object _arg;

    /**
     * Creates a program option that accepts a file or directory path argument argument.
     *
     * @param prefix
     *            the prefix that uniquely identifies the option
     * @param description
     *            the message describing the option's meaning. This string will be
     *            {@link String#format(String, Object[]) formatted} along with {@code args} to create the final
     *            description
     * @param args
     *            the optional args for the description. The first arg will also be used as the part after the
     *            '=' in the usage message. If {@code args.length == 0}, then {@code "<arg>"} will be used.
     */
    public FileProgramOption(String prefix, String description, Object... args) {
        super(prefix, String.format(description, args));
        if (args.length == 0) {
            _arg = "<arg>";
        } else {
            _arg = args[0];
        }
    }

    @Override
    public String usage() {
        return prefix() + "=" + _arg;
    }

    @Override
    protected File scanValue(String string) {
        return new File(string);
    }

    @Override
    public FileProgramOption beMandatory() {
        return (FileProgramOption) super.beMandatory();
    }
}

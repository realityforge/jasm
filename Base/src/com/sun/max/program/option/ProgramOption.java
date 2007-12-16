/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=041bf595-f71d-4939-a3b1-861d9c30e7cb*/
package com.sun.max.program.option;

import java.util.HashSet;
import java.util.Set;

/**
 * A command line option.
 *
 * @author Bernd Mathiske
 */
public abstract class ProgramOption implements Comparable<ProgramOption> {

    private final String _prefix;
    private final String _description;

    /**
     * Creates a program option from a prefix and description.
     *
     * @param prefix       the prefix (which must start with '-') that uniquely identifies the option
     * @param description  the message describing the option's meaning
     */
    public ProgramOption(String prefix, String description) {
        assert prefix.charAt(0) == '-';
        _prefix = prefix;
        _description = description;
    }

    public String prefix() {
        return _prefix;
    }

    public abstract String usage();

    public String description() {
        return _description;
    }

    public String usageDetail() {
        return _description;
    }

    @Override
    public String toString() {
        return prefix();
    }

    /**
     * Gets the command line argument that reflects the current state of this option. Note that
     * for certain types of options such as {@link BooleanProgramOption}s, the value returned by
     * this method may be null which indicates the state of this option reflects an absence of
     * a command line argument.
     */
    public abstract String asCommandLineArgument();

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof ProgramOption)) {
            return false;
        }
        final ProgramOption programOption = (ProgramOption) other;
        return _prefix.equals(programOption._prefix);
    }

    @Override
    public int hashCode() {
        return _prefix.hashCode();
    }

    public int compareTo(ProgramOption other) {
        return _prefix.compareTo(other._prefix);
    }

    public boolean matches(String argument) {
        return prefix().equals(argument) || (argument.startsWith(prefix()) && argument.charAt(prefix().length()) == '=');
    }

    protected String nextArgument(ProgramArgumentsParser parser) {
        return parser.nextArgument();
    }

    private int _parseCount;

    public int parseCount() {
        return _parseCount;
    }

    protected abstract void parse(ProgramArgumentsParser parser);

    void countAndParse(ProgramArgumentsParser parser) {
        _parseCount++;
        parse(parser);
    }

    private boolean _isMandatory;

    public boolean isMandatory() {
        return _isMandatory;
    }

    public ProgramOption beMandatory() {
        _isMandatory = true;
        return this;
    }

    private Set<ProgramOption> _excludedProgramOptions = new HashSet<ProgramOption>();

    public Set<ProgramOption> excludedProgramOptions() {
        return _excludedProgramOptions;
    }

    public void excludeMutually(ProgramOption other) {
        _excludedProgramOptions.add(other);
        other._excludedProgramOptions.add(this);
    }
}

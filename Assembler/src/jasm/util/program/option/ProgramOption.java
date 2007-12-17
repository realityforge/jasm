/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.program.option;

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

  @Override
    public String toString() {
        return prefix();
    }

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

  private Set<ProgramOption> _excludedProgramOptions = new HashSet<ProgramOption>();

    public Set<ProgramOption> excludedProgramOptions() {
        return _excludedProgramOptions;
    }

}

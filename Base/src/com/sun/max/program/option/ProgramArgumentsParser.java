/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=3771fdf6-4c77-4ac0-a8b6-543d87193b68*/
package com.sun.max.program.option;

import com.sun.max.collect.AppendableSequence;
import com.sun.max.collect.ArrayListSequence;
import com.sun.max.collect.Sequence;
import com.sun.max.lang.Arrays;
import com.sun.max.lang.Strings;
import com.sun.max.program.ProgramError;

/**
 * A facility for parsing program options. The options may be supplied on the command line
 * but it's not a requirement.
 *
 * @author Bernd Mathiske
 * @author Doug Simon
 */
public class ProgramArgumentsParser {

    private String _programName;

    public ProgramArgumentsParser(String programName) {
        _programName = programName;
    }

    private AppendableSequence<ProgramOption> _programOptions = new ArrayListSequence<ProgramOption>();

    public synchronized Sequence<ProgramOption> programOptions() {
        return _programOptions;
    }

    public String programName() {
        return _programName;
    }

    public void usage(String message) {
        if (message != null) {
            System.err.println();
            System.err.println(message);
            System.err.println();
        }
        System.err.println("usage: " + _programName + " [-options] ");
        System.err.println("where options include:");
        for (ProgramOption programOption : _programOptions) {
            System.err.println("    " + Strings.padLengthWithSpaces(programOption.usage(), 25) + " " + programOption.description());
        }
        throw new ProgramError(message);
    }

    public synchronized void addProgramOption(ProgramOption programOption) {
        assert programOption != null;
        _programOptions.append(programOption);
    }

    public synchronized void addProgramOptions(ProgramOption... programOptions) {
        AppendableSequence.Static.appendAll(_programOptions, programOptions);
    }

    private ProgramOption matchProgramOption(String argument) {
        for (ProgramOption programOption : _programOptions) {
            if (programOption.matches(argument)) {
                return programOption;
            }
        }
        return null;
    }

    private String[] _arguments;
    private int _index;
    private String _mainClassName;
    private String[] _mainClassArguments;

    /**
     * Gets the name of the first non-option string in the arguments {@linkplain #parse(String[]) parsed}
     * by this parser. An option string is one that starts with {@code '-'}.
     */
    public synchronized String getMainClassName() {
        if (_arguments == null) {
            throw new IllegalStateException("arguments have not yet been parsed");
        }
        return _mainClassName;
    }

    /**
     * Gets all the arguments succeeding the {@linkplain #getMainClassName() main class name argument}.
     */
    public synchronized String[] getMainClassArguments() {
        if (_arguments == null) {
            throw new IllegalStateException("arguments have not yet been parsed");
        }
        return _mainClassArguments.clone();
    }

    String nextArgument() {
        final String result = _arguments[_index++];
        return result;
    }

    private void updateOptions() {
        for (ProgramOption programOption : _programOptions) {
            if (programOption.isMandatory() && programOption.parseCount() == 0) {
                usage("missing program option: " + programOption);
            }
            if (programOption instanceof AssignmentProgramOption) {
                final AssignmentProgramOption assignment = (AssignmentProgramOption) programOption;
                assignment.update();
            }
            if (!programOption.excludedProgramOptions().isEmpty() && programOption.parseCount() > 0) {
                for (ProgramOption other : programOption.excludedProgramOptions()) {
                    if (other.parseCount() > 0) {
                        usage("program option '" + programOption + "' excludes '" + other + "'");
                    }
                }
            }
        }
    }

    /**
     * Parses a given set of arguments. This should only be called once the parser has been configured by
     * {@linkplain #addProgramOption(ProgramOption) adding} a number of program options.
     *
     * @param arguments
     *            the arguments to parse
     * @param defaultMainClassName
     *            the name of the main class (may be null)
     * @param unmatchedArguments
     *            a sequence to which arguments unrecognised by this parser will be appended. If this is null,
     *            then unrecognised arguments encountered during parsing will cause a {@linkplain #usage(String) usage}
     *            message to be displayed.
     */
    public synchronized void parse(String[] arguments, String defaultMainClassName, AppendableSequence<String> unmatchedArguments) {
        if (_arguments != null) {
            throw new IllegalStateException("argument parser cannot be re-used");
        }
        assert _arguments == null;

        if (_arguments == null) {
            _arguments = arguments.clone();
        }

        _index = 0;
        while (_index < _arguments.length) {
            if (_arguments[_index].startsWith("-")) {
                final int previousIndex = _index;
                final String argument = _arguments[_index];
                final ProgramOption programOption = matchProgramOption(argument);
                if (programOption != null) {
                    programOption.countAndParse(this);
                    if (_index <= previousIndex) {
                        // Defensive programming here: Consume the option argument.
                        // Recover from potentially uncooperative option that did not increase the '_index' by callback
                        _index = previousIndex + 1;
                    }
                } else {
                    if (unmatchedArguments == null) {
                        usage("unknown program option: " + argument);
                    } else {
                        unmatchedArguments.append(argument);
                    }
                    ++_index;
                }
            } else {
                _mainClassName = _arguments[_index++];
                _mainClassArguments = Arrays.subArray(_arguments, _index);
                break;
            }
        }
        if (_mainClassName == null) {
            _mainClassName = defaultMainClassName;
        }
        updateOptions();
    }

    /**
     * @see #parse(String[], String, AppendableSequence)
     */
    public synchronized void parse(String[] arguments, String defaultMainClassName) {
        parse(arguments, defaultMainClassName, null);
    }

    /**
     * @see #parse(String[], String, AppendableSequence)
     */
    public void parse(String[] arguments) {
        parse(arguments, null);
    }
}

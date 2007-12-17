/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.util.program.option;

import jasm.util.collect.AppendableSequence;
import jasm.util.collect.ArrayListSequence;
import jasm.util.lang.Strings;
import jasm.util.program.ProgramError;

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

  public void usage(String message) {
    if (message != null) {
      System.err.println();
      System.err.println(message);
      System.err.println();
    }
    System.err.println("usage: " + _programName + " [-options] ");
    System.err.println("where options include:");
    for (ProgramOption programOption : _programOptions) {
      System.err.println("    " +
                         Strings.padLengthWithSpaces(programOption.usage(), 25) +
                         " " +
                         programOption.description());
    }
    throw new ProgramError(message);
  }

  public synchronized void addProgramOption(ProgramOption programOption) {
    assert programOption != null;
    _programOptions.append(programOption);
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

  String nextArgument() {
    return _arguments[_index++];
  }

  private void updateOptions() {
    for (ProgramOption programOption : _programOptions) {
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
   */
  public synchronized void parse(String[] arguments, String defaultMainClassName) {
    if (_arguments != null) {
      throw new IllegalStateException("argument parser cannot be re-used");
    }
    _arguments = arguments.clone();

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
          usage("unknown program option: " + argument);
          ++_index;
        }
      } else {
        _mainClassName = _arguments[_index++];
        break;
      }
    }
    if (_mainClassName == null) {
      _mainClassName = defaultMainClassName;
    }
    updateOptions();
  }

  public void parse(String[] arguments) {
    parse(arguments, null);
  }
}
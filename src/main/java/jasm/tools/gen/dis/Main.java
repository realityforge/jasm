/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.gen.dis;

import jasm.tools.Trace;
import java.io.File;
import java.util.List;
import org.realityforge.cli.ArgsParser;
import org.realityforge.cli.CLUtil;
import org.realityforge.cli.Option;
import org.realityforge.cli.OptionDescriptor;

public final class Main {
  private static final int HELP_OPT = 'h';
  private static final int DIR_OPT = 'd';
  private static final int VERBOSE_OPT = 1;
  private static final int ISA_OPT = 2;

  private static final OptionDescriptor[] OPTIONS = {
      new OptionDescriptor("help",
                           OptionDescriptor.ARGUMENT_DISALLOWED,
                           HELP_OPT,
                           "print this message and exit"),
      new OptionDescriptor("dir",
                           OptionDescriptor.ARGUMENT_REQUIRED,
                           DIR_OPT,
                           "the base directory to place generated assembler in."),
      new OptionDescriptor("verbose",
                           OptionDescriptor.ARGUMENT_DISALLOWED,
                           VERBOSE_OPT,
                           "show verbose messages during generation"),
      new OptionDescriptor("isa",
                           OptionDescriptor.ARGUMENT_REQUIRED,
                           ISA_OPT,
                           "the instruction set architecture to generate assembler for. amd64, ia32, ppc, sparc"),
  };

  private static File _sourceDirectory;
  private static int _verbosity;
  private static ISADef _isa;

  private static boolean processArgs(final String[] args) {
    final ArgsParser parser = new ArgsParser(args, OPTIONS);
    if (null != parser.getErrorString()) {
      System.err.println("Error: " + parser.getErrorString());
      return false;
    }

    // Get a list of parsed options
    final List options = parser.getArguments();
    final int size = options.size();

    for (int i = 0; i < size; i++) {
      final Option option = (Option) options.get(i);

      switch (option.getId()) {
        case Option.TEXT_ARGUMENT:
          System.out.println("Unknown arg: " + option.getArgument());
          return false;

        case HELP_OPT:
          printUsage();
          return false;

        case ISA_OPT:
          _isa = ISADef.valueOf(option.getArgument());
          if (null == _isa) {
            System.out.println("Unknown ISA: " + option.getArgument());
            System.out.println("Available ISAs:");
            for (ISADef isa : ISADef.values()) {
              System.out.println("\t" + isa.name());
            }
          }
          break;

        case VERBOSE_OPT:
          _verbosity = 3;
          break;

        case DIR_OPT:
          _sourceDirectory = new File(option.getArgument());
          break;
      }
    }

    if (null == _isa) {
      System.out.println("No isa specified.");
      return false;
    }

    return true;
  }

  private static void printUsage() {
    final String lineSeparator = System.getProperty("line.separator");

    final StringBuffer msg = new StringBuffer();

    msg.append(lineSeparator);
    msg.append("Disassembler Generator");
    msg.append(lineSeparator);
    msg.append("Usage: java ");
    msg.append(jasm.tools.gen.as.Main.class.getName());
    msg.append(" [options]");
    msg.append(lineSeparator);
    msg.append(lineSeparator);
    msg.append("Options: ");
    msg.append(lineSeparator);

    msg.append(CLUtil.describeOptions(OPTIONS));

    System.out.println(msg.toString());
  }

  public static void main(String[] args) {
    if (!processArgs(args)) {
      System.exit(0);
    }
    try {
      Trace.on(_verbosity);
      final DisassemblerGenerator<?> generator = newGenerator();
      if (null != _sourceDirectory) generator.setSourceDirectory(_sourceDirectory);
      generator.generate();
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(42);
    }
    System.exit(0);
  }

  private static DisassemblerGenerator<?> newGenerator() throws Exception {
    final String classname = _isa.getGeneratorClassname();
    return (DisassemblerGenerator<?>) Class.forName(classname).newInstance();
  }
}
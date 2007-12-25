/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package jasm.tools.test.performance;

import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;
import org.realityforge.cli.ArgsParser;
import org.realityforge.cli.CLUtil;
import org.realityforge.cli.Option;
import org.realityforge.cli.OptionDescriptor;

public final class Main {
  private static final String NAME = "Performance Tester";
  // Define our short one-letter option identifiers.
  private static final int HELP_OPT = 'h';
  private static final int ASSEMBLER_OPT = 'a';
  private static final int WARMUP_TIME_OPT = 1;
  private static final int TEST_COUNT_OPT = 2;
  private static final int ITERATIONS_OPT = 4;
  private static final int TEST_DISASSEMBLER_OPT = 5;

  private static final OptionDescriptor[] OPTIONS = new OptionDescriptor[]{
      new OptionDescriptor("help",
                           OptionDescriptor.ARGUMENT_DISALLOWED,
                           HELP_OPT,
                           "print this message and exit"),
      new OptionDescriptor("assembler",
                           OptionDescriptor.ARGUMENT_REQUIRED,
                           ASSEMBLER_OPT,
                           "the name of assembler to test. amd64, ia32, ppc32, ppc64, sparc32 or sparc64"),
      new OptionDescriptor("warmup-time",
                           OptionDescriptor.ARGUMENT_REQUIRED,
                           WARMUP_TIME_OPT,
                           "the time to spend during warmup phase (in secs)"),
      new OptionDescriptor("test-count",
                           OptionDescriptor.ARGUMENT_REQUIRED,
                           TEST_COUNT_OPT,
                           "the number of times to perform test per iteration"),
      new OptionDescriptor("iterations",
                           OptionDescriptor.ARGUMENT_REQUIRED,
                           ITERATIONS_OPT,
                           "the number of times to run tests"),
      new OptionDescriptor("test-disassembler",
                           OptionDescriptor.ARGUMENT_DISALLOWED,
                           TEST_DISASSEMBLER_OPT,
                           "test the disassembler rather than the assembler"),
  };

  //config parameters
  private static AssemblerDef c_assemblerDef;
  private static int c_warmupTime = 3000;
  private static int c_iterations = 4;
  private static int c_testCount = 100000;
  private static boolean c_testDisassembler;

  //Global statistics
  private static long[] c_times;
  private static CompilationMXBean c_compilationMXBean;
  private static GarbageCollectorMXBean c_majorCollector;
  private static GarbageCollectorMXBean c_minorCollector;

  public static boolean processOptions(final String[] args) {
    // Parse the arguments
    final ArgsParser parser = new ArgsParser(args, OPTIONS);

    //Make sure that there was no errors parsing
    //arguments
    if (null != parser.getErrorString()) {
      System.err.println("Error: " + parser.getErrorString());
      return false;
    }

    // Get a list of parsed options
    final List<Option> options = parser.getArguments();
    for (final Option option : options) {
      switch (option.getId()) {
        case Option.TEXT_ARGUMENT:
          System.out.println(NAME + ": Unknown arg: " + option.getArgument());
          return false;

        case ASSEMBLER_OPT:
          c_assemblerDef = AssemblerDef.valueOf(option.getArgument().toUpperCase());
          if (null == c_assemblerDef) {
            System.out.println("Unknown assembler: " + option.getArgument());
          }
          break;
        case WARMUP_TIME_OPT:
          c_warmupTime = Integer.parseInt(option.getArgument()) * 1000;
          break;
        case TEST_COUNT_OPT:
          c_testCount = Integer.parseInt(option.getArgument());
          break;
        case ITERATIONS_OPT:
          c_iterations = Integer.parseInt(option.getArgument());
          break;
        case TEST_DISASSEMBLER_OPT:
          c_testDisassembler = true;
          break;
        case HELP_OPT:
          printUsage();
          return false;
      }
    }

    if (null == c_assemblerDef) {
      System.out.println("No assembler specified.");
      return false;
    }

    System.out.println(NAME);
    System.out.println("------------------");
    System.out.println();
    System.out.println("Parameters:");
    System.out.println("\tIterations: " + c_iterations);
    System.out.println("\tWarmup Time (ms): " + c_warmupTime);
    System.out.println("\tTest Count: " + c_testCount);
    System.out.println("\tTest Target: " + (c_testDisassembler ? "Disassembler" : "Assembler"));
    System.out.println("\tAssembler: " + c_assemblerDef.name().toLowerCase());

    return true;
  }

  /**
   * Print out a usage statement
   */
  private static void printUsage() {
    final String lineSeparator = System.getProperty("line.separator");

    final StringBuffer msg = new StringBuffer();

    msg.append(NAME + " Options: ");
    msg.append(lineSeparator);

    msg.append(CLUtil.describeOptions(OPTIONS).toString());

    System.out.println(msg.toString());
  }

  public static void main(final String[] args)
      throws Exception {
    if (!processOptions(args)) {
      System.exit(1);
    }

    c_times = new long[c_iterations];

    try {
      final List<GarbageCollectorMXBean> mxBeans = ManagementFactory.getGarbageCollectorMXBeans();
      c_minorCollector = mxBeans.get(0);
      c_majorCollector = mxBeans.get(1);
      c_compilationMXBean = ManagementFactory.getCompilationMXBean();

      final PerformanceTester tester = newPerformanceTester();
      System.out.println("Starting Warmup");
      final long endTime = System.currentTimeMillis() + c_warmupTime;
      while (System.currentTimeMillis() < endTime) {
        iteration(tester, -1);
      }

      System.out.println("Completed Warmup. Starting Test");
      for (int i = 0; i < c_iterations; i++) {
        iteration(tester, i + 1);
      }

      Arrays.sort(c_times);

      double avgTime = 0;
      for (long time : c_times) {
        avgTime += time;
      }
      avgTime /= c_times.length;

      System.out.println("Results:");
      showTime(tester, "Best", c_times[0]);
      showTime(tester, "Average", avgTime);

      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(42);
    }
  }

  private static void showTime(final PerformanceTester tester,
                               final String name,
                               final double time) {
    final int instructionCount = tester.getInstructionCount();
    final int codeSize = tester.getMachineCodeSize();
    final double instRate = time / (instructionCount * c_testCount);
    final double byteRate = time / (codeSize * c_testCount);

    System.out.println("\t" + name + " Time: " + time +
                       " NS per Instructions : " + instRate +
                       " NS per Bytes: " + byteRate);
  }

  private static void iteration(final PerformanceTester tester, final int iteration)
      throws Exception {
    System.gc();
    Thread.sleep(20);
    final long startCompilationTime = c_compilationMXBean.getTotalCompilationTime();
    final long initialCollectionCount = c_majorCollector.getCollectionCount();
    final long initialMinorCC = c_minorCollector.getCollectionCount();
    if (-1 != iteration) System.out.println("Starting iteration " + iteration);

    final long time;
    if (c_testDisassembler) {
      time = tester.runDisassembleTest(c_testCount);
    } else {
      time = tester.runAssembleTest(c_testCount);
    }
    if (-1 != iteration) c_times[iteration - 1] = time;

    final long endMinorCC = c_minorCollector.getCollectionCount();
    final long endCompilationTime = c_compilationMXBean.getTotalCompilationTime();
    final long endCollectionCount = c_majorCollector.getCollectionCount();

    final long compilationTime = endCompilationTime - startCompilationTime;
    final long collectionCount = endCollectionCount - initialCollectionCount;
    final long minorCollectionCount = endMinorCC - initialMinorCC;

    if (-1 != iteration) {
      final String message =
          "Iteration " + iteration +
          " Time = " + c_times[iteration - 1] +
          " Major Collections = " + collectionCount +
          " Minor Collections = " + minorCollectionCount +
          " Compile Time = " + compilationTime;
      System.out.println(message);
    }
  }

  private static PerformanceTester newPerformanceTester()
      throws Exception {
    final String classname = c_assemblerDef.getTesterClassname();
    return (PerformanceTester) Class.forName(classname).newInstance();
  }
}
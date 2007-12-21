/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See3 the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm;

import jasm.gen.test.AssemblyTester;
import jasm.util.program.Trace;
import jasm.util.program.option.BooleanProgramOption;
import jasm.util.program.option.IntegerProgramOption;
import jasm.util.program.option.ProgramArgumentsParser;
import jasm.util.program.option.StringProgramOption;
import junit.framework.TestCase;

/**
 * Base class for assembler tests that defines program options common to
 * all assembler test harnesses.
 *
 * @author Doug Simon
 * @author Bernd Mathiske
 */
public abstract class AssemblerTestCase extends TestCase {

  private StringProgramOption _templatePattern =
      new StringProgramOption("-pattern", "test only templates with the substring in their name", "<substring>");
  private IntegerProgramOption _startTemplateSerial =
      new IntegerProgramOption("-start", "serial number of first template to be tested") {
        protected Integer unassignedDefaultValue() {
          return new Integer(0);
        }
      };
  private IntegerProgramOption _endTemplateSerial =
      new IntegerProgramOption("-end", "serial number of last template to be tested") {
        protected Integer unassignedDefaultValue() {
          return Integer.MAX_VALUE;
        }
      };
  private BooleanProgramOption _onlyCreateExternalSource =
      new BooleanProgramOption("-only-make-asm-source",
                               "creates assembler source file with tests for each template (no tests are run)");

  protected AssemblerTestCase() {
    this(new String[0]);
  }

  public AssemblerTestCase(final String[] args) {
    final ProgramArgumentsParser programArgumentsParser = new ProgramArgumentsParser(getClass().getSimpleName());
    programArgumentsParser.addProgramOption(new Trace());
    programArgumentsParser.addProgramOption(_templatePattern);
    programArgumentsParser.addProgramOption(_startTemplateSerial);
    programArgumentsParser.addProgramOption(_endTemplateSerial);
    programArgumentsParser.addProgramOption(_onlyCreateExternalSource);
    programArgumentsParser.parse(args);
  }

  public void run(AssemblyTester tester) {
    tester.setTemplatePattern(_templatePattern.value());
    tester.run(_startTemplateSerial.value().intValue(),
               _endTemplateSerial.value().intValue(),
               _onlyCreateExternalSource.value());
  }
}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=69e97991-b7cc-47a8-aa16-4b50f931c587*/
package test.com.sun.max.asm;

import com.sun.max.asm.gen.*;
import com.sun.max.ide.*;
import com.sun.max.program.*;
import com.sun.max.program.option.*;

/**
 * Base class for assembler tests that defines program options common to
 * all assembler test harnesses. 
 * 
 * @author Doug Simon
 * @author Bernd Mathiske
 */
public abstract class AssemblerTestCase extends MaxTestCase {

    private StringProgramOption _templatePattern = new StringProgramOption("-pattern", "test only templates with the substring in their name", "<substring>");
    private IntegerProgramOption _startTemplateSerial = new IntegerProgramOption("-start", "serial number of first template to be tested") {
        @Override
        protected Integer unassignedDefaultValue() {
            return new Integer(0);
        }
    };
    private IntegerProgramOption _endTemplateSerial = new IntegerProgramOption("-end", "serial number of last template to be tested") {
        @Override
        protected Integer unassignedDefaultValue() {
            return Integer.MAX_VALUE;
        }
    };
    private BooleanProgramOption _onlyCreateExternalSource = new BooleanProgramOption("-only-make-asm-source", "creates assembler source file with tests for each template (no tests are run)");
    
    
    /**
     * Subclasses can override this to add extra program arguments.
     * <p>
     * <b>Note: this method is invoked while in a constructor of this class so
     *          subclasses cannot rely on their fields having been initialized</b>
     * 
     * @param programArgumentsParser
     */
    protected void addExtraProgramArguments(ProgramArgumentsParser programArgumentsParser) {
    }
    
    private void parseProgramArguments() {
        final ProgramArgumentsParser programArgumentsParser = new ProgramArgumentsParser(getClass().getSimpleName());
        programArgumentsParser.addProgramOption(new Trace());
        programArgumentsParser.addProgramOption(_templatePattern);
        programArgumentsParser.addProgramOption(_startTemplateSerial);
        programArgumentsParser.addProgramOption(_endTemplateSerial);
        programArgumentsParser.addProgramOption(_onlyCreateExternalSource);
        addExtraProgramArguments(programArgumentsParser);
        programArgumentsParser.parse(getProgramArguments());
    }

    public AssemblerTestCase() {
        super();
        parseProgramArguments();
    }

    public AssemblerTestCase(String name) {
        super(name);
        parseProgramArguments();
    }

    public void run(AssemblyTester tester) {
        tester.setTemplatePattern(_templatePattern.value());
        tester.run(_startTemplateSerial.value().intValue(), _endTemplateSerial.value().intValue(), _onlyCreateExternalSource.value());
    }
}

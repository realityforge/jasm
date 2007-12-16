/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e41a0fef-5a42-49fa-9b28-da61c85178be*/
package test.com.sun.max.asm;

import com.sun.max.asm.gen.AssemblyTester;
import com.sun.max.program.option.ProgramArgumentsParser;
import com.sun.max.program.option.StringProgramOption;

/**
 * Base class for assembler tests that use an external assembler which may
 * be executed remotely on another machine by using the '-remote=user@host'
 * program option.
 *
 * @author Doug Simon
 * @author Bernd Mathiske
 */
public abstract class ExternalAssemblerTestCase extends AssemblerTestCase {

    private StringProgramOption _remoteUserAndHost;
    private StringProgramOption _remoteAssemblerPath;

    /**
     * @return the option specifying the user and host for executing the external assembler on another machine
     */
    public StringProgramOption remoteUserAndHost() {
        if (_remoteUserAndHost == null) {
            _remoteUserAndHost = new StringProgramOption("-remote", "executes assembler command via ssh on %s", "<user>@<host>");
        }
        return _remoteUserAndHost;
    }

    /**
     * @return the option specifying the directory containing the external assembler on another machine
     */
    public StringProgramOption remoteAssemblerPath() {
        if (_remoteAssemblerPath == null) {
            _remoteAssemblerPath = new StringProgramOption("-remote-asm-path", "absolute path to directory containing assembler executable", "<path>");
        }
        return _remoteAssemblerPath;
    }

    @Override
    protected void addExtraProgramArguments(ProgramArgumentsParser programArgumentsParser) {
        programArgumentsParser.addProgramOption(remoteUserAndHost());
        programArgumentsParser.addProgramOption(remoteAssemblerPath());
    }

    public ExternalAssemblerTestCase() {
        super();
    }

    public ExternalAssemblerTestCase(String name) {
        super(name);
    }

    @Override
    public void run(AssemblyTester tester) {
        tester.setRemoteUserAndHost(_remoteUserAndHost.value());
        if (_remoteAssemblerPath.value() != null) {
            tester.setRemoteAssemblerPath(_remoteAssemblerPath.value());
        }
        super.run(tester);
    }
}

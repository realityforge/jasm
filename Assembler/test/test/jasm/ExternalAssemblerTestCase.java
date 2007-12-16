/*
 *  This file is part of the jasm project (http://code.google.com/p/jasm).
 *
 *  This file is licensed to you under the BSD License; You may not use
 *  this file except in compliance with the License. See the LICENSE.txt
 *  file distributed with this work for a copy of the License and information
 *  regarding copyright ownership.
 */
package test.jasm;

import com.sun.max.program.option.ProgramArgumentsParser;
import com.sun.max.program.option.StringProgramOption;
import jasm.gen.AssemblyTester;

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

    @Override
    public void run(AssemblyTester tester) {
        tester.setRemoteUserAndHost(_remoteUserAndHost.value());
        if (_remoteAssemblerPath.value() != null) {
            tester.setRemoteAssemblerPath(_remoteAssemblerPath.value());
        }
        super.run(tester);
    }
}

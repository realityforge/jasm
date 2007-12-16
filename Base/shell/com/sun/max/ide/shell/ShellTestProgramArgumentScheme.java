/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=113d3f65-0e38-45c3-a62a-ff62f8417c5c*/
package com.sun.max.ide.shell;

import com.sun.max.*;
import com.sun.max.annotate.*;
import com.sun.max.ide.*;

/**
 * @author Bernd Mathiske
 */
public final class ShellTestProgramArgumentScheme extends AbstractScheme implements TestProgramArgumentScheme {

    public ShellTestProgramArgumentScheme() {
    }

    private static final String PROGRAM_ARGUMENTS_ENV_VARIABLE = "test.arguments";
    
    private String[] _programArguments;
    
    @Implement(TestProgramArgumentScheme.class)
    public String[] getProgramArguments() {
        if (_programArguments == null) {
            final String args = System.getenv(PROGRAM_ARGUMENTS_ENV_VARIABLE);
            if (args != null) {
                _programArguments = args.split("\\s+");
            } else {
                _programArguments = new String[0];
            }
        }
        return _programArguments;
    }
}

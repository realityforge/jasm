/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=4c518900-e90e-4070-b185-6c49cda50572*/
package com.sun.max.ide.netbeans;

import com.sun.max.*;
import com.sun.max.annotate.*;
import com.sun.max.ide.TestProgramArgumentScheme;

/**
 * @author Bernd Mathiske
 */
public class NetbeansTestProgramArgumentsScheme extends AbstractScheme implements TestProgramArgumentScheme {
    
    public NetbeansTestProgramArgumentsScheme() {
    }
    
    private final String[] _testProgramArguments = {"-trace=1"};
    
    public String[] getProgramArguments() {
        return _testProgramArguments;
    }
    
}

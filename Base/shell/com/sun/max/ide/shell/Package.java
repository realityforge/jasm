/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=be5b587a-a982-4f06-996a-0c302e55460a*/
package com.sun.max.ide.shell;

import com.sun.max.*;
import com.sun.max.ide.*;

/**
 * @see MaxPackage
 * 
 * @author Greg Wright
 */
public class Package extends MaxPackage {

    public Package() {
        registerScheme(TestProgramArgumentScheme.class, ShellTestProgramArgumentScheme.class);
        registerScheme(ToolChainScheme.class, ShellToolChainScheme.class);
    }

}

/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=e60d5d3e-c1da-4623-92d8-892d33d23680*/
package com.sun.max.ide.eclipse;

import com.sun.max.*;
import com.sun.max.ide.*;

/**
 * @see MaxPackage
 * 
 * @author Bernd Mathiske
 */
public class Package extends MaxPackage {

    public Package() {
        registerScheme(TestProgramArgumentScheme.class, EclipseTestProgramArgumentScheme.class);
        registerScheme(ToolChainScheme.class, EclipseToolChainScheme.class);
    }
}

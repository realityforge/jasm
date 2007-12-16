/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=d9ac47e8-cb47-4274-8afc-bcad20325ff3*/
package com.sun.max.ide.netbeans;

import com.sun.max.*;
import com.sun.max.ide.*;

/**
 * @see MaxPackage
 * 
 * @author Bernd Mathiske
 */
public class Package extends MaxPackage {

    public Package() {
        registerScheme(TestProgramArgumentScheme.class, NetbeansTestProgramArgumentsScheme.class);
        registerScheme(ToolChainScheme.class, NetbeansToolChainScheme.class);
    }

}

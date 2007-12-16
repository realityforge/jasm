/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=f72f8803-e61f-42ba-9c1d-7f8b809c66b5*/
package com.sun.max.ide;

import com.sun.max.MaxPackage;
import java.io.IOException;

/**
 * @author Bernd Mathiske
 */
public final class ToolChain {

    private ToolChain() {
    }

    private static ToolChainScheme _toolChainScheme;

    private static ToolChainScheme toolChain() {
        if (_toolChainScheme == null) {
            final MaxPackage toolChainPackage = MaxPackage.fromName(IDE.current().idePackageName());
            _toolChainScheme = toolChainPackage.loadAndInstantiateScheme(ToolChainScheme.class);
        }
        return _toolChainScheme;
    }

    public static boolean compile(String className) throws IOException {
        return toolChain().compile(className);
    }

}
